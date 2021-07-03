package com.posart.blocodenotas.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.posart.blocodenotas.database.NotepadDatabase
import com.posart.blocodenotas.database.entities.Annotation
import com.posart.blocodenotas.repositories.AnnotationRepository

class FavoritesAnnotationsViewModel(application: Application) : AndroidViewModel(application) {

    val readAllAnnotationsMarkedAsFavorite: LiveData<List<Annotation>>

    private val annotationRepository: AnnotationRepository

    init {
        val annotationDao = NotepadDatabase.getDatabase(application).annotationDao()
        annotationRepository = AnnotationRepository(annotationDao)
        readAllAnnotationsMarkedAsFavorite = annotationRepository.readAllAnnotationsMarkedAsFavorite
    }

}