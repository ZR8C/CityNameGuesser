package org.zr8c.cincinnati

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform