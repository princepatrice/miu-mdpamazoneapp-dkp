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

class RegisterAcivity : ComponentActivity() {
    private lateinit var users: MutableList<User>
    private lateinit var btnCreateAccount: Button
    private lateinit var emailEditText: EditText
    private lateinit var nameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var password2EditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        users = mutableListOf()
        emailEditText = findViewById(R.id.RemailText)
        passwordEditText = findViewById(R.id.RpasswordText)
        btnCreateAccount = findViewById(R.id.createNewAccount)
        nameEditText =  findViewById(R.id.nameText)
        password2EditText = findViewById(R.id.passwordText2)
        users = mutableListOf(User("John Doe", "john@gmail.com", "12345"))
        users.add(User("admin","admin@gmail.com","1234"))
        btnCreateAccount.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val password2 = password2EditText.text.toString()
            if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && password2.isNotEmpty()){

                if(password != password2){
                    Toast.makeText(this, "Password not matched", Toast.LENGTH_LONG).show()
                }else {
                    val user = users.find { user: User -> user.name == name }
                    if(user ==null){
                    val user = User(name, email, password)
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("user", user)
                    Toast.makeText(this, "New Account created successfully", Toast.LENGTH_LONG).show()
                    startActivity(intent)}else{
                        Toast.makeText(this, "Account already exists.", Toast.LENGTH_LONG).show()

                    }
                }
            } else {
                Toast.makeText(this, "Please fill all the inputs.", Toast.LENGTH_LONG).show()
            }
        }
    }

}
