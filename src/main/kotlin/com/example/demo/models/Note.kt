package com.example.demo.models

import jakarta.persistence.*
import lombok.Data
import org.springframework.transaction.annotation.Transactional
import java.util.Date

@Entity
@Data
@Transactional
@Table(name = "notes")
data class Note(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,
    @Column
    val title:String,
    @Column
    val content: String,
    @Column
    val createdAt: Date
)
