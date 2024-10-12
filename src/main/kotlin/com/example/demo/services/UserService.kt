package com.example.demo.services

import com.example.demo.exceptions.UserNotFoundException
import com.example.demo.models.User
import com.example.demo.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val repository: UserRepository) {

    fun registerNewUser(user: User){
        repository.save(user)
    }

    fun getUserById(id: UUID):Any{
        val user = repository.findById(id)
        if (user == null){
            return UserNotFoundException()
        }
        return user
    }
}