package com.example.loginrecyclerview
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivityLogin : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = findViewById<EditText>(R.id.email)
        val loginButton = findViewById<Button>(R.id.LoginButton)
        val btnRegister = findViewById<Button>(R.id.RegisterButton)

        btnRegister.setOnClickListener {
            val intent = Intent(this, MainActivityFragment::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val email = email.text.toString()
            val intent = Intent(this, MainActivityRecyclerView::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.LoginButton -> {
                val moveIntent = Intent(this@MainActivityLogin, MainActivityRecyclerView::class.java)
                startActivity(moveIntent)
            }
        }
        when (v.id){
            R.id.RegisterButton -> {
                val moveIntent = Intent(this@MainActivityLogin, MainActivityFragment::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
