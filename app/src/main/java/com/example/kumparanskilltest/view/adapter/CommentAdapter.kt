package com.example.kumparanskilltest.view.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.base.extension.Helper.inflate
import com.example.kumparanskilltest.model.CommentItemModel
import kotlinx.android.synthetic.main.item_comment.view.*

class CommentAdapter(
    context: Context,
    items: MutableList<CommentItemModel>,
    val onClick: (Int?) -> Unit?
) :
    RecyclerAdapter<CommentItemModel, CommentAdapter.Item>(context, items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Item {
        return Item(parent.inflate(R.layout.item_comment))
    }

    inner class Item(itemYear: View) : BaseViewHolder(itemYear) {
        override fun bind(item: CommentItemModel) {
            itemView.nameCommentTextView.text = item.name
            itemView.emailCommentTextView.text = item.email
            itemView.bodyCommentTextView.text = item.body
            itemView.setOnClickListener {
                onClick(item.id)
            }
        }
    }

    override fun loadMore() {}
}