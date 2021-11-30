package com.example.kumparanskilltest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.base.extension.Helper.inflate
import com.example.kumparanskilltest.model.AlbumItemModel
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumAdapter(
    context: Context,
    items: MutableList<AlbumItemModel>,
    val onClick: (Int?) -> Unit?
) :
    RecyclerAdapter<AlbumItemModel, AlbumAdapter.Item>(context, items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item {
        return Item(parent.inflate(R.layout.item_album))
    }

    inner class Item(itemYear: View) : BaseViewHolder(itemYear) {
        override fun bind(item: AlbumItemModel) {
            itemView.nameAlbumTextView.text = item.title
            itemView.setOnClickListener {
                onClick(item.id)
            }
            itemView.openPhoto.setOnClickListener {
                onClick(item.id)
            }
        }
    }

    override fun loadMore() {}
}