package com.horsesdeveloper.clase1

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private val NEW_JEDI = 7823

    private val jedis = mutableListOf<JediEntity>()
    private lateinit var adapter: JediAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val white = ContextCompat.getColor(this, R.color.white)

        toolbar.setTitleTextColor(white)
        toolbar.title = "Lista de Jedi"
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            startActivityForResult(Intent(this, NewJediActivity::class.java), NEW_JEDI)
        }

        recycler.layoutManager = GridLayoutManager(this, 1)
        adapter = JediAdapter()
        adapter.jedis = jedis
        recycler.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == NEW_JEDI) {

            if (data != null) {
                val jedi = data.getSerializableExtra("jedi") as JediEntity
                jedis.add(jedi)
                adapter.notifyDataSetChanged()
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}
