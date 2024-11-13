package com.example.asyncpractice.repository.jpa

import com.example.asyncpractice.entity.Mbr
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MbrRepository : JpaRepository<Mbr, String> {
}