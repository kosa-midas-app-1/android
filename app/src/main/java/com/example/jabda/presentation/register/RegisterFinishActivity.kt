package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterFinishBinding
import com.example.jabda.presentation.main.MainActivity
import com.example.jabda.presentation.main.MainOwnerActivity

class RegisterFinishActivity: AppCompatActivity() {
    lateinit var binding: ActivityRegisterFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("상태", "onCreate: ${intent.getStringExtra("email")}")
        Log.d("상태", "onCreate: ${intent.getStringExtra("Phone number")}")
        Log.d("상태", "onCreate: ${intent.getStringExtra("name")}")
        binding.buCom.setOnClickListener {
            if (binding.inCp.text.isNullOrEmpty()) {
                Toast.makeText(this, "회사를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                if (binding.inPs.text.isNullOrEmpty()) {
                    Toast.makeText(this, "직급을 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else{
                    val ps: String = binding.inPs.text.toString()
                    val cp: String = binding.inCp.text.toString()
                    startActivity(
                        Intent(
                            this,
                            MainOwnerActivity::class.java
                        ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    )
                    finish()
                }
            }
        }
    }
}