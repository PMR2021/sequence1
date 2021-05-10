package com.ec.sequence1.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ec.sequence1.Post
import com.ec.sequence1.R

class PostAdapter(val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        Log.d("PostAdapter", "onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)
        val layoutId = if(viewType == BIG_ITEM_VIEW) {
            R.layout.item_big
        }else {
            R.layout.item_small
        }
        return PostViewHolder(itemView = inflater.inflate(layoutId, parent, false))
    }

    override fun getItemViewType(position: Int): Int {
     return   if( position == 0) {
         BIG_ITEM_VIEW
        }else {
         SMALL_ITEM_VIEW
        }
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        Log.d("PostAdapter", "onBindViewHolder position $position")
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    class PostViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.title)
        val subTitleTextView = itemView.findViewById<TextView>(R.id.subtitle)
        val image = itemView.findViewById<ImageView>(R.id.image)

        fun bind(post: Post) {
            titleTextView.text = post.title
            subTitleTextView.text = post.subTitle
            image.setImageResource(R.drawable.image1)
        }

    }

    companion object {
        private const val BIG_ITEM_VIEW = 1
        private const val SMALL_ITEM_VIEW = 2

    }

}