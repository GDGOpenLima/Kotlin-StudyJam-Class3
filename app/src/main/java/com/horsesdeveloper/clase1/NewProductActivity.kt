package com.horsesdeveloper.clase1

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_product.*

class NewProductActivity : AppCompatActivity() {

    private val SELECT_GALLERY = 2783

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_product)

        imageButton.setOnClickListener {
            val goToGallery = Intent().apply {
                type = "image/*"
                action = Intent.ACTION_GET_CONTENT
            }

            startActivityForResult(goToGallery, SELECT_GALLERY)
        }

        button.setOnClickListener {

            val product = Product2Entity(
                    editText.getString(),
                    editText2.getString(),
                    editText3.getString().toDouble(),
                    editText4.getString().toInt(),
                    ""
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_GALLERY) {

            if (data != null) {

                val path = data.data.toString()
                val bitmap = BitmapFactory
                        .decodeStream(
                                this.contentResolver
                                        .openInputStream(Uri.parse(path)))

                imageButton.setImageBitmap(bitmap)
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}
