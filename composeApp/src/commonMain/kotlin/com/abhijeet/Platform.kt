package com.abhijeet

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform