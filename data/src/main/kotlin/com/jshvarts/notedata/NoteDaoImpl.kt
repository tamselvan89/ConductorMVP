package com.jshvarts.notedata

import android.arch.persistence.room.*
import com.jshvarts.notedomain.repository.NoteDao
import io.reactivex.Maybe
import io.reactivex.Single

@Dao
interface NoteDaoImpl : NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(note: NoteEntity)

    @Delete
    fun delete(note: NoteEntity)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun findNoteById(id: Long): Maybe<NoteEntity>

    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    fun getAllNotes(): Single<List<NoteEntity>>
}