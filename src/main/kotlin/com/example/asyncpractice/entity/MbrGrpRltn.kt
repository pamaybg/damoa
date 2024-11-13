package com.example.asyncpractice.entity

import jakarta.persistence.*
import java.io.Serializable
import java.time.LocalDateTime

@Embeddable
class MbrGrpRltnId(
    @Column(name = "MBR_ID")
    var mbrId: String,

    @Column(name = "GRP_ID")
    var grpId: String
) : Serializable

@Entity
@Table(name = "MBR_GRP_RLTN", schema = "damoa")
class MbrGrpRltn : BaseEntity() {
    @EmbeddedId
    lateinit var id: MbrGrpRltnId

    @ManyToOne
    @JoinColumn(name = "MBR_ID", insertable = false, updatable = false)
    lateinit var mbr: Mbr

    @ManyToOne
    @JoinColumn(name = "GRP_ID", insertable = false, updatable = false)
    lateinit var mbrGrp: MbrGrp

    @Column(name = "RLTN_TYP", length = 2)
    var rltnTyp: String? = null

    @Column(name = "GRP_SEQ")
    var grpSeq: Int? = null

    @Column(name = "JOIN_DATE", nullable = false)
    var joinDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "WDRW_DATE")
    var wdrwDate: LocalDateTime? = null

    @Column(name = "WDRW_YN", length = 1, nullable = false)
    var wdrwYn: String = "0"
}
