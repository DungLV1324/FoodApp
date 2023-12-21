package com.dunglv.foodapp.ui.splash

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.ActivitySplashBinding
import com.dunglv.foodapp.ui.homemain.HomeMainFragment
import com.dunglv.foodapp.ui.homemain.intro.IntroActivity

class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding

    private var handle: Handler? = null
    private var runable: Runnable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        startToMain()
        makeStatusBarLight(this, Color.parseColor("#99858585"))
    }

    private fun makeStatusBarLight(activity: Activity, color: Int) {
        val window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = color
        activity.window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                )
    }

    override fun onDestroy() {
        super.onDestroy()
        handle?.removeCallbacksAndMessages(null)
    }

    private fun startToMain() {
        // Cho 1 khoang thoi gian moi thuc hien hanh dong
        handle?.removeCallbacksAndMessages(null)
        handle = Handler(Looper.getMainLooper())
        runable = Runnable {
                val intent = Intent(this, IntroActivity::class.java)
                startActivity(intent)
                finish()
        }
        runable?.let {
            handle?.postDelayed(it, 3000)
        }
    }
}