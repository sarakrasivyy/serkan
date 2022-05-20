package com.example.serkan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class MainActivity : AppCompatActivity(){

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }
    private val postViewModel: PostViewModel by lazy {
        ViewModelProvider(this)[PostViewModel::class.java]
    }
    private lateinit var nActiveFragment: androidx.cardview.widget.CardView
    private lateinit var nFragmentManager: ViewBinding
    private lateinit var binding: ActivityMainBinding
    private lateinit var adarter: UserAdapter
    private val userdate = mutableListOf<User>()
    private lateinit var binding1: ActivityMainBinding
    private lateinit var adarterPost: PostaAdapter
    private val userpost = mutableListOf<PostUser>()
    private lateinit var nbinding: ActivityMainBinding

    private lateinit var kbinding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        initRecylerView()
        initRecylerViewPOST()




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
        postViewModel.getDatosPost()
        postViewModel.getPostvistaLiveData().observe(this) {
            when (it) {
                is RequesUser.OnSuccess -> {
                    userpost.clear()
                    userpost.addAll(it.data)
                  print(it.data)

                }
            }

        }

        }

   /*override fun verMas(postvista: LiveData<RequesUser<MutableList<PostUser>>>) {
        userViewModel.getDatosPost()
        userViewModel.getPostvista().observe(this) {
            when (it) {
                is RequesUser.OnSuccess -> {
                    userpost.clear()
                    userpost.addAll(it.data)
                    adarter.notifyDataSetChanged()

                }
            }
                binding.root.setOnClickListener {
                onclickListener(image)
                positionListener(position.toString())
            }

        }
    }*/




    private fun initRecylerView() {

        adarter = UserAdapter(
            userdate,
            clickClosure = {
                binding.root.setOnClickListener {
                   //  View.OnClickListener(adarterPost)
                }
            },
        )
        binding.rvlista.layoutManager = LinearLayoutManager(this)
        binding.rvlista.adapter = adarter
    }



    private fun initRecylerViewPOST() {

        adarterPost = PostaAdapter(userpost)


    }
}





