package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
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
        binding.buCom.setOnClickListener {
            if (binding.inCp.text.isNullOrEmpty()) {
                Toast.makeText(this, "회사를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                if (binding.inPs.text.isNullOrEmpty()) {
                    Toast.makeText(this, "직급을 입력해주세요.", Toast.LENGTH_SHORT).show()
                } else{
                    val ps: String = binding.inPs.text.toString() //직급명 저장
                    val cp: String = binding.inCp.text.toString() //회사명 저장
                    val name: String = intent.getStringExtra("name") ?: "" //이름 저장
                    val email: String = intent.getStringExtra("email") ?: "" // 메일 저장
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