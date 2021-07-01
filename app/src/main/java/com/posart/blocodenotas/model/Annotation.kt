package com.posart.blocodenotas.model

import android.os.Parcelable
import com.posart.blocodenotas.database.entities.Annotation
import kotlinx.parcelize.Parcelize

@Parcelize
data class Annotation(
    val id: Int,
    val title: String,
    val content: String
) : Parcelable

fun Annotation.asModel(): com.posart.blocodenotas.model.Annotation {
    return com.posart.blocodenotas.model.Annotation(
        id = this.id,
        title = this.title,
        content = this.content
    )
}
