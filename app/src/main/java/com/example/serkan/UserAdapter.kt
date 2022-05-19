package com.example.serkan

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.example.User
import com.example.serkan.databinding.ItemlistBinding
import com.example.serkan.databinding.PublicacionesBinding
import com.squareup.picasso.RequestCreator

class UserAdapter (private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHol>() {

    /*interface clicker{
        fun verMas(postvista: LiveData<RequesUser<MutableList<PostUser>>>){


        }*/




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHol {
        return UserViewHol(
            LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false)
        )
    }


    override fun onBindViewHolder(holder: UserViewHol, position: Int) {

        val item: String = users[position].name ?: ""
        holder.bing(item)
      //  holder.bing4(item)
        val item1: String = users[position].phone ?: ""
        holder.bing1(item1)
      //  holder.bing4Tel(item1)
        val item2: String = users[position].email ?: ""
        holder.bing2(item2)
      //  holder.bing4email(item2)
        /*val item3: OnClickAction
        holder.bing4(nombre = (item),telefono =(item1),email =(item2))
*/


    }

    override fun getItemCount(): Int = users.size

    inner class UserViewHol(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemlistBinding.bind(view)
       // private val binding1 = PublicacionesBinding.bind(view)
      //  private val binding2 = ItemlistBinding.bind(view)


/*
        fun bing4(nombre: String){
            binding1.tvname.text=nombre

        }fun bing4Tel(telefono: String){
            binding1.tvphone.text=telefono

        }fun bing4email(email: String){
            binding1.tvemail.text= email
        }*/


        fun bing(nombre: String) {
            binding.viewnombre.text = nombre
        }

        fun bing1(telefono: String) {
            binding.viewtelefono.text = telefono
        }

        fun bing2(email: String) {
            binding.viewemail.text = email
/*

      fun bingVista(item:View) {
               binding.btVerMas.setOnClickListener { binding1.cvtarjetapost }
            }
*/

      /*  fun bingVer(vermas: UserViewModel) {
             //   binding.btVerMas.setOnClickListener { clickActionPost.verMas(vermas.getPostvista()) }
            }*/
        }
    }
}




