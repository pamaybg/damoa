package com.example.asyncpractice.entity

import jakarta.persistence.*


@Entity
@Table(name = "MBR_GRP", schema = "damoa")
class MbrGrp : BaseEntity() {
    @Id
    @Column(name = "ID", length = 32)
    lateinit var id: String

    @OneToMany(mappedBy = "mbrGrp")
    var mbrGrpRltns: MutableList<MbrGrpRltn>? = mutableListOf()

    @OneToMany(mappedBy = "mbrGrp")
    var clndrs: MutableList<Clndr> = mutableListOf()

    @Column(name = "GRP_NM", length = 20)
    var name: String? = null
}
