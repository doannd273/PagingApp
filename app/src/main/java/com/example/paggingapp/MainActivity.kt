package com.example.paggingapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.example.paggingapp.databinding.ActivityMainBinding
import com.example.paggingapp.presentation.adapter.PostAdapter
import com.example.paggingapp.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val postAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
        observeData()
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.adapter = postAdapter

        // lắng nghe trạng thái Load (Loading, Error, Success) của Paging 3
        postAdapter.addLoadStateListener { loadState ->
            val isInitialLoading = loadState.refresh is LoadState.Loading
            binding.progressBar.isVisible = isInitialLoading
        }
    }

    private fun observeData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.postsStream.collectLatest { pagingData ->
                    postAdapter.submitData(pagingData)
                }
            }
        }
    }
}
