package com.example.asyncpractice.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "PLN", schema = "damoa")
class Pln : BaseEntity() {
    @Id
    @Column(name = "ID", length = 32)
    lateinit var id: String

    @ManyToOne
    @JoinColumn(name = "MBR_ID")
    lateinit var mbr: Mbr

    @ManyToOne
    @JoinColumn(name = "CLNDR_ID")
    lateinit var clndr: Clndr

    @OneToMany(mappedBy = "pln")
    var plnHsts: MutableList<PlnHst> = mutableListOf()

    @Column(name = "PLN_NM", length = 20)
    var plnNm: String? = null

    @Column(name = "PLN_START_DT")
    var plnStartDt: LocalDateTime? = null

    @Column(name = "PLN_END_DT")
    var plnEndDt: LocalDateTime? = null

    @Column(name = "PLN_COLOR", length = 20)
    var plnColor: String? = null
}