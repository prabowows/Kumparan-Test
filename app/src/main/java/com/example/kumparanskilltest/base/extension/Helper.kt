package com.example.kumparanskilltest.base.extension

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.github.chrisbanes.photoview.PhotoView

object Helper {
    fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }

    fun loadImage(
        context: Context,
        url: String,
        imageView: ImageView
    ) {
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_input_get)
            .error(R.drawable.ic_menu_report_image)

        val customUrl = GlideUrl(
            url, LazyHeaders.Builder()
                .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
                .build()
        )

        Glide.with(context)
            .load(customUrl)
            .apply(options)
            .centerCrop()
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    return false
                }

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    Log.i("Error Glide", e.toString() )
                    return false
                }
            })
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    imageView.background = resource
                }
                override fun onLoadCleared(placeholder: Drawable?) {}
            })
    }

    fun loadImageZoomAble(context: Context,
                          url: String,
                          imageView: ImageView){
        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.ic_menu_gallery)
            .error(R.drawable.ic_menu_gallery)

        val customUrl = GlideUrl(
            url, LazyHeaders.Builder()
                .addHeader("User-Agent", WebSettings.getDefaultUserAgent(context))
                .build()
        )

        Glide.with(context)
            .load(customUrl)
            .apply(options)
            .listener(object : RequestListener<Drawable> {
                override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                    return false
                }

                override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                    Toast.makeText( context, "Failed to Render Image, Please Try Again",Toast.LENGTH_SHORT).show()
                    return false
                }
            })
            .into(imageView)
    }
}
