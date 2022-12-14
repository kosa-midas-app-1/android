package com.example.jabda.presentation.main

import android.app.PendingIntent
import android.content.Intent
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.view.View
import androidx.activity.viewModels
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.jabda.R
import com.example.jabda.databinding.ActivityMainBinding
import com.example.jabda.network.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var nfcPendingIntent: PendingIntent
    private lateinit var nfcAdapter: NfcAdapter
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNav()
        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this,
            executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    viewModel.setIsMe(true)
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("?????? ??????")
            .setSubtitle("????????? ????????? ????????? ???????????? ????????? ??????????????????.")
            .setNegativeButtonText("??????")
            .setDeviceCredentialAllowed(false)
            .build()
        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this,
            executor, object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(
                    errorCode: Int,
                    errString: CharSequence
                ) {
                    super.onAuthenticationError(errorCode, errString)
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    viewModel.setIsMe(true)
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("?????? ??????")
            .setSubtitle("????????? ????????? ????????? ???????????? ????????? ??????????????????.")
            .setNegativeButtonText("??????")
            .setDeviceCredentialAllowed(false)
            .build()
        binding.notificationBtn.setOnClickListener {
            findNavController(R.id.fragment_club).navigate(R.id.notificationFragment)
            viewModel.setIsNotification(true)
        }
        viewModel.isCard.observe(this) {
            if(it) {
                nfcAdapter = NfcAdapter.getDefaultAdapter(this)
                nfcPendingIntent = PendingIntent.getActivity(
                    this, 0,
                    Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), PendingIntent.FLAG_IMMUTABLE
                )
            }
        }
        viewModel.isDetail.observe(this) {
            if (it) {
                binding.bottomNavigation.visibility = View.GONE
            } else if (viewModel.isNotification.value != true) {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
        viewModel.isNotification.observe(this) {
            if (it) {
                binding.bottomNavigation.visibility = View.GONE
            } else if (viewModel.isDetail.value != true){
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
        viewModel.isApprove.observe(this) {
            if (it && viewModel.isMe.value != true) {
                biometricPrompt.authenticate(promptInfo)
            }
        }
    }

    private fun initBottomNav() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fragment_club)?.findNavController()
        val nav = binding.bottomNavigation
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        viewModel.isCard.observe(this) {
            if (it) {
                RetrofitClient.api.attend().enqueue(object : Callback<Void> {
                    override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    }

                    override fun onFailure(call: Call<Void>, t: Throwable) {
                    }
                })
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.isCard.observe(this) {
            if(it) {
                nfcAdapter.enableForegroundDispatch(this, nfcPendingIntent, null, null)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.isCard.observe(this) {
            if (it) {
                nfcAdapter.disableForegroundDispatch(this)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (viewModel.isDetail.value == true) {
            viewModel.setIsDetail(false)
            return
        }
        if (viewModel.isNotification.value == true) {
            viewModel.setIsNotification(false)
        }
    }
}