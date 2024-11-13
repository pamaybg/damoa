package com.example.asyncpractice.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "MBR", schema = "damoa")
class Mbr : BaseEntity() {
    @Id
    @Column(name = "ID", length = 32)
    lateinit var id: String

    @OneToMany(mappedBy = "mbr")
    val mbrClndrRltns: MutableList<MbrClndrRltn> = mutableListOf()

    @OneToMany(mappedBy = "mbr")
    val mbrGrpRltns: MutableList<MbrGrpRltn> = mutableListOf()

    @OneToMany(mappedBy = "mbr")
    val plnHsts: MutableList<PlnHst> = mutableListOf()

    @Column(name = "MBR_NM", length = 20)
    val mbrNm: String? = null

    @Column(name = "AGE")
    val age: Int? = null

    @Column(name = "GNDR_TYP", length = 1)
    val gndrTyp: String? = null

    @Column(name = "JOIN_DATE")
    val joinDate: LocalDateTime? = null
}
