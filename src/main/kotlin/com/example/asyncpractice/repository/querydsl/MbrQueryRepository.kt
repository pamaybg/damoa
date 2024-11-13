package com.example.asyncpractice.repository.querydsl

import com.example.asyncpractice.dto.MbrDto
import com.example.asyncpractice.entity.QClndr
import com.example.asyncpractice.entity.QMbr
import com.example.asyncpractice.entity.QMbrClndrRltn
import com.example.asyncpractice.entity.QPln
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class MbrQueryRepository(val queryFactory: JPAQueryFactory) {

    fun getMemberPlan(mbrId: String): List<MbrDto> {
        val mbr = QMbr.mbr
        val mbrClndrRltn = QMbrClndrRltn.mbrClndrRltn
        val clndr = QClndr.clndr
        val pln = QPln.pln

        return queryFactory
            .select(
                Projections.constructor(
                    MbrDto::class.java,
                    mbr.id,
                    pln.plnNm
                )
            )
            .from(mbr)
            .leftJoin(mbr.mbrClndrRltns, mbrClndrRltn)
            .leftJoin(mbrClndrRltn.clndr, clndr)
            .leftJoin(clndr.plns, pln)
            .where(mbr.id.eq(mbrId))
            .fetch()
    }
}