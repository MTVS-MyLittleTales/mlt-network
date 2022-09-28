package com.network.mylittletale.tale.model.dto;

import org.apache.ibatis.type.Alias;

import java.util.Date;

public class TaleDTO {

    private int cutNo;
    private int taleNo;
    private String taleName;
    private int memberNo;
    private java.util.Date creationDate;
    private java.util.Date lastLookupDate;

    public TaleDTO() {
    }

    public TaleDTO(int cutNo, int taleNo, String taleName, int memberNo, Date creationDate, Date lastLookupDate) {
        this.cutNo = cutNo;
        this.taleNo = taleNo;
        this.taleName = taleName;
        this.memberNo = memberNo;
        this.creationDate = creationDate;
        this.lastLookupDate = lastLookupDate;
    }

    public int getCutNo() {
        return cutNo;
    }

    public void setCutNo(int cutNo) {
        this.cutNo = cutNo;
    }

    public int getTaleNo() {
        return taleNo;
    }

    public void setTaleNo(int taleNo) {
        this.taleNo = taleNo;
    }

    public String getTaleName() {
        return taleName;
    }

    public void setTaleName(String taleName) {
        this.taleName = taleName;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastLookupDate() {
        return lastLookupDate;
    }

    public void setLastLookupDate(Date lastLookupDate) {
        this.lastLookupDate = lastLookupDate;
    }

    @Override
    public String toString() {
        return "TaleDTO{" +
                "cutNo=" + cutNo +
                ", taleNo=" + taleNo +
                ", taleName='" + taleName + '\'' +
                ", memberNo=" + memberNo +
                ", creationDate=" + creationDate +
                ", lastLookupDate=" + lastLookupDate +
                '}';
    }
}
