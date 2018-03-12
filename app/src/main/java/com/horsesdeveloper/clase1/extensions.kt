package com.horsesdeveloper.clase1

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

/**
 * @author @briansalvattore on 17/02/2018.
 */


fun EditText.getString() = this.text.toString().trim()

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun ContentResolver.query(uri: Uri, projection: String): Cursor {
    return query(uri, arrayOf(projection), null, null, null)
}