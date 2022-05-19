package com.example.serkan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.serkan.UserAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.example.User
import com.example.serkan.databinding.ActivityMainBinding
import com.example.serkan.databinding.ItemlistBinding
import com.example.serkan.databinding.PublicacionesBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }
    private lateinit var nActiveFragment: androidx.cardview.widget.CardView
    private lateinit var nFragmentManager: ViewBinding
    private lateinit var binding: ActivityMainBinding
    private lateinit var adarter: UserAdapter
    private val userdate = mutableListOf<User>()
    private lateinit var binding1: ActivityMainBinding
    private lateinit var adarterPost: PostaAdapter
    private val userpost = mutableListOf<PostUser>()



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

        }

   /* override fun verMas(postvista: LiveData<RequesUser<MutableList<PostUser>>>) {
        userViewModel.getDatosPost()
        userViewModel.getPostvista().observe(this) {
            when (it) {
                is RequesUser.OnSuccess -> {
                    userpost.clear()
                    userpost.addAll(it.data)
                    adarter.notifyDataSetChanged()

                }
            }


        }
    }*/




    private fun initRecylerView() {

        adarter = UserAdapter(userdate)
        binding.rvlista.layoutManager = LinearLayoutManager(this)
        binding.rvlista.adapter = adarter
    }



    private fun initRecylerViewPOST() {

        adarterPost = PostaAdapter(userpost)


    }
}





