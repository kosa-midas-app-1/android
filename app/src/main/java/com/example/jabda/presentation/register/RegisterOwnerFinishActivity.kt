package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterOwnerFinishBinding
import com.example.jabda.presentation.main.MainOwnerActivity

class RegisterOwnerFinishActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterOwnerFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterOwnerFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.finishBtn.setOnClickListener {
            if(binding.inManagerCp.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "회사명을 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                if(binding.inManagerEpnum.text.toString().isNullOrEmpty()){
                    Toast.makeText(this, "회사 사업자 번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
                else{
                    if((binding.radioBt1.isChecked || binding.rdioBt2.isChecked) && (binding.radioBt3.isChecked || binding.radioBt4.isChecked)){
                        startActivity(Intent(this, MainOwnerActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
                        finish()
                        Log.d("상태","라 ${(binding.radioBt1.isChecked || binding.rdioBt2.isChecked) && (binding.radioBt3.isChecked || binding.radioBt4.isChecked)}")
                    }
                    else{
                        Toast.makeText(this, "선택적 근로시간제 나 시차출퇴근제 또는 재택근무 허용 여부를 알려주세요", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}