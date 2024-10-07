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
    var title:String,
    @Column
    var content: String,
    @Column
    val createdAt: Date
)
