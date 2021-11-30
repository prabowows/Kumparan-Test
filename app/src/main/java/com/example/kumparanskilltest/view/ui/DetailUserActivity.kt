package com.example.kumparanskilltest.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.model.AlbumItemModel
import com.example.kumparanskilltest.model.PhotosModel
import com.example.kumparanskilltest.model.response.GetThumbnailPhotosResponse
import com.example.kumparanskilltest.view.adapter.AlbumAdapter
import com.example.kumparanskilltest.view.adapter.PhotoAdapter
import com.example.kumparanskilltest.viewmodel.DetailUserViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUserActivity : AppCompatActivity() {

    lateinit var context: Context
    lateinit var detailUserViewModel: DetailUserViewModel
    private var userId = 0
    private lateinit var albumAdapter: AlbumAdapter
    private lateinit var photoAdapter: PhotoAdapter
    private var albumList: ArrayList<AlbumItemModel> = arrayListOf()
    lateinit var dialog: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)
        context = this@DetailUserActivity
        detailUserViewModel = ViewModelProvider(this).get(DetailUserViewModel::class.java)
        processIntent()
        setListener()
        dialog = BottomSheetDialog(context, R.style.BottomSheetDialog)
    }

    private fun processIntent() {
        userId = intent.getIntExtra(PARAM_USER_ID, 0)
    }

    private fun getDetailUser() {
        detailUserViewModel.getDetailUser(userId.toString())?.observe(this, Observer {
            detailPostProgressBar.visibility = View.GONE
            var userData = it.firstOrNull()
            valueNameTextView.text = userData?.name
            valueEmailTextView.text = userData?.email
            valueAddressTextView.text = ("${userData?.address?.street}, ${userData?.address?.suite}, ${userData?.address?.city}, ${userData?.address?.zipcode}")
            valueCompanyTextView.text = userData?.company?.name
        })
    }

    private fun getAlbumUser() {
        detailUserViewModel.getAlbumUser(userId.toString())?.observe(this, Observer {
            albumList = it
            setupAdapter()
        })
    }

    private fun setListener() {
        if (userId != 0) {
            detailPostProgressBar.visibility = View.GONE
            getDetailUser()
            getAlbumUser()
        }

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun setupAdapter() {
        albumAdapter = AlbumAdapter(
            context = this,
            items = albumList,
            onClick = {
                openThumbnail(it)
            }
        )
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        userAlbumRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        userAlbumRecyclerView.adapter = albumAdapter
    }

    private fun getThumbnailImage(albumId: Int?) {
        detailUserViewModel.getThumbnailPhotoUser(albumId.toString())?.observe(this, Observer {
            if (it != null) {
                fetchThumbnailData(response = it )
            }
        })
    }

    private fun fetchThumbnailData(response: GetThumbnailPhotosResponse) {
        detailPostProgressBar.visibility = View.GONE
        if (dialog.isShowing.not()) {
            var listData: ArrayList<PhotosModel> = arrayListOf()
            response.forEach { photo ->
                listData.add(photo)
            }
            showBottomSheet(listData)
        }
    }

    private fun openThumbnail(albumId: Int?) {
        detailPostProgressBar.visibility = View.VISIBLE
        getThumbnailImage(albumId)
    }

    private fun showBottomSheet(list: ArrayList<PhotosModel>) {

        val view = layoutInflater.inflate(R.layout.thumbnail_bottom_sheet, null)
        val btnClose = view.findViewById<Button>(R.id.closeBottomSheet)
        btnClose.setOnClickListener {
            dialog.dismiss()
        }

        val photoRecyclerView = view.findViewById<RecyclerView>(R.id.thumbnailRecyclerView)
        setupThumbnailAdapter(list, photoRecyclerView)

        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
    }

    private fun setupThumbnailAdapter(
        listPhoto: ArrayList<PhotosModel>,
        recyclerView: RecyclerView
    ) {
        photoAdapter = PhotoAdapter(
            context = this,
            items = listPhoto,
            onClick = { photoUrl, photoTitle ->
                startActivity(
                    FullImageActivity.onNewIntent(
                        context = this,
                        url = photoUrl,
                        title = photoTitle
                    )
                )
            }
        )
        setupThumbnailRecyclerView(recyclerView)
    }

    private fun setupThumbnailRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = photoAdapter
    }

    companion object {

        const val PARAM_USER_ID = "extra_user_id"

        fun onNewIntent(context: Context, userId: Int?): Intent {
            val intent = Intent(context, DetailUserActivity::class.java)
            intent.putExtra(PARAM_USER_ID, userId)
            return intent
        }
    }
}