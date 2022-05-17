package com.example.serkan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.serkan.databinding.ItemlistBinding
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator

class UserAdapter (private val users: List<String>) : RecyclerView.Adapter<UserAdapter.UserViewHol>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHol {
        return UserViewHol(
            LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false)
        )
    }


    override fun onBindViewHolder(holder: UserViewHol, position: Int) {

        val item: String = users[position]
        holder.bing3(item)
        val item1: String = users[position]
        holder.bing1(item1)
        val item2: String = users[position]
        holder.bing2(item2)

    }

    override fun getItemCount(): Int = users.size

    inner class UserViewHol(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemlistBinding.bind(view)
        private val binding1= ItemlistBinding.bind(view)
        private val binding2= ItemlistBinding.bind(view)


        fun bing3(nombre: String) {
            binding.viewnombre.text= nombre
         }
        fun bing1(telefono: String) {
            binding1.viewtelefono.text= telefono
         }
        fun bing2(email: String) {
            binding2.viewemail.text= email
         }
    }
}

private fun RequestCreator.into(cvtarjeta: CardView) {

}
