package com.gads.practiceproject.feature.submit

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.gads.practiceproject.R
import kotlinx.android.synthetic.main.activity_main.submit_btn
import kotlinx.android.synthetic.main.activity_submit.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class SubmitActivity : AppCompatActivity() {

    private val viewModel: SubmitViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)
        supportActionBar?.hide()
        observeData()
        initViews()

    }

    private fun initViews() {
        back_btn.setOnClickListener {
            finish()
        }
        submit_btn.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("Are you sure?")
                .setPositiveButton(
                    android.R.string.yes
                ) { _, _ ->
                    viewModel.submit(
                        first_name_et.text.toString(),
                        last_name_et.text.toString(),
                        email_et.text.toString(),
                        github_link_et.text.toString()
                    )
                }
        }

    }

    private fun observeData() {
        viewModel.error.observe(this, Observer {
            val view = LayoutInflater.from(this).inflate(R.layout.failure_dialog, null)
            AlertDialog.Builder(this)
                .setView(view).show()
        })
        viewModel.success.observe(this, Observer {
            val view = LayoutInflater.from(this).inflate(R.layout.success_dialog, null)
            AlertDialog.Builder(this)
                .setView(view).show()
        })
    }
}