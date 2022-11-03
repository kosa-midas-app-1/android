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
            if(binding.inPs.text.isNullOrEmpty()){
                Toast.makeText(this, "직급을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent(this, MainOwnerActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
                finish()
            }
            val ps :String = binding.inPs.text.toString()
            val cp : String = binding.inCp.text.toString()
        }
    }
}