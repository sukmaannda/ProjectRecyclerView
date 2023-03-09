package com.example.loginrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivityFragment : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val email = findViewById<EditText>(R.id.email)
        val loginButton = findViewById<Button>(R.id.LoginButton)

        val btnMoveActivity: Button =
            findViewById(R.id.RegisterButton)
        btnMoveActivity.setOnClickListener(this)

        loginButton.setOnClickListener {
            val email = email.text.toString()
            val intent = Intent(this, MainActivityFragment::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
    }
    override fun onClick(v: View) {
        when (v.id) {
            R.id.RegisterButton -> {
                val moveIntent = Intent(this@MainActivityFragment, MainActivityRegister::class.java)
                startActivity(moveIntent)
            }
        }
    }
}