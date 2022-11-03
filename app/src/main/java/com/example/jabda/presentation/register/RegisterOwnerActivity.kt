package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterOwnerBinding
import java.util.regex.Pattern

class RegisterOwnerActivity: AppCompatActivity() {
    private lateinit var binding: ActivityRegisterOwnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterOwnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nextBtn.setOnClickListener {

            val patternEmail: Pattern = Patterns.EMAIL_ADDRESS
            val patternph : Pattern = Patterns.PHONE
            val email : String = binding.inManagerEmail.text.toString() // Email 저장
            val ph : String = binding.inManagerPh.text.toString() // 전화번호 저장
            val name : String = binding.inManagerName.text.toString() // 이름 저장
            val pw : String = binding.inManagerPw.text.toString() // 비밀범호 저장
            if (binding.inManagerName.text.isNullOrEmpty()) { //이름이 공백일 경우
                Log.d("상태","이름 공백")
                Toast.makeText(this, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show() // 앱이 Android 12(API 수준 31) 이상을 타겟팅한다면 토스트 메시지는 텍스트 두 줄로 제한되고 텍스트 옆에 애플리케이션 아이콘이 표시

            } else { //이름이 공백이 아닐경우
                if (patternEmail.matcher(email).matches()) {//Email를 잘못 적거나 안적었을 경우
                    if(binding.inManagerPw.text.isNullOrEmpty()){ // 비밀번호가 공백일 경우
                        Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Log.d("상태", "onCreate: ${binding.inManagerPw.getText().toString().equals(binding.inManagerRepw.getText().toString())}")
                        if(binding.inManagerPw.text.toString().equals(binding.inManagerRepw.text.toString()) && !binding.inManagerPw.getText().toString().isNullOrEmpty()){ //비밀번호 2개가 다르거나 안적은 경우

                            if(patternph.matcher(ph).matches()){//전화번호를 잘못 적거나 안적었을 경우
                                binding.nextBtn.setOnClickListener {// 다음 화면으로 이동
                                    startActivity(Intent(this, RegisterOwnerFinishActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION))
                                    finish()
                                    intent.putExtra("password",binding.inManagerPw.text.toString())
                                    intent.putExtra("email",binding.inManagerEmail.text.toString())
                                    intent.putExtra("name",binding.inManagerName.text.toString())
                                    intent.putExtra("phone_number",binding.inManagerPh.text.toString())
                                }
                            }
                            else{

                                Toast.makeText(this, "올바른 전화번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else{
                            Toast.makeText(this, "올바른 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                            Log.d("비밀번호 상태","${binding.inManagerPw.text},${binding.inManagerRepw.text}")
                        }
                    }
                } else {
                    //이메일 아님!
                    Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show() // 앱이 Android 12(API 수준 31) 이상을 타겟팅한다면 토스트 메시지는 텍스트 두 줄로 제한되고 텍스트 옆에 애플리케이션 아이콘이 표시
                    Log.d("상태","${binding.inManagerEmail}")
                }
            }
        }
    }
}