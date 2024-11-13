package com.example.asyncpractice.repository.jpa

import com.example.asyncpractice.entity.Pln
import org.springframework.data.jpa.repository.JpaRepository

interface PlnRepository : JpaRepository<Pln, String> {
}