package com.example.jabda.presentation.main

import android.app.PendingIntent
import android.content.Intent
import android.nfc.NfcAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jabda.R
import com.example.jabda.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var nfcPendingIntent: PendingIntent
    private lateinit var nfcAdapter: NfcAdapter
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNav()
        viewModel.isCard.observe(this) {
            if(it) {
                nfcAdapter = NfcAdapter.getDefaultAdapter(this)
                nfcPendingIntent = PendingIntent.getActivity(
                    this, 0,
                    Intent(this, javaClass).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), PendingIntent.FLAG_IMMUTABLE
                )
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
}