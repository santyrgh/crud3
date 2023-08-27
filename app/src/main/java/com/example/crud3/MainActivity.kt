package com.example.crud3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {

    var txtNombre:EditText?=null;
    var txtUsuario:EditText?=null;
    var txtPass:EditText?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombre=findViewById(R.id.txtNombre);
        txtUsuario=findViewById(R.id.txtUsuario);
        txtPass=findViewById(R.id.txtPass);
    }
    fun clickBtnInsertar(view:View){
        val url="http://192.168.18.102//dmobile/insertar.php"
        val queue=Volley.newRequestQueue(this)
        var resultadoPost = object : StringRequest(Request.Method.POST,url,
            Response.Listener<String> { response ->
                Toast.makeText(this,"Usuario insertado exitosamente",Toast.LENGTH_LONG).show()
            },Response.ErrorListener { error ->
                Toast.makeText(this,"Error $error ",Toast.LENGTH_LONG).show()
            }){
            override fun getParams(): MutableMap<String, String> {
                val parametros=HashMap<String,String>()
                parametros.put("usu_usuario",txtUsuario?.text.toString())
                parametros.put("usu_password",txtPass?.text.toString())
                parametros.put("usu_nombre",txtNombre?.text.toString())
                return parametros
            }
        }
        queue.add(resultadoPost)
    }

    fun consultar(view: View){
        var txtid=findViewById<EditText>(R.id.txtid)
        var intent= Intent(this,MainActivity2::class.java)
        intent.putExtra("id",txtid.text.toString())
        startActivity(intent)
    }
}


