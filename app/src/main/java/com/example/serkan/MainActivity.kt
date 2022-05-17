package com.example.serkan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.serkan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider(this)[UserViewModel::class.java]
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var adarter: UserAdapter
    private val userdate = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecylerView()
        userViewModel.getDatosVista()



    }

    private lateinit var mostrarContactos: ArrayList<DatosUser>


    private fun initRecylerView() {
        adarter = UserAdapter(userdate)
        binding.rvlista.layoutManager = LinearLayoutManager(this)
        binding.rvlista.adapter = adarter
    }



    }
