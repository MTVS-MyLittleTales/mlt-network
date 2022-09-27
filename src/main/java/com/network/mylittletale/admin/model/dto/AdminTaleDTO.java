package com.network.mylittletale.admin.model.dto;

import java.sql.Date;

public class AdminTaleDTO {
    private String taleNo;
    private java.sql.Date createdDate;
    private java.sql.Date lastViewedDate;
    private char isDelete;
    private int childNo;

    public AdminTaleDTO() {
    }

    public AdminTaleDTO(String taleNo, Date createdDate, Date lastViewedDate, char isDelete, int childNo) {
        this.taleNo = taleNo;
        this.createdDate = createdDate;
        this.lastViewedDate = lastViewedDate;
        this.isDelete = isDelete;
        this.childNo = childNo;
    }

    public String getTaleNo() {
        return taleNo;
    }

    public void setTaleNo(String taleNo) {
        this.taleNo = taleNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastViewedDate() {
        return lastViewedDate;
    }

    public void setLastViewedDate(Date lastViewedDate) {
        this.lastViewedDate = lastViewedDate;
    }

    public char getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(char isDelete) {
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
        return "AdminTaleDTO{" +
                "taleNo='" + taleNo + '\'' +
                ", createdDate=" + createdDate +
                ", lastViewedDate=" + lastViewedDate +
                ", isDelete=" + isDelete +
                ", childNo=" + childNo +
                '}';
    }
}
