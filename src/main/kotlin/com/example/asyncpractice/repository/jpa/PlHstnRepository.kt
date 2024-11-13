package com.example.asyncpractice.repository.jpa

import com.example.asyncpractice.entity.PlnHst
import org.springframework.data.jpa.repository.JpaRepository

interface PlHstnRepository : JpaRepository<PlnHst, String> {
}