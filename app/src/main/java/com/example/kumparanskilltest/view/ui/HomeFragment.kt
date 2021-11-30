package com.example.kumparanskilltest.view.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.model.PostModel
import com.example.kumparanskilltest.model.UserDataModel
import com.example.kumparanskilltest.view.adapter.PostAdapter
import com.example.kumparanskilltest.viewmodel.MainActivityViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_main.*

class HomeFragment : Fragment() {
    lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var postAdapter: PostAdapter
    private var postList: ArrayList<PostModel> = arrayListOf()
    lateinit var dialog: BottomSheetDialog
    private lateinit var mContext : Context

    override fun onCreateView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setListener()
        dialog = BottomSheetDialog(this.requireContext(), R.style.BottomSheetDialog)
    }

    private fun setListener() {
        mainActivityViewModel.getAllPost()?.observe(this.viewLifecycleOwner, Observer {
            mainProgressBar.visibility = View.GONE
            postList = it
            setupAdapter()
        })
    }

    private fun setupAdapter() {
        postAdapter = PostAdapter(
            context = mContext,
            items = postList,
            onClick = { postId ->
                startActivity(DetailPostActivity.onNewIntent(this.requireContext(), postId ?: 0))
            },
            onClickButton = { authorId ->
                seeAuthor(authorId)
            }
        )
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        postRecyclerView.layoutManager = LinearLayoutManager(this.requireContext(), LinearLayoutManager.VERTICAL, false)
        postRecyclerView.adapter = postAdapter
    }

    private fun showBottomSheet(userData: UserDataModel?) {

        val view = layoutInflater.inflate(R.layout.author_bottom_sheet, null)
        val btnClose = view.findViewById<Button>(R.id.closeBottomSheet)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }

        val nameAuthor = view.findViewById<TextView>(R.id.valueNameTextView)
        val emailAuthor = view.findViewById<TextView>(R.id.valueEmailTextView)
        val companyAuthor = view.findViewById<TextView>(R.id.valueCompanyTextView)
        val addressAuthor = view.findViewById<TextView>(R.id.valueAddressTextView)

        nameAuthor.text = userData?.name
        emailAuthor.text = userData?.email
        companyAuthor.text = ("${userData?.address?.street}, ${userData?.address?.suite}, ${userData?.address?.city}, ${userData?.address?.zipcode}")
        addressAuthor.text = userData?.company?.name

        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
    }

    private fun seeAuthor(userId: Int?) {
        mainProgressBar.visibility = View.VISIBLE
        mainActivityViewModel.getDetailUser(userId.toString())?.observe(this.viewLifecycleOwner, Observer {
            if (it != null) {
                mainProgressBar.visibility = View.GONE
                if (dialog.isShowing.not()) {
                    showBottomSheet(it.firstOrNull())
                }
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}