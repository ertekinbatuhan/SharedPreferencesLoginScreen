package com.batuhanberkertekin.sharedpreferencesloginekrani

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_giris_ekran.*

class MainEkran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giris_ekran)

        val getShared = getSharedPreferences("Veri Kayit", Context.MODE_PRIVATE)





     val getName =  getShared.getString("name",null)
     val getPassword = getShared.getString("password",null)

        nameText.text = "Kullanıcı Adı : $getName"
        passwordText.text = "Şifre : $getPassword"



        cikisButton.setOnClickListener {

            val editor = getShared.edit()

            editor.remove("name")
            editor.remove("password")
            editor.commit()


            val intent = Intent(applicationContext,MainActivity::class.java)
            finish()

            startActivity(intent)



        }
    }
}