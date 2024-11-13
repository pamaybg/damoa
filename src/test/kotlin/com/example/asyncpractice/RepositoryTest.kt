package com.example.asyncpractice

import com.example.asyncpractice.config.QueryDslConfig
import com.example.asyncpractice.repository.querydsl.MbrQueryRepository
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(MbrQueryRepository::class, QueryDslConfig::class)
class RepositoryTest {

    @Autowired
    private lateinit var mbrQueryRepository: MbrQueryRepository

    @Test
    @Transactional
    fun test() {

        // 이름으로 회원 조회
        val id1 = mbrQueryRepository.getMemberPlan("MBR_1")

        println("asd");
    }
}