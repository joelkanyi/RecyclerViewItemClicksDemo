package com.kanyideveloper.recyclerviewitemclicksdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kanyideveloper.recyclerviewitemclicksdemo.databinding.RecyclerRowBinding

class RecyclerAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Photo, RecyclerAdapter.MyViewHolder>(MyDiffUtil) {
    companion object MyDiffUtil : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }
    }

    inner class MyViewHolder(private val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Photo?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }
        holder.bind(item)
    }

    class OnClickListener(val clickListener: (photo: Photo) -> Unit) {
        fun onClick(photo: Photo) = clickListener(photo)
    }
}