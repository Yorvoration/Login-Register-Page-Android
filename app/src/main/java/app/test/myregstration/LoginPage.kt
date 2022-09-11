package app.test.myregstration

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.loginpage)


        val register = findViewById<TextView>(R.id.btnin)
        val login = findViewById<Button>(R.id.btnup)
        val ediemail = findViewById<EditText>(R.id.edtemail)
        val edipassword = findViewById<EditText>(R.id.edtpass)

        var sharedPrefences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
        val txtemail = sharedPrefences.getString("email","")
        val txtpass = sharedPrefences.getString("password","")

        login.setOnClickListener {
            if (!ediemail.text.isEmpty() && !edipassword.text.isEmpty()){
                if (txtemail == ediemail.text.toString() && txtpass == edipassword.text.toString()){
                    startActivity(Intent(this, AnotherAct::class.java))
                }
            }else{
                ediemail.setError("email")
                edipassword.setError("password")
            }
        }
        register.setOnClickListener{
            val intent = Intent(this,Registerpage::class.java)
            startActivity(intent)
        }

    }
}