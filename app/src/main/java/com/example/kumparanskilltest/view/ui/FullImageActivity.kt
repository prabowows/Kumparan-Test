package com.example.kumparanskilltest.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kumparanskilltest.R
import com.example.kumparanskilltest.base.extension.Helper
import kotlinx.android.synthetic.main.activity_full_image.*

class FullImageActivity : AppCompatActivity() {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)
        context = this@FullImageActivity
        processImage()
    }

    private fun processImage() {
        intent.getStringExtra(PARAM_URL)?.let {
            Helper.loadImageZoomAble(this, it, fullImageView)
        }

        intent.getStringExtra(PARAM_TITLE)?.let {
            titleImageTextView.text = it
        }
    }

    companion object {
        const val PARAM_URL = "extra_url"
        const val PARAM_TITLE = "extra_title"

        fun onNewIntent(context: Context, url: String?, title: String): Intent {
            val intent = Intent(context, FullImageActivity::class.java)
            intent.putExtra(PARAM_URL, url)
            intent.putExtra(PARAM_TITLE, title)
            return intent
        }
    }
}