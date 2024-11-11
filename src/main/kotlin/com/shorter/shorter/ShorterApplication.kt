package com.shorter.shorter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShorterApplication

fun main(args: Array<String>) {
	runApplication<ShorterApplication>(*args)
}
