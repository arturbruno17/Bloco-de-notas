package com.posart.blocodenotas.repositories

import androidx.lifecycle.LiveData
import com.posart.blocodenotas.database.dao.AnnotationDao
import com.posart.blocodenotas.database.entities.Annotation

class AnnotationRepository(private val annotationDao: AnnotationDao) {

    val readAllData: LiveData<List<Annotation>> = annotationDao.readAllAnnotations()

    suspend fun insertAnnotation(annotation: Annotation) {
        annotationDao.insertAnnotation(annotation)
    }

    suspend fun updateAnnotation(annotation: Annotation) {
        annotationDao.updateAnnotation(annotation)
    }

    suspend fun deleteAnnotation(annotation: Annotation) {
        annotationDao.deleteAnnotation(annotation)
    }

}