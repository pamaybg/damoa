package com.example.asyncpractice.entity

import jakarta.persistence.*
import java.io.Serializable


@Embeddable
class MbrClndrRltnId(
    @Column(name = "MBR_ID")
    var mbrId: String,

    @Column(name = "CLNDR_ID")
    var clndrId: String
) : Serializable

@Entity
@Table(name = "MBR_CLNDR_RLTN", schema = "damoa")
class MbrClndrRltn : BaseEntity() {
    @EmbeddedId
    lateinit var id: MbrClndrRltnId

    @ManyToOne
    @JoinColumn(name = "MBR_ID", insertable = false, updatable = false)
    lateinit var mbr: Mbr

    @ManyToOne
    @JoinColumn(name = "CLNDR_ID", insertable = false, updatable = false)
    lateinit var clndr: Clndr

    @Column(name = "DSPL_YN", length = 1, nullable = false)
    var dsplYn: String = "1"

    @Column(name = "DSPL_SEQ")
    var dsplSeq: Int? = null

    @Column(name = "PUSH_YN", length = 1)
    var pushYn: String? = null
}
