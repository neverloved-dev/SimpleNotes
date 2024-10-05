package com.example.demo.repository

import com.example.demo.models.Note
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NoteRepository:JpaRepository<Note,Int> {

     override fun findById(id:Int): Optional<Note>
     override fun findAll(): MutableList<Note>
}