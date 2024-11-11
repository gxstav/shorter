package com.shorter.shorter.repository

import com.shorter.shorter.model.Url
import org.springframework.data.jpa.repository.JpaRepository

interface UrlRepository: JpaRepository<Url, String>