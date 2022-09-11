package app.test.myregstration

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AnotherAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_another)

        val logout = findViewById<Button>(R.id.logout)

        var preferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)


        logout.setOnClickListener {
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }


    }
}