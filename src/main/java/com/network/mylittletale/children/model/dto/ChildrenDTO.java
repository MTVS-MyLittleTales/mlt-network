package com.network.mylittletale.children.model.dto;

import java.sql.Date;

public class ChildrenDTO {
    private int childNo;
    private String childName;
    private java.sql.Date childBirth;
    private int memberNo;
    private char childGender;

    public ChildrenDTO() {
    }

    public ChildrenDTO(int childNo, String childName, Date childBirth, int memberNo, char childGender) {
        this.childNo = childNo;
        this.childName = childName;
        this.childBirth = childBirth;
        this.memberNo = memberNo;
        this.childGender = childGender;
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

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public char getChildGender() {
        return this.childGender;
    }

    public void setChildGender(char childGender) {
        this.childGender = childGender;
    }

    @Override
    public String toString() {
        return "ChildrenDTO{" +
                "childNo=" + childNo +
                ", childName='" + childName + '\'' +
                ", childBirth=" + childBirth +
                ", memberNo=" + memberNo +
                ", childGender=" + childGender +
                '}';
    }
}
