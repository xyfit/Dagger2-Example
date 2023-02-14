package com.example.dagger2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2example.databinding.ActivityMainBinding
import com.example.restapiexample.api.NetManager
import com.example.restapiexample.api.RetrofitService
import com.example.restapiexample.repository.MainRepository
import com.example.restapiexample.viewmodel.MainViewModel
import com.example.restapiexample.viewmodel.MyViewModelFactory
import com.example.roomexample.adapter.ListAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private val listAdapter by lazy { ListAdapter() }

    @Inject
    lateinit var mainRepository : MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.app.appComponent.myInject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        DaggerA

//        val retrofitService = NetManager.getInstance()
//        val mainRepository = MainRepository(retrofitService)

        viewModel = ViewModelProvider(this , MyViewModelFactory(mainRepository))[MainViewModel::class.java]
        initLiveData()
        initRec()
        loadData()
    }
    private fun initRec() {
        binding.recId.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listAdapter
        }
        listAdapter.setOnItemClickListener{
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
        }
    }
    private fun loadData() {
        viewModel.getAllMovies()
    }

    private fun initLiveData() {
        viewModel.movieList.observe(this){
            listAdapter.baseList = it
        }
        viewModel.errorMessage.observe(this){
            Toast.makeText(this, "Error:  $it", Toast.LENGTH_SHORT).show()
        }
    }
}