package com.example.practiceapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity(){


    lateinit var button: Button
    lateinit var editText1 : EditText
    lateinit var  editText2 : EditText
    val  validName = arrayOf("Iron", "Captain", "Thanos", "Spider", "Strange", "Thor")
    val validPassword = "12345"

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_main)
        if (isLoggedIn){
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

     title= "Log In"

        button = findViewById(R.id.button)
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)

        button.setOnClickListener {

            val name = editText1.text.toString()
            val mobileNumber = editText2.text.toString()

            var nameOfAvenger = "Avenger"

            val intent = Intent(this@MainActivity, LoginActivity::class.java)

            if ((mobileNumber==validPassword)) {
                if (name == validName[0]) {

                    nameOfAvenger = "Iron"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }
                else if (name == validName[1]){

                    nameOfAvenger = "Captain"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }
                else if (name == validName[2]){

                    nameOfAvenger = "Thanos"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }
                else if (name == validName[3]){

                    nameOfAvenger = "Spider"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }
                else if (name == validName[4]){

                    nameOfAvenger = "Strange"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }
                else if (name == validName[5]){

                    nameOfAvenger = "Thor"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }
            }
            else (
                    Toast.makeText(this@MainActivity, "Incorrect Input",Toast.LENGTH_SHORT).show()

                    )

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}