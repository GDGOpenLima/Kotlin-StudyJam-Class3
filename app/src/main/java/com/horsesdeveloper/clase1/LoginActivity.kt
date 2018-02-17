package com.horsesdeveloper.clase1

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        /**
         * Java to Object form
         * var btnLogin = findViewById<Button>(R.id.login)
        btnLogin.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {

            }
        }) */

        login.setOnClickListener {

            if (email.getString() ==
                    "briansalvattore@gmail.com") {

                if (password.getString() ==
                        "qwerty") {

                    val intent = Intent(this,
                            NewProductActivity::class.java)
                    startActivity(intent)
                }
                else {
                    showMessage(this,
                            "La contraseña no es válida")
                }
            }
            else {
                showMessage(this,
                        "El correo no es valido")
            }
        }

    }

    private fun EditText.getString() = this.text.toString().trim()

    private fun showMessage(context: Context, message: String) =
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
