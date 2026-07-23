package com.example.paggingapp.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paggingapp.data.model.PostDto
import com.example.paggingapp.data.remote.ApiService
import timber.log.Timber
import javax.inject.Inject

class PostPagingSource @Inject constructor(
    private val apiService: ApiService
) : PagingSource<Int, PostDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostDto> {
        val position = params.key ?: 1
        return try {
            val response = apiService.getPosts(page = position, limit = PAGE_SIZE)
            Timber.d("Loaded page $position with ${response.size} items")

            LoadResult.Page(
                data = response,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (response.size < PAGE_SIZE) null else position + 1
            )

        } catch (exception: Exception) {
            Timber.e(exception, "Error loading data at page $position")
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PostDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }


    companion object {
        const val PAGE_SIZE = 20
    }
}
