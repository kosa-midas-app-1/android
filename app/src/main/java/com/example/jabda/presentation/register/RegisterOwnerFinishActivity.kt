package com.example.jabda.presentation.register

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jabda.databinding.ActivityRegisterOwnerFinishBinding
import com.example.jabda.network.request.auth.RegisterOwnerRequest
import com.example.jabda.network.request.auth.RegisterOwnerResponse
import com.example.jabda.network.request.managers.EditInfoRequest
import com.example.jabda.network.retrofit.RetrofitClient
import com.example.jabda.presentation.main.MainOwnerActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
                        var ws = "FLEXTIME"
                        if(binding.radioBt3.isChecked){
                            ws = "ALTERNATIVE"
                        }
                        val email : String = intent.getStringExtra("email") ?: "" // Email 저장
                        val ph : String = intent.getStringExtra("phone_number") ?: "" // 전화번호 저장
                        val name : String = intent.getStringExtra("name") ?: "" // 이름 저장
                        val pw : String = intent.getStringExtra("password") ?: "" // 비밀범호 저장
                        val company_name : String = binding.inManagerCp.text.toString() // 회사 이름
                        val company_business_number : String = binding.inManagerEpnum.text.toString() // 회사 사업자 번호
                        val call = RetrofitClient.api.registerOwner(RegisterOwnerRequest(password = pw, email = email, name = name, phoneNumber = ph,companyName = company_name, companyNumber = company_business_number, companyImage = "", companySystem = ws, isHomeWork = binding.radioBt1.isChecked))
                        call.enqueue(object : Callback<RegisterOwnerResponse>{
                            override fun onResponse(
                                call: Call<RegisterOwnerResponse>,
                                response: Response<RegisterOwnerResponse>
                            ) {
                                if(response.code() == 200) {

                                }
                                TODO("Not yet implemented")
                            }

                            override fun onFailure(
                                call: Call<RegisterOwnerResponse>,
                                t: Throwable
                            ) {
                                Log.d("상태",t.message.toString())
                                TODO("Not yet implemented")
                            }

                        })
                    }
                    else{
                        Toast.makeText(this, "선택적 근로시간제 나 시차출퇴근제 또는 재택근무 허용 여부를 알려주세요", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}