package com.ec.sequence1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ec.sequence1.adapter.PostAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.list)
        val posts: MutableList<Post> = mutableListOf()

        repeat(100_000) {
            val post = Post(
                title = "title $it",
                subTitle = "subTitle $it"
            )
            posts.add(post)
        }

        recyclerview.adapter = PostAdapter(posts)
        recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }


}