package com.example.firstmain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import com.example.firstmain.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    companion object {
        const val KEY_SEND = "KEY"
        const val KEY_back = "KEY-result"
    }

    private lateinit var launchResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        start()
        result()
    }
    private fun start() {
        binding.btnNextTwo.setOnClickListener {
            val text = binding.etWordOne.text.toString()
            if (text.isNotEmpty()){
                intent(text)
            } else {
                Toast.makeText(this,"error", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun intent(text: String) {

        val intent = Intent()
        intent.putExtra(KEY_back,text)
        setResult(RESULT_OK,intent)
        finish()

    }

    private fun result() {
        val extras :Bundle? = intent.extras
        val title = extras?.getString(KEY_SEND)
        binding.etWordOne.setText(title)

    }
}