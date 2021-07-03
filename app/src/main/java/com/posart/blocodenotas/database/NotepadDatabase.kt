package com.posart.blocodenotas.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.posart.blocodenotas.database.dao.AnnotationDao
import com.posart.blocodenotas.database.dao.TaskDao
import com.posart.blocodenotas.database.entities.Annotation
import com.posart.blocodenotas.database.entities.Task

@Database(entities = [Annotation::class, Task::class], version = 2, exportSchema = false)
abstract class NotepadDatabase: RoomDatabase() {

    abstract fun annotationDao(): AnnotationDao
    abstract fun taskDao(): TaskDao

    companion object {

        @Volatile
        private var INSTANCE: NotepadDatabase? = null

        fun getDatabase(context: Context): NotepadDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotepadDatabase::class.java,
                    "notepad_database"
                ).addMigrations(object : Migration(1, 2) {
                    override fun migrate(database: SupportSQLiteDatabase) {
                        database.execSQL("ALTER TABLE annotations ADD COLUMN favorite INTEGER NOT NULL DEFAULT 0")
                    }
                }).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}