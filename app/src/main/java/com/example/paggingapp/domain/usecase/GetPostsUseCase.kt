package com.example.paggingapp.domain.usecase

import androidx.paging.PagingData
import com.example.paggingapp.data.model.PostDto
import com.example.paggingapp.data.repository.PostRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val repository: PostRepositoryImpl
) {
    operator fun invoke(): Flow<PagingData<PostDto>> {
        return repository.getPostsStream()
    }
}