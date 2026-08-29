package com.example.paggingapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.paggingapp.databinding.ActivityMainBinding
import com.example.paggingapp.presentation.adapter.PostAdapter
import com.example.paggingapp.presentation.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val postAdapter = PostAdapter()
    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        Timber.d("Notification permission granted: $isGranted")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ValueAnimator.ofFloat(0f, 500f).apply {
            duration = 1000

            addUpdateListener { animator ->
                val value = animator.animatedValue as Float
                print(value)
            }

            start()
        }

//        // object animator
//
//        val move = ObjectAnimator.ofFloat(
//            binding.button,
//            "translationX",
//            0f,
//            500f
//        )
//
//        val rotate = ObjectAnimator.ofFloat(
//            binding.button,
//            "rotation",
//            0f,
//            360f
//        )
//
//        val scale = ObjectAnimator.ofFloat(
//            binding.button,
//            "scaleX",
//            1f,
//            2f
//        )
//
//        // animation set kêết hợp nhiều animation với nhau
//        AnimatorSet().apply {
//            playTogether(move, rotate, scale)
//            duration = 5000
//            start()
//        }

        /**
         * ObjectAnimator animation của 1 property của object
         */

        /**
         * valueANimator - thay đổi giá trị theo thời gian
         */

//        binding.button.animate()
//            .translationX(500f)
//            .setDuration(1000)
//            .setInterpolator(LinearInterpolator())
//            .start()

//        binding.button.animate()
//            .alpha(0.2f)
//            .setDuration(5000)
//            .start()

//        binding.button.animate()
//            .rotation(360f)
//            .setDuration(5000)
//            .start()

//        binding.button.animate()
//            .scaleX(2f)
//            .scaleY(2f)
//            .setDuration(5000)
//            .start()

//        binding.button.animate()
//            .translationY(500f)
//            .setDuration(1000)
//            .start()

//        val customTextView = CustomTextView(this)
//        binding.root.addView(customTextView)

//        binding.circleProgressView.setProgress(0.75f)

//        val view = CircleView(this)
//        binding.root.addView(view)

//        val view = LineView(this)
//        binding.root.addView(view)

//        binding.clickButton.setOnClickListener {
//            customTextView.updateSize()
//        }

//        setUpRecyclerView()
//        observeData()
//        requestNotificationPermissionIfNeeded()
    }

//    private fun setUpRecyclerView() {
//        binding.recyclerView.adapter = postAdapter
//
//        // lắng nghe trạng thái Load (Loading, Error, Success) của Paging 3
//        postAdapter.addLoadStateListener { loadState ->
//            val isInitialLoading = loadState.refresh is LoadState.Loading
//            binding.progressBar.isVisible = isInitialLoading
//        }
//    }
//
//    private fun observeData() {
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.postsStream.collectLatest { pagingData ->
//                    postAdapter.submitData(pagingData)
//                }
//            }
//        }
//    }
//
//    private fun requestNotificationPermissionIfNeeded() {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) return
//
//        val permission = Manifest.permission.POST_NOTIFICATIONS
//        val isGranted = ContextCompat.checkSelfPermission(
//            this,
//            permission
//        ) == PackageManager.PERMISSION_GRANTED
//
//        if (isGranted || wasNotificationPermissionRequested()) return
//
//        markNotificationPermissionRequested()
//        notificationPermissionLauncher.launch(permission)
//    }
//
//    private fun wasNotificationPermissionRequested(): Boolean {
//        return getPreferences(Context.MODE_PRIVATE)
//            .getBoolean(KEY_NOTIFICATION_PERMISSION_REQUESTED, false)
//    }
//
//    private fun markNotificationPermissionRequested() {
//        getPreferences(Context.MODE_PRIVATE)
//            .edit()
//            .putBoolean(KEY_NOTIFICATION_PERMISSION_REQUESTED, true)
//            .apply()
//    }
//
//    companion object {
//        private const val KEY_NOTIFICATION_PERMISSION_REQUESTED =
//            "notification_permission_requested"
//    }
}
