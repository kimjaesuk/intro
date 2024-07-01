package com.ohgiraffers.mapping.section05.access;

import com.ohgiraffers.mapping.section04.enumtype.Roletype;
import jakarta.persistence.*;

import java.util.Date;

/*
 * 필드 접근이 기본 값이므로 해당 설정은 제거해도 ㅈ동일하게 동작한다.
 * 또한 필드 레베로가 프로퍼티 레벨에 모두 선언하면 프로퍼티 레벨을 우선으로 한다.
 * */

@Entity(name = "member_section05")
@Table(name = "tbl_member_section05")
// 1. 클래스 레벨 : 모든 필드에 대해서 필드 접근 방식을 적용한다.
@Access(AccessType.FIELD)
public class Member {

//    데이터베이스 생성

    // 2. 필드 레벨 : 해당 피륻에 대해서 필드 접근 방식을 적용한다.
    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.FIELD)
    private int memberNo;

    @Column(name = "member_id")
    @Access(AccessType.FIELD)
    private String memberId;

    @Column(name = "member_pwd")
    @Access(AccessType.FIELD)
    private String memberPwd;

    @Column(name = "nickName")
    @Access(AccessType.FIELD)
    private String nickName;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickName) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickName = nickName;
    }


}
