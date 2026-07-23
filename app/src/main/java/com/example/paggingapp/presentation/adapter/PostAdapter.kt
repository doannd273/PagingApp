package com.example.paggingapp.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paggingapp.data.model.PostDto
import com.example.paggingapp.databinding.ItemPostBinding

class PostAdapter : PagingDataAdapter<PostDto, PostAdapter.PostViewHolder>(COMPARATOR) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PostViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }


    class PostViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(post: PostDto) {
            binding.tvTitle.text = "${post.id}. ${post.title}"
            binding.tvBody.text = post.body
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<PostDto>() {
            override fun areItemsTheSame(oldItem: PostDto, newItem: PostDto): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: PostDto, newItem: PostDto): Boolean = oldItem == newItem
        }
    }
}