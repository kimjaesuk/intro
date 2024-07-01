package com.ohgiraffers.mapping.section02.column;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "member_section02") // 이름은 생략가능
@Table(name = "tbl_member_section02") // DB 테이블과 매칭시킬 이름
public class Member {

//    데이터베이스 생성

    @Id // 프라이머리키 선언 없으면 에러남. 필수값
    @Column(name = "member_no") // 데이터베이스 테이블 컬럼 이름
    private int memberNo;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pwd")
    private String memberPwd;

    @Column(name = "nickName")
    @Transient
    private String nickName;

    // 컬럼 길이를 varchar 200으로 정의하고 없을땐 기본 값을 정해줌
    @Column(name = "phone", columnDefinition = "varchar(200) default '010-0000-0000'")
    private String phone;

    @Column(name = "address", unique = true) // 유니크 제약조건을 검
    private String address;

    @Column(name = "erroll_data")
    @Temporal(TemporalType.TIMESTAMP) // 시간
    private Date enrollDate;

    @Column(name = "member_role", nullable = false) // null을 허용할 것인가.
    private String memberRole;

    @Column(name = "status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickName, String phone, String address, Date enrollDate, String memberRole, String status) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickName = nickName;
        this.phone = phone;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole='" + memberRole + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
