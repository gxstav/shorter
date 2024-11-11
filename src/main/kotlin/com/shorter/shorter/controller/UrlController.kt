package com.shorter.shorter.controller

import com.shorter.shorter.model.Url
import com.shorter.shorter.service.UrlService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class UrlController(private val urlService: UrlService) {
    @PostMapping("/api")
    fun createShortUrl(@RequestBody request: CreateUrlRequest): ResponseEntity<Url> {
        val url = urlService.createShortUrl(request.longUrl)
        return ResponseEntity(url, HttpStatus.CREATED)
    }

    @GetMapping("/api/{shortUrl}")
    fun getLongUrl(@PathVariable shortUrl: String): ResponseEntity<String> {
        val longUrl = urlService.getLongUrl(shortUrl)
        return if (longUrl != null) {
            ResponseEntity.ok(longUrl)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping("/link/{shortUrl}")
    fun redirectToLongUrl(@PathVariable("shortUrl") shortUrl: String): ResponseEntity<Any> {
        // Skip redirect for specific paths if needed
        if (shortUrl == "favicon.ico") {
            return ResponseEntity.notFound().build()
        }

        val longUrl = urlService.getLongUrl(shortUrl)

        return if (longUrl != null) {
            val headers = HttpHeaders()
            headers.add("Location", longUrl)
            ResponseEntity.status(HttpStatus.FOUND).headers(headers).build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

data class CreateUrlRequest(
    val longUrl: String
)