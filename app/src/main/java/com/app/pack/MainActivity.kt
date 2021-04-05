package com.app.pack

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.pack.adapter.PostAdapter
import com.app.pack.databinding.ActivityMainBinding
import com.app.pack.util.ApiState
import com.app.pack.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postAdapter: PostAdapter
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerview()

        viewModel.getPost()

        lifecycleScope.launchWhenStarted {
            // because we added suspend should be called in coroutine suspend
            viewModel.postState.collect {
                when(it){
                    is ApiState.Loading -> {
                        binding.progress.visibility  = View.VISIBLE
                    }
                    is ApiState.Failure -> {
                        binding.progress.visibility  = View.GONE
                        Log.e("msg",""+it.msg)
                    }
                    is ApiState.Success -> {
                        binding.progress.visibility  = View.GONE
                        postAdapter.setData(it.data)
                    }
                    is ApiState.Empty -> {

                    }
                }
            }
        }
    }

    private fun initRecyclerview(){
        postAdapter = PostAdapter(ArrayList())

        binding.recyclerview.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}