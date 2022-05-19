package com.example.serkan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.example.User
import com.example.serkan.databinding.ItemlistBinding
import com.example.serkan.databinding.PostItemBinding
import com.squareup.picasso.RequestCreator

class PostaAdapter (private val posts: List<PostUser>): RecyclerView.Adapter<PostaAdapter.UserViewHol>()  {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHol {
        return UserViewHol(
            LayoutInflater.from(parent.context).inflate(R.layout.publicaciones, parent, false)
        )
    }



    override fun onBindViewHolder(holder: UserViewHol, position: Int) {
        val item: String = posts[position].titleUser?: ""
        holder.bing(item)
        val item1: String = posts[position].bodyUser ?: ""
        holder.bing1(item1)

    }

    override fun getItemCount(): Int = posts.size

    inner class UserViewHol(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = PostItemBinding.bind(view)



        fun bing(title: String) {
            binding.viewtitle.text= title
        }
        fun bing1(description: String) {
            binding.viewdescription.text= description
        }

    }



}

private fun RequestCreator.into(cvtarjeta: CardView) {

}

