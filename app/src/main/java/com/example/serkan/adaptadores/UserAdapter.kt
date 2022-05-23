package com.example.serkan.adaptadores

import android.content.Intent
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.serkan.MainActivity
import com.example.serkan.R
import com.example.serkan.apiService.PostUser
import com.example.serkan.databinding.ActivityMainBinding
import com.example.serkan.databinding.ItemlistBinding
import com.example.serkan.databinding.PostItemBinding
import com.example.serkan.databinding.PublicacionesBinding
import com.example.serkan.databinding.PublicacionesBinding.bind

class UserAdapter(
    private val users: List<User>,
    private val post: List<PostUser>,
    val clickClosure: (User) -> Unit,

) : RecyclerView.Adapter<UserAdapter.UserViewHol>() {


    fun getData(): List<User> {
        return this.users
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHol {
        return UserViewHol(
            LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false))
getData()

    }


    override fun onBindViewHolder(holder: UserViewHol, position: Int) {

        val item: String = users[position].name ?: ""
        holder.bing(item)

        val item1: String = users[position].phone ?: ""
        holder.bing1(item1)

        val item2: String = users[position].email ?: ""
        holder.bing2(item2)

        val item3: String = users[position].id.toString()
        holder.bing3(item3)

        holder.bindClick(users[position])

    }

    override fun getItemCount(): Int = users.size

    inner class UserViewHol(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemlistBinding.bind(view)

        fun bing(nombre: String) {
            binding.viewnombre.text = nombre
        }

        fun bing1(telefono: String) {
            binding.viewtelefono.text = telefono

        }

        fun bing2(email: String) {
            binding.viewemail.text = email
        }
        fun bing3(id: String) {
            binding.tviduser.text = id
        }


        fun bindClick(user: User){

                binding.buttonactivation.setOnClickListener {

                    clickClosure(user)

            }
        }

    }
}






