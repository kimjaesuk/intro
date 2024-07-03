package com.ohgiraffers.section02.onetomany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class CategoryAndMenuTests {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }
    @BeforeEach
    public void initManager(){
        this.entityManager = entityManagerFactory.createEntityManager();
    }
    @AfterEach
    public void closeManager(){
        this.entityManager.close();
    }
    @AfterAll
    public static void closeFactory(){
        entityManagerFactory.close();
    }
    @Test
    public void 일대다_연관관계_객체_그래프_탐색을_이용항_조회_테스트(){
        int categoeyCode = 10;
        CategoryAndMenu categoryAndMenu = entityManager.find(CategoryAndMenu.class,categoeyCode);
        Assertions.assertNotNull(categoryAndMenu);
        System.out.println(categoryAndMenu);
    }
}
