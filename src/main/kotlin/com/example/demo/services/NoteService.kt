package com.example.demo.services

import com.example.demo.models.Note
import com.example.demo.repository.NoteRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteService(private val repository: NoteRepository) {

    fun findNoteById(id: Int): Optional<Note> {
        var note = repository.findById(id)
        return note
    }

    fun getAllNotes(): MutableList<Note> {
        return repository.findAll()
    }

    fun updateNote(id: Int, updatedNote: Note): Note? {
      var note = repository.findById(id)
        if (note.get() != null){
            note.get().title = updatedNote.title
            note.get().content = updatedNote.content
            repository.save(note.get())
        }
        return note.get()
    }

    fun createNote(newNote: Note):Note {
        repository.save(newNote)
        return newNote
    }

    fun deleteNoteById(id: Int) {
        repository.deleteById(id)
    }
}