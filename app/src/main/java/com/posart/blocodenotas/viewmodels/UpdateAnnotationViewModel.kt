package com.posart.blocodenotas.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.posart.blocodenotas.database.NotepadDatabase
import com.posart.blocodenotas.database.entities.Annotation
import com.posart.blocodenotas.repositories.AnnotationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateAnnotationViewModel(application: Application) : AndroidViewModel(application){

    private val annotationRepository: AnnotationRepository

    init {
        val annotationDao = NotepadDatabase.getDatabase(application).annotationDao()
        annotationRepository = AnnotationRepository(annotationDao)
    }

    fun updateAnnotation(annotation: Annotation) {
        viewModelScope.launch(Dispatchers.IO) {
            annotationRepository.updateAnnotation(annotation)
        }
    }

    fun deleteAnnotation(annotation: Annotation) {
        viewModelScope.launch(Dispatchers.IO) {
            annotationRepository.deleteAnnotation(annotation)
        }
    }

}