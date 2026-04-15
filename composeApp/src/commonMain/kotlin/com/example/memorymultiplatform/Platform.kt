package com.example.memorymultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform