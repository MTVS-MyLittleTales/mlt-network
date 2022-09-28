package com.network.mylittletale.admin.model.dto;

import java.sql.Date;

public class AdminChildrenAndMemberDTO {
    private int childNo;
    private String childName;
    private java.sql.Date childBirth;
    private String childGender;
    private AdminMemberDTO adminMemberDTO;

    public AdminChildrenAndMemberDTO() {
    }

    public AdminChildrenAndMemberDTO(int childNo, String childName, Date childBirth, String childGender, AdminMemberDTO adminMemberDTO) {
        this.childNo = childNo;
        this.childName = childName;
        this.childBirth = childBirth;
        this.childGender = childGender;
        this.adminMemberDTO = adminMemberDTO;
    }

    public int getChildNo() {
        return childNo;
    }

    public void setChildNo(int childNo) {
        this.childNo = childNo;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public Date getChildBirth() {
        return childBirth;
    }

    public void setChildBirth(Date childBirth) {
        this.childBirth = childBirth;
    }

    public String getChildGender() {
        return childGender;
    }

    public void setChildGender(String childGender) {
        this.childGender = childGender;
    }

    public AdminMemberDTO getAdminMemberDTO() {
        return adminMemberDTO;
    }

    public void setAdminMemberDTO(AdminMemberDTO adminMemberDTO) {
        this.adminMemberDTO = adminMemberDTO;
    }

    @Override
    public String toString() {
        return "AdminChildrenAndMemberDTO{" +
                "childNo=" + childNo +
                ", childName='" + childName + '\'' +
                ", childBirth=" + childBirth +
                ", childGender='" + childGender + '\'' +
                ", adminMemberDTO=" + adminMemberDTO +
                '}';
    }
}
