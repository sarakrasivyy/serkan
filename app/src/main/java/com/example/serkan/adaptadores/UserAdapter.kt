package com.example.serkan.adaptadores

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.serkan.R
import com.example.serkan.databinding.ItemlistBinding
import com.example.serkan.databinding.PublicacionesBinding

class UserAdapter(
    private val users: List<User>,
    val clickClosure: (User) -> Unit,

) : RecyclerView.Adapter<UserAdapter.UserViewHol>() {

    /*interface clicker{
        fun verMas(postvista: LiveData<RequesUser<MutableList<PostUser>>>){

val
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
        holder.bindClick()
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
        }
        fun bing3(id: String) {
            binding.tviduser.text = id
        }
       /* fun bingboton(clickClosur: String) {
            binding..setOnClickListener { clickActionPost.verMas(vermas.getPostvista()) }
            }*/

    /*  fun bingVista(item:View) {
               binding.btVerMas.setOnClickListener { binding1.cvtarjetapost }
            }
*/

      /*  fun bingVer(vermas: UserViewModel) {
             //   binding.btVerMas.setOnClickListener { clickActionPost.verMas(vermas.getPostvista()) }
            }*/

        fun bindClick(){
            binding.buttonactivation.setOnClickListener {
                startActivity(Intent( this, PublicacionesBinding::class.java))
                println("hicieron click sobre te")

            }
        }

    }
}






