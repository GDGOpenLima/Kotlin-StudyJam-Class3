package com.horsesdeveloper.clase1

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_new_jedi.*

class NewJediActivity : AppCompatActivity() {

    private val SELECT_GALLERY = 2783
    private var path = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_jedi)

        val white = ContextCompat.getColor(this, R.color.white)

        toolbar.setTitleTextColor(white)
        toolbar.title = "Nuevo Jedi"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        avatar.setOnClickListener {
            val goToGallery = Intent().apply {
                type = "image/*"
                //action = Intent.ACTION_GET_CONTENT
                addCategory(Intent.CATEGORY_OPENABLE)
            }

            startActivityForResult(goToGallery, SELECT_GALLERY)
        }

        add.setOnClickListener {
            val jedi = JediEntity().apply {
                name = this@NewJediActivity.name.getString()
                race = this@NewJediActivity.race.getString()
                photo = path
            }

            FirebaseDatabase
                    .getInstance()
                    .reference
                    .child("jedi")
                    .push()
                    .setValue(jedi)

            /*val intent = Intent()
            intent.putExtra("jedi", jedi)
            setResult(Activity.RESULT_OK, intent)
            finish()*/
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == SELECT_GALLERY) {

            if (data != null) {

                val type = MediaStore.Images.Media.DATA

                val cursor = contentResolver.query(data.data, type)
                cursor.moveToFirst()

                val columnIndex = cursor.getColumnIndex(type)
                path = cursor.getString(columnIndex)
                cursor.close()

                val bitmap = BitmapFactory.decodeFile(path)
                avatar.setImageBitmap(bitmap)
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
