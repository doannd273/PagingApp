package com.example.paggingapp.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paggingapp.data.model.PostDto
import com.example.paggingapp.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    val postsStream: Flow<PagingData<PostDto>> = getPostsUseCase().cachedIn(viewModelScope)
}