package com.network.mylittletale.tale.model.dto;

import java.sql.Date;

public class TaleDTO {
    private int taleNo;
    private java.sql.Date createDate;
    private java.sql.Date lastViewDate;
    private String isDelete;
    private int childNo;

    public TaleDTO() {
    }

    public TaleDTO(int taleNo, Date createDate, Date lastViewDate, String isDelete, int childNo) {
        this.taleNo = taleNo;
        this.createDate = createDate;
        this.lastViewDate = lastViewDate;
        this.isDelete = isDelete;
        this.childNo = childNo;
    }

    public int getTaleNo() {
        return taleNo;
    }

    public void setTaleNo(int taleNo) {
        this.taleNo = taleNo;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastViewDate() {
        return lastViewDate;
    }

    public void setLastViewDate(Date lastViewDate) {
        this.lastViewDate = lastViewDate;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public int getChildNo() {
        return childNo;
    }

    public void setChildNo(int childNo) {
        this.childNo = childNo;
    }

    @Override
    public String toString() {
        return "TaleDTO{" +
                "taleNo=" + taleNo +
                ", createDate=" + createDate +
                ", lastViewDate=" + lastViewDate +
                ", isDelete='" + isDelete + '\'' +
                ", childNo=" + childNo +
                '}';
    }
}
