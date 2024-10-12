package com.example.demo.controllers

import com.example.demo.models.User
import com.example.demo.models.dto.UserLoginDTO
import com.example.demo.services.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @GetMapping("/:id")
    fun getUserById(@RequestParam("id") userId:String):Any{
        return userService.getUserById(UUID.fromString(userId))
    }

    @PostMapping("/register")
    fun registerNewUser(@RequestBody() user:User){
        userService.registerNewUser(user)
    }

    @GetMapping("/login")
    fun logInUser(@RequestBody() userLoginDTO: UserLoginDTO){

    }
}