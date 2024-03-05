package com.example.miu_mdp_amazone_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.miu_mdp_amazone_app.entities.User
import com.example.miu_mdp_amazone_app.ui.theme.MiumdpamazoneappTheme

class MainActivity : ComponentActivity() {
    private lateinit var users: MutableList<User>
    private lateinit var btnGoToCreateAccount:Button
    private lateinit var btnLogin:Button
    private lateinit var emailEditText:EditText
    private lateinit var passwordEditText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        users = mutableListOf(User("John Doe", "john@gmail.com", "12345"))
        users.add(User("admin","admin@gmail.com","1234"))
        emailEditText = findViewById(R.id.emailText)
        passwordEditText = findViewById(R.id.passwordText)
        btnGoToCreateAccount = findViewById(R.id.createAccountBtn)
        btnLogin = findViewById(R.id.signInBtn)

        btnLogin.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val user = users.find { user: User -> user.email == email && user.password == password }
            if(user !=null){ val intent = Intent(this, ShoppingCategoryActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
            }else{
                Toast.makeText(this, "Login or password incorrect.", Toast.LENGTH_LONG).show()
            }
        }

        btnGoToCreateAccount.setOnClickListener {
          val intent = Intent(this, RegisterAcivity::class.java)
            startActivity(intent)
        }

    }

}

