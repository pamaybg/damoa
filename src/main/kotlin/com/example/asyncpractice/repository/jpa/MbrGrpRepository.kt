package com.example.asyncpractice.repository.jpa

import com.example.asyncpractice.entity.MbrGrp
import org.springframework.data.jpa.repository.JpaRepository

interface MbrGrpRepository : JpaRepository<MbrGrp, String> {
}