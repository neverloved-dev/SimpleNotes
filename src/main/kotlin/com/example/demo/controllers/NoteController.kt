package com.example.demo.controllers

import com.example.demo.models.Note
import com.example.demo.services.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/notes")
class NoteController(private val noteService: NoteService) {

    @GetMapping("")
    fun getAllNotes(): ResponseEntity<MutableList<Note>> {
        var notes = noteService.getAllNotes()
        if (notes!=null){
            return ResponseEntity(notes,HttpStatus.OK)
        }else{
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}