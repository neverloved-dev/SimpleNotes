package com.example.demo.models

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Data
import org.springframework.transaction.annotation.Transactional
import java.util.Date
import java.util.UUID

@Entity
@Data
@Transactional
@Table(name="users")
data class User(
    @Id
    val id : UUID,
    val username: String,
    val email:String,
    val hashedPasswrod: String,
    val createdAt: Date

)