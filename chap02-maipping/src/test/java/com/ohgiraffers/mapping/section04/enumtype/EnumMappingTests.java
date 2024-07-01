package com.ohgiraffers.mapping.section04.enumtype;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Date;

public class EnumMappingTests {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    //    엔티티공장 생성
    @BeforeAll
    public static void initFactory() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    //    엔티티 메니저 생성
    @BeforeEach
    public void initManager(){
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    //    메니저 종료
    @AfterEach
    public void closeManager(){
        this.entityManager.close();
    }

    //    공장 종룔
    @AfterAll
    public static void closeFactory(){
        entityManagerFactory.close();
    }

    @Test
    public void enun_객체_테스트(){
        // given
        Member member = new Member();
        member.setMemberId("테스트 길동");
        member.setMemberPwd("pass01");
        member.setNickName("user01");
        member.setAddress("강남구");
        member.setEnrollDate(new Date());
        member.setPhone("001");
        member.setMemberRole(Roletype.USER);
        member.setStatus("y");

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(member);
        transaction.commit();

        // then
        Member foundMember = entityManager.find(Member.class, member.getMemberNo());
        Assertions.assertEquals(member.getMemberNo(), foundMember.getMemberNo());

    }

}
