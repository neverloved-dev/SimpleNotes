package com.example.demo.notes

import com.example.demo.models.Note
import com.example.demo.repository.NoteRepository
import com.example.demo.services.NoteService
import io.mockk.*
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals


class NotesServiceTests {

    val notesRepository:NoteRepository = mockk()
    val notesService:NoteService = NoteService(notesRepository)
    val note:Note = Note(1,"title1","content1", createdAt = Date())
    val note2:Note = Note(2,"title2","content2", createdAt = Date())
    val note3:Note = Note(3,"title3","content3", createdAt = Date())

    @Test
    fun `gets all notes from the database`(){
        every { notesRepository.findAll() } returns listOf(note).toMutableList();
        val result = notesService.getAllNotes()

        verify(exactly = 1) { notesRepository.findAll() }
        assertEquals(1, result.size)
        assertEquals(note, result[0])
    }

    @Test
    fun `gets the note by its id`() {
        // Mocking the repository to return the initialized note
        every { notesRepository.findById(2) } returns Optional.of(note2)

        // Call the service to get the note
        val result = notesService.findNoteById(2)

        // Verify that findByIdOrNull was called with the correct argument
        verify(exactly = 1) { notesRepository.findById(2) }

        // Assert that the result matches the expected note
        assertEquals<Optional<Note>>(Optional.of(note2), result)
    }

    @Test
    fun `updates the note`(){
        val updatedNote = Note(
            id = 1,
            title = "Updated Title",
            content = "Updated Content",
            createdAt = note.createdAt
        )

        // Mocking findByIdOrNull to return the original note
        every { notesRepository.findById(1) } returns Optional.of(note)

        // Mocking the save method to return the updated note
        every { notesRepository.save(any()) } returns updatedNote

        val result = notesService.updateNote(1, updatedNote)

        verify(exactly = 1) { notesRepository.findById(1) }
        verify(exactly = 1) { notesRepository.save(any()) }
        assertEquals(updatedNote, result)
    }

    @Test
    fun `creates new note`(){
        val newNote = Note(
            id = 4,
            title = "New Note4",
            content = "This is a new note4",
            createdAt = Date()
        )

        every { notesRepository.save(any()) } returns newNote

        val result = notesService.createNote(newNote)

        verify(exactly = 1) { notesRepository.save(any()) }
        assertEquals(newNote, result)
    }

    @Test
    fun `deletes the note by id`(){
        every { notesRepository.deleteById(3) } just Runs

        notesService.deleteNoteById(3)

        verify(exactly = 1) { notesRepository.deleteById(3) }
    }
}