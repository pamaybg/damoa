package com.example.asyncpractice.repository.jpa

import com.example.asyncpractice.entity.Clndr
import org.springframework.data.jpa.repository.JpaRepository

interface ClndrRepository : JpaRepository<Clndr, String> {
}