package com.ohgiraffers.clone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

public class SimpleJPQLTests {
    /*
     * jpql(Java persistence Query Language)
     * jpql은 엔티티 객체를 중심으로 개발할 수 있는 객체 지양 쿼리이다.
     * sql보다 간결하며 특정 DBMS에 의존하지 않는다.
     * 방언을 통해 해당 DBMS에 맞는 SQL을 싱행하게 된다.
     * JPQL은 find() 메소드를 통한 조회와 다르게 항상 데이터 베이스에 sql을 생행해서 결과를 조회한다
     * */
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }
    @BeforeEach
    public void initManager(){
        entityManager = entityManagerFactory.createEntityManager();
    }
    @AfterEach
    public void closeManager(){
        entityManager.close();
    }
    @AfterAll
    public static void closeFactory(){
        entityManagerFactory.close();
    }
    /*
     * jpql의 기본 문법
     * select, update,delete등의 키워드 사용은 sql과 동일하다
     * insert는 persist()메소드를 사용하면 된다.
     * 키워드는 대소문자를 구분하지 않지만, 엔티티와 속성은 대소문자를 구분함에 유의한다.
     * 엔티티 별칭은 필수로 작성해야 하며 별칭없이 작성하면 에러가 발생한다.
     * */

    /*
     * jpql 사용방법은 다음과 같다.
     * 1. 작성한 jpql(문자열)을 'entityManager.createQuery()' 메소드를 통해 퀘리 객체로 만든다.
     * 2. 쿼리 객체는 'TypedQuery','Qurey' 두 가지 방식이있다.
     * 2-1 TypedQuert : 반환할 타입을 명확하게 지정하는 방식일때 사용하면 쿼리 객체의 메소드 실행을 결과로 지정하는 타입이 반환된다.
     * 2-2 Qurey : 반환할 타입에서 명확하게 지정할 수 없을때 사용하며 쿼리 객체 메소드의 실행 결과로 object 또는 object[]이 반환된다.*
     *
     *
     * 3. 쿼리 객체에서 제공하는 메소드 'getSingLeResult()' 또는 'getResultList()'를 호출하여 쿼리를 실행하고 데이터베이스를 조회한다.
     * 3-1 getSingleResult(): 결과가 정확히 한 행일 경우 사용하며 없거나 많으면 예외가 발생한다.
     * 3-2 getResultList() 결과가 2행 이상일 경우 사용하며 컬렉션을 반환한ㄷ, 결과가 없으면 빈 컬렉션을 반환한다.
     **/

    @Test
    public void TypedQuery_를_이용한_단일메뉴_조회_테스트() {

        String jpql = "SELECT m.menuName FROM menu_section01 as m WHERE m.menuCode=7";

        TypedQuery<String> query = entityManager.createQuery(jpql, String.class);

        String resultMenuName = query.getSingleResult();

        Assertions.assertEquals("민트미역국", resultMenuName);
    }
}

