package com.example.asyncpractice.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {
    @Column(name = "CREATE_DATE", updatable = false)
    var createDate: LocalDateTime? = null

    @Column(name = "MODIFY_DATE")
    var modifyDate: LocalDateTime? = null

    @Column(name = "FLAG", length = 1, nullable = false)
    var flag: String = "1"
}