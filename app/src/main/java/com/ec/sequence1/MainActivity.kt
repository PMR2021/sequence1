package com.ec.sequence1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list : LinearLayout = this.findViewById(R.id.list)
        val item = layoutInflater.inflate(R.layout.item,list,false)
        val post = Post(
            title = "title",
            subTitle = "subTitle"
        )

        repeat(100_000) { index ->
            val item = layoutInflater.inflate(R.layout.item,list,false)
            list.addView(item)
            val titleTextView = item.findViewById<TextView>(R.id.title)
            val subTitleTextView = item.findViewById<TextView>(R.id.subtitle)
            val imageView = item.findViewById<ImageView>(R.id.image)
            titleTextView.text = "${post.title} $index"
            subTitleTextView.text = "${post.subTitle} $index"
            imageView.setImageResource(R.drawable.image1)

        }

    }


    data class Post(
        val title : String,
        val subTitle : String
    )
}