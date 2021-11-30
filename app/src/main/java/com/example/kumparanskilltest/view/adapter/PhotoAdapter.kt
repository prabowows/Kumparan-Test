package com.example.kumparanskilltest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.base.extension.Helper
import com.example.kumparanskilltest.base.extension.Helper.inflate
import com.example.kumparanskilltest.model.PhotosModel
import kotlinx.android.synthetic.main.activity_detail_post.*
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(
    context: Context,
    items: MutableList<PhotosModel>,
    val onClick: (String, String) -> Unit?
) :
    RecyclerAdapter<PhotosModel, PhotoAdapter.Item>(context, items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item {
        return Item(parent.inflate(R.layout.item_photo))
    }

    inner class Item(itemYear: View) : BaseViewHolder(itemYear) {
        override fun bind(item: PhotosModel) {
            Helper.loadImage(context, item.thumbnailUrl.orEmpty(), itemView.photoImageView)
            itemView.titlePhotoTextView.text = item.title
            itemView.setOnClickListener {
                onClick(item.url.orEmpty(), item.title.orEmpty())
            }
        }
    }

    override fun loadMore() {}
}