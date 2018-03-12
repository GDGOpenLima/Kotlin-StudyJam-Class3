package com.horsesdeveloper.clase1

import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_jedi.view.*

/**
 * @author @briansalvattore on 02/03/2018.
 */
class JediAdapter : RecyclerView.Adapter<JediAdapter.JediHolder>() {

    var jedis = mutableListOf<JediEntity>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = JediHolder.init(parent)

    override fun getItemCount() = jedis.size

    override fun onBindViewHolder(holder: JediHolder?, position: Int) {
       holder?.bind(jedis[position])
    }

    class JediHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(jediEntity: JediEntity) = with(itemView) {
            name.text = jediEntity.name
            race.text = jediEntity.race

            val bitmap = BitmapFactory.decodeFile(jediEntity.photo)
            avatar.setImageBitmap(bitmap)
        }

        companion object {
            fun init(parent: ViewGroup?) : JediAdapter.JediHolder {
                return JediAdapter.JediHolder(parent?.inflate(R.layout.item_jedi))
            }
        }
    }
}