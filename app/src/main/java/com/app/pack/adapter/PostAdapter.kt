package com.app.pack.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.app.pack.databinding.ActivityMainBinding
import com.app.pack.databinding.RawLayoutBinding
import com.app.pack.model.Post

class PostAdapter(private var posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    private lateinit var binding: RawLayoutBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PostViewHolder {
       binding = RawLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.id.text = posts[position].id.toString()
        binding.userid.text = posts[position].userID.toString()
        binding.title.text = posts[position].title.toString()
        binding.body.text = posts[position].body.toString()
    }

    override fun getItemCount(): Int = posts.size


    class PostViewHolder(view:View) : RecyclerView.ViewHolder(view)

    fun setData(posts: List<Post>){
        this.posts = posts
        notifyDataSetChanged()
    }

}