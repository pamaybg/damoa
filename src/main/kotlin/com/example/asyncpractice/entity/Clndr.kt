package com.example.asyncpractice.entity

import jakarta.persistence.*

@Entity
@Table(name = "CLNDR", schema = "damoa")
class Clndr : BaseEntity() {
    @Id
    @Column(name = "ID", length = 32)
    lateinit var id: String

    @ManyToOne
    @JoinColumn(name = "GRP_ID")
    lateinit var mbrGrp: MbrGrp

    @OneToMany(mappedBy = "clndr")
    var plns: MutableList<Pln> = mutableListOf()

    @Column(name = "CLNDR_NM", length = 20)
    var clndrNm: String? = null

    @Column(name = "CLNDR_TYP", length = 2)
    var clndrTyp: String? = null
}
