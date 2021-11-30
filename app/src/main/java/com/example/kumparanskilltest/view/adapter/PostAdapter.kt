package com.example.kumparanskilltest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.base.extension.Helper.inflate
import com.example.kumparanskilltest.model.PostModel
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(
    context: Context,
    items: MutableList<PostModel>,
    val onClick: (Int?) -> Unit?,
    val onClickButton: (Int?) -> Unit?
) :
    RecyclerAdapter<PostModel, PostAdapter.PostItem>(context, items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostItem {
        return PostItem(parent.inflate(R.layout.item_post))
    }

    inner class PostItem(itemYear: View) : BaseViewHolder(itemYear) {
        override fun bind(item: PostModel) {
            itemView.titlePostTextView.text = item.title
            itemView.bodyPostTextView.text = item.body
            itemView.setOnClickListener {
                onClick(item.id)
            }
            itemView.authorButton.setOnClickListener {
                onClickButton(item.userId)
            }
        }
    }

    override fun loadMore() {}
}