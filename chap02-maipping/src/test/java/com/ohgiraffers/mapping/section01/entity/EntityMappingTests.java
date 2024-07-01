package com.ohgiraffers.mapping.section01.entity;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Date;

public class EntityMappingTests {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    //    엔티티공장 생성
    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    //    엔티티 메니저 생성
    @BeforeEach
    public void initManager() {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    //    메니저 종료
    @AfterEach
    public void closeManager() {
        this.entityManager.close();
    }

    //    공장 종룔
    @AfterAll
    public static void closeFactory() {
        entityManagerFactory.close();
    }

    @Test
    public void 테이블_만들기_테스트() {
        // given
        Member member = new Member();
        member.setMemberNo(1);
        member.setMemberId("홍길동");
        member.setMemberPwd("pass01");
        member.setNickName("user01");
        member.setAddress("강남구");
        member.setEnrollDate(new Date());
        member.setPhone("001");
        member.setMemberRole("게스트");
        member.setStatus("y");

        // when
        entityManager.persist(member);

        // then
        Member foundMember = entityManager.find(Member.class, 1);
        Assertions.assertEquals(member.getMemberNo(), foundMember.getMemberNo());

    }

}
