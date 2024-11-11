package com.shorter.shorter.service

import com.shorter.shorter.model.Url
import com.shorter.shorter.repository.UrlRepository
import java.security.MessageDigest
import org.springframework.stereotype.Service
import java.util.Base64

@Service
class UrlService (private val urlRepository: UrlRepository) {
    fun createShortUrl(longUrl: String): Url {
        val shortUrl = generateShortUrl(longUrl)
        val url = Url(shortUrl, longUrl)
        return urlRepository.save(url)
    }

    fun getLongUrl(shortUrl: String): String? {
        return urlRepository.findById(shortUrl).map{ url -> url.longUrl }.orElse(null)
    }

    private fun generateShortUrl(longUrl: String): String {
        val md = MessageDigest.getInstance("MD5")
        val hashUrl = md.digest(longUrl.toByteArray())
        return Base64.getUrlEncoder().encodeToString(hashUrl).substring(0, 6)
    }
}