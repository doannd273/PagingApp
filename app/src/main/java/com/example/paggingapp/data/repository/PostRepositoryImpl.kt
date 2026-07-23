package com.example.paggingapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.paggingapp.data.datasource.PostPagingSource
import com.example.paggingapp.data.model.PostDto
import com.example.paggingapp.data.remote.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) {
    fun getPostsStream(): Flow<PagingData<PostDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = PostPagingSource.PAGE_SIZE,
                prefetchDistance = 5,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PostPagingSource(apiService) }
        ).flow
    }
}
