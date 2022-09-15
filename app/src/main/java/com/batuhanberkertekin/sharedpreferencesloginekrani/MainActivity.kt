package com.batuhanberkertekin.sharedpreferencesloginekrani

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_giris_ekran.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shared = getSharedPreferences("Veri Kayit",Context.MODE_PRIVATE)

        val otoName= shared.getString("name",null)
        val otoPassword = shared.getString("password",null)


        //Asıl olay bence verileri tekrar girmeden login ekranına uğramadan Main ekrana geçmesi bence
        //Güzel düşünmek gerek .

        if(otoName == "ertekin" && otoPassword == "1234" ){

            val intent = Intent(applicationContext,MainEkran::class.java)
            finish()
            startActivity(intent)




        }







        loginButton.setOnClickListener {

            var name = userText.text.toString().trim()
            var password = userPassword.text.toString().trim()


           if(name == "ertekin" && password == "1234"){
               val edit = shared.edit()

               edit.putString("name",name)
               edit.putString("password",password)

               edit.commit()


               val intent = Intent(applicationContext,MainEkran::class.java)
               finish()
               startActivity(intent)




           }else{

                Toast.makeText(this,"Wrong Name or Password",Toast.LENGTH_SHORT).show()
            }








        }


    }
}