package com.example.asyncpractice.repository.jpa

import com.example.asyncpractice.entity.MbrGrpRltn
import org.springframework.data.jpa.repository.JpaRepository

interface MbrGrpRltnRepository : JpaRepository<MbrGrpRltn, String> {
}