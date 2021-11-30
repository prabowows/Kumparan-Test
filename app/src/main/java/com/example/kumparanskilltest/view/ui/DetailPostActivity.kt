package com.example.kumparanskilltest.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.model.CommentItemModel
import com.example.kumparanskilltest.view.adapter.CommentAdapter
import com.example.kumparanskilltest.viewmodel.DetailPostViewModel
import kotlinx.android.synthetic.main.activity_detail_post.*
import kotlinx.android.synthetic.main.activity_detail_post.detailPostProgressBar
import kotlinx.android.synthetic.main.activity_detail_post.toolbar

class DetailPostActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var detailPostViewModel: DetailPostViewModel
    private var postId = 0
    private var authorUserId = 0
    private lateinit var detailPostAdapter: CommentAdapter
    private var commentList: ArrayList<CommentItemModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_post)
        context = this@DetailPostActivity
        detailPostViewModel = ViewModelProvider(this).get(DetailPostViewModel::class.java)
        processIntent()
        setListener()
    }

    private fun processIntent() {
        postId = intent.getIntExtra(PARAM_ID, 0)
    }

    private fun setListener() {
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        authorInfoView.setOnClickListener {
            startActivity(DetailUserActivity.onNewIntent(this, authorUserId))
        }

        if (postId != 0) {
            detailPostProgressBar.visibility = View.VISIBLE
            detailPostViewModel.getDetailPost(postId.toString())?.observe(this, Observer {
                authorUserId = it.userId ?: 0
                getAuthorName()
                detailPostProgressBar.visibility = View.GONE
                detailTitlePostTextView.text = it.title
                detailBodyPostTextView.text = it.body
            })

            detailPostViewModel.getComment(postId.toString())?.observe(this, Observer {
                commentList = it
                setupAdapter()
            })
        }
    }

    private fun getAuthorName() {
        detailPostViewModel.getDetailUser(authorUserId.toString())?.observe(this, Observer {
            if (it != null) {
                authorInfoTextView.text = "Author: ${it.firstOrNull()?.name}"
            }
        })
    }

    private fun setupAdapter() {
        detailPostAdapter = CommentAdapter(
            context = this,
            items = commentList,
            onClick = {}
        )
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        commentDetailPostReview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        commentDetailPostReview.adapter = detailPostAdapter
    }

    companion object {

        const val PARAM_ID = "extra_id"

        fun onNewIntent(context: Context, postId: Int?): Intent {
            val intent = Intent(context, DetailPostActivity::class.java)
            intent.putExtra(PARAM_ID, postId)
            return intent
        }
    }
}