package com.gads.practiceproject.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gads.practiceproject.R
import com.gads.practiceproject.feature.home.MainActivity
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        disposable = Completable.complete().delay(1, TimeUnit.SECONDS).subscribe({
            startActivity(Intent(this, MainActivity::class.java))
        }) {}
    }


    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}