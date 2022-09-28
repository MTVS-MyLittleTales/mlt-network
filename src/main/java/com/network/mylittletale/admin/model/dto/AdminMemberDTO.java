package com.network.mylittletale.admin.model.dto;

import java.sql.Date;

public class AdminMemberDTO {
    private String memberNo;    // 회원 코드
    private String memberId;    // 회원 아이디
    private String memberName;  // 회원 이름
    private java.sql.Date memberRegistDatetime; //회원 가입일
    private char memberSecessionYN;  // 회원 탈퇴 여부
    private java.sql.Date memberSecessionDatetime; // 회원 탈퇴일
    private int childrenCnt; // 자녀 인원수

    public AdminMemberDTO() {
    }

    public AdminMemberDTO(String memberNo, String memberId, String memberName, Date memberRegistDatetime, char memberSecessionYN, Date memberSecessionDatetime, int childrenCnt) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberRegistDatetime = memberRegistDatetime;
        this.memberSecessionYN = memberSecessionYN;
        this.memberSecessionDatetime = memberSecessionDatetime;
        this.childrenCnt = childrenCnt;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getMemberRegistDatetime() {
        return memberRegistDatetime;
    }

    public void setMemberRegistDatetime(Date memberRegistDatetime) {
        this.memberRegistDatetime = memberRegistDatetime;
    }

    public char getMemberSecessionYN() {
        return memberSecessionYN;
    }

    public void setMemberSecessionYN(char memberSecessionYN) {
        this.memberSecessionYN = memberSecessionYN;
    }

    public Date getMemberSecessionDatetime() {
        return memberSecessionDatetime;
    }

    public void setMemberSecessionDatetime(Date memberSecessionDatetime) {
        this.memberSecessionDatetime = memberSecessionDatetime;
    }

    public int getChildrenCnt() {
        return childrenCnt;
    }

    public void setChildrenCnt(int childrenCnt) {
        this.childrenCnt = childrenCnt;
    }

    @Override
    public String toString() {
        return "AdminMemberDTO{" +
                "memberNo='" + memberNo + '\'' +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberRegistDatetime=" + memberRegistDatetime +
                ", memberSecessionYN=" + memberSecessionYN +
                ", memberSecessionDatetime=" + memberSecessionDatetime +
                ", childrenCnt=" + childrenCnt +
                '}';
    }
}
