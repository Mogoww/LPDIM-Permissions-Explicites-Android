package com.example.accesstostorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.accesstostorage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val requestFiles = registerForActivityResult(ActivityResultContracts.RequestPermission(),{
            if(it){
                Toast.makeText(applicationContext,"Permission granted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Permission no granted", Toast.LENGTH_SHORT).show()
            }
        })

        binding.btnFilesPermission.setOnClickListener({
            requestFiles.launch(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        })


    }



}