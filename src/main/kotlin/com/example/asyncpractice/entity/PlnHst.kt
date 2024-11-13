package com.example.asyncpractice.entity

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime

@Embeddable
class PlnHstId(
    @Column(name = "PLN_ID")
    val plnId: String,

    @Column(name = "MBR_ID")
    val mbrId: String,

    @Column(name = "HST_DATE")
    val hstDate: LocalDateTime = LocalDateTime.now()
) : Serializable

@Entity
@Table(name = "PLN_HST", schema = "damoa")
class PlnHst : BaseEntity() {

    @EmbeddedId
    lateinit var id: PlnHstId

    @ManyToOne
    @JoinColumn(name = "MBR_ID", insertable = false, updatable = false)
    lateinit var mbr: Mbr

    @ManyToOne
    @JoinColumn(name = "PLN_ID", insertable = false, updatable = false)
    lateinit var pln: Pln

    @Column(name = "HST_TYP", length = 2)
    val hstTyp: String? = null
}
