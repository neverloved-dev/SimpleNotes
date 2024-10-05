package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Ping {
    @GetMapping("/ping")
    fun pingServer():String{
        return "Pong"
    }
}