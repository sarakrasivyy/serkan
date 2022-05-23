package com.example.serkan

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.SearchView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.serkan.adaptadores.PostaAdapter
import com.example.serkan.adaptadores.User
import com.example.serkan.adaptadores.UserAdapter
import com.example.serkan.apiService.PostUser
import com.example.serkan.databinding.ActivityMainBinding
import com.example.serkan.databinding.PublicacionesBinding
import com.example.serkan.viewModel.PostViewModel
import com.example.serkan.viewModel.UserViewModel
import java.util.*
import java.util.Locale.filter
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(){

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }
    private val postViewModel: PostViewModel by lazy {
        ViewModelProvider(this)[PostViewModel::class.java]
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adarter: UserAdapter
    private val userdate = mutableListOf<User>()
    private val postdate = listOf<PostUser>()
    private lateinit var adarterPost: PostaAdapter
    private val userpost = mutableListOf<PostUser>()



    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        initRecylerView()
        initRecylerViewPOST()
        botton()


        userViewModel.getDatosVista()
        userViewModel.getUservista().observe(this) {
            when (it) {
                is RequesUser.OnSuccess -> {
                    userdate.clear()
                    userdate.addAll(it.data)
                    adarter.notifyDataSetChanged()

                }
            }

        }

        //postViewModel.getDatosPost()
        postViewModel.getPostvistaLiveData().observe(this) {
            when (it) {
                is RequesUser.OnSuccess -> {
                    userpost.clear()
                    userpost.addAll(it.data)
                    adarterPost.notifyDataSetChanged()
                  //print(it.data)

                }
            }

        }

        }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)


    }


    private fun initRecylerView() {


        adarter = UserAdapter(
            userdate,postdate,
            clickClosure = { user ->
                binding.rvlista.visibility = View.GONE
                binding.rvPost2.visibility = View.VISIBLE
                println("hicieron click sobre te ")
                    if (user != null) {
                        user.id?.let { id -> postViewModel.getDatosPost(id) }
                    }
            }
        )
        binding.rvlista.layoutManager = LinearLayoutManager(this)
        binding.rvlista.adapter = adarter


    }
    fun botton(){
        binding.btvolvercontactos.setOnClickListener {
            binding.rvlista.visibility = View.VISIBLE
            binding.rvPost2.visibility = View.GONE
        }
    }




    private fun initRecylerViewPOST() {

        adarterPost = PostaAdapter(
            userpost
        )
        binding.rvPost2.layoutManager = LinearLayoutManager(this)
        binding.rvPost2.adapter = adarterPost


    }
}





