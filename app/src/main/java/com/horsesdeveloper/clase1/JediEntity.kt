package com.horsesdeveloper.clase1

import java.io.Serializable

/**
 * @author @briansalvattore on 02/03/2018.
 */
data class JediEntity(
        var name: String = "",
        var race: String = "",
        var photo: String = ""
): Serializable