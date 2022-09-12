package com.fathkim.mynoteapps.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.fathkim.mynoteapps.DB.Note
import com.fathkim.mynoteapps.DB.NoteDao
import com.fathkim.mynoteapps.DB.NoteRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class NoteRepository(application: Application) {
    private val mNotesDao: NoteDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()


    init {
        val db = NoteRoomDatabase.getDatabase(application)
        mNotesDao = db.noteDao()
    }

    fun getAllNotes(): LiveData<List<Note>> = mNotesDao.getAllNotes()

    fun insert(note: Note) {
        executorService.execute { mNotesDao.insert(note) }
    }

    fun  delete(note: Note){
        executorService.execute { mNotesDao.insert(note) }
    }

    fun update(note: Note){
        executorService.execute { mNotesDao.insert(note) }
    }
}