package app.test.myregstration

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Registerpage : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.registerpage)

        val login = findViewById<Button>(R.id.btnin1)
        val email = findViewById<EditText>(R.id.edtmail)
        val pass = findViewById<EditText>(R.id.edtpass)

        var sharedPrefences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)

        login.setOnClickListener {

            val emaillength = email.length()
            val passlength = pass.length()
            val email = email.text.toString()
            val pass = pass.text.toString()

            val editor: SharedPreferences.Editor = sharedPrefences.edit()
            editor.putString("email", email)
            editor.putString("password", pass)
            editor.apply()

            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }

        val register = findViewById<TextView>(R.id.btnup)

        register.setOnClickListener{
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }

    }
}