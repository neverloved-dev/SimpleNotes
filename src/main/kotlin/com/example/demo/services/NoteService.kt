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
}