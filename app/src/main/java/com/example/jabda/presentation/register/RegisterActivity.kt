package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterBinding
import com.example.jabda.presentation.main.MainOwnerActivity
import java.util.regex.Pattern

class RegisterActivity: AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buNext.setOnClickListener {
            val patternEmail: Pattern = Patterns.EMAIL_ADDRESS
            val patternph : Pattern = Patterns.PHONE
            val email : String = binding.inEmail.text.toString()
            val ph : String = binding.inPh.text.toString()
            if (binding.inName.getText().isNullOrEmpty()) { //이름이 공백일 경우
                Log.d("상태","이름 공백")
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show() // 앱이 Android 12(API 수준 31) 이상을 타겟팅한다면 토스트 메시지는 텍스트 두 줄로 제한되고 텍스트 옆에 애플리케이션 아이콘이 표시

            } else { //이름이 공백이 아닐경우
                if (patternEmail.matcher(email).matches()) {//Email를 잘못 적거나 안적었을 경우
                    if(binding.inPw.text.isNullOrEmpty()){ // 비밀번호가 공백일 경우
                        Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Log.d("상태", "onCreate: ${binding.inPw.getText().toString().equals(binding.inRepw.getText().toString())}")
                        if(binding.inPw.text.toString().equals(binding.inRepw.text.toString()) && !binding.inPw.getText().toString().isNullOrEmpty()){ //비밀번호 2개가 다르거나 안적은 경우

                            if(patternph.matcher(ph).matches()){//전화번호를 잘못 적거나 안적었을 경우
                                binding.buNext.setOnClickListener {// 다음 화면으로 이동
                                    startActivity(Intent(this, RegisterFinishActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
                                    finish()
                                }
                            }
                            else{

                                Toast.makeText(this, "올바른 전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else{
                            Toast.makeText(this, "올바른 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                            Log.d("비밀번호 상태","${binding.inPw.text},${binding.inRepw.text}")
                        }
                    }
                } else {
                    //이메일 아님!
                    Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show() // 앱이 Android 12(API 수준 31) 이상을 타겟팅한다면 토스트 메시지는 텍스트 두 줄로 제한되고 텍스트 옆에 애플리케이션 아이콘이 표시
                    Log.d("상태","${binding.inEmail}")
                }
            }
        }
    }
}