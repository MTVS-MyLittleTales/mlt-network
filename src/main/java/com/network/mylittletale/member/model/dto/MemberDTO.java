package com.network.mylittletale.member.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MemberDTO implements UserDetails {

    private int memberNo;                   //회원 번호
    private String memberId;                //회원 아이디
    private String memberPwd;               //회원 비밀번호
    private Character tempPwdYn;            //임시 비밀번호 여부
    private String memberName;              //회원 이름
    private Date memberRegistDatetime;      //회원 가입 일시
    private Date memberSecessionDatetime;   //계정 탈퇴 일시
    private Character memberSecessionYn;    //계정 탈퇴 여부
    private String memberRole;              //회원 권환

    public MemberDTO() {}

    public MemberDTO(int memberNo, String memberId, String memberPwd, Character tempPwdYn, String memberName, Date memberRegistDatetime, Date memberSecessionDatetime, Character memberSecessionYn, String memberRole) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.tempPwdYn = tempPwdYn;
        this.memberName = memberName;
        this.memberRegistDatetime = memberRegistDatetime;
        this.memberSecessionDatetime = memberSecessionDatetime;
        this.memberSecessionYn = memberSecessionYn;
        this.memberRole = memberRole;
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

    public Character getTempPwdYn() {
        return tempPwdYn;
    }

    public void setTempPwdYn(Character tempPwdYn) {
        this.tempPwdYn = tempPwdYn;
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

    public Date getMemberSecessionDatetime() {
        return memberSecessionDatetime;
    }

    public void setMemberSecessionDatetime(Date memberSecessionDatetime) {
        this.memberSecessionDatetime = memberSecessionDatetime;
    }

    public Character getMemberSecessionYn() {
        return memberSecessionYn;
    }

    public void setMemberSecessionYn(Character memberSecessionYn) {
        this.memberSecessionYn = memberSecessionYn;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", tempPwdYn='" + tempPwdYn + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberRegistDatetime=" + memberRegistDatetime +
                ", memberSecessionDatetime=" + memberSecessionDatetime +
                ", memberSecessionYn=" + memberSecessionYn +
                ", memberRole='" + memberRole + '\'' +
                '}';
    }

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (String role : memberRole.split(",")) {
            roles.add(new SimpleGrantedAuthority(role));
        }

        return roles;
    }

    @Override
    public String getPassword() {
        return memberPwd;
    }

    @Override
    public String getUsername() {
        return memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

