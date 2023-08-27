package com.example.crud3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.textclassifier.TextLinks
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity2 : AppCompatActivity() {


    var txtNombre: EditText?=null
    var txtUsuario: EditText?=null
    var txtPass: EditText?=null
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        txtNombre=findViewById(R.id.txtNombre)
        txtUsuario=findViewById(R.id.txtUsuario)
        txtPass=findViewById(R.id.txtPass)

        val id=intent.getStringExtra("id").toString()

        val queue=Volley.newRequestQueue(this)
        val url="http://192.168.18.102/dmobile/registro.php?id=$id"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET,url,null,
            Response.Listener { response ->
                txtNombre?.setText(response.getString("usu_nombre"))
                txtUsuario?.setText(response.getString("usu_usuario"))
                txtPass?.setText(response.getString("usu_password"))
            },Response.ErrorListener { error ->
                Toast.makeText(this,error.toString(),Toast.LENGTH_LONG).show()
            }
        )
        queue.add(jsonObjectRequest)
    }
    fun clickRegresar(view:View){
        var intent= Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}