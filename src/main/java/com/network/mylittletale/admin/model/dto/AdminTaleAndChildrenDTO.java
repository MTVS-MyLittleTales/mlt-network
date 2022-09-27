package com.network.mylittletale.admin.model.dto;

import java.sql.Date;

public class AdminTaleAndChildrenDTO {
    private String taleNo;
    private java.sql.Date createdDate;
    private java.sql.Date lastViewedDate;
    private char isDelete;
    private AdminChildrenAndMemberDTO adminChildrenAndMemberDTO;

    public AdminTaleAndChildrenDTO() {
    }

    public AdminTaleAndChildrenDTO(String taleNo, Date createdDate, Date lastViewedDate, char isDelete, AdminChildrenAndMemberDTO adminChildrenAndMemberDTO) {
        this.taleNo = taleNo;
        this.createdDate = createdDate;
        this.lastViewedDate = lastViewedDate;
        this.isDelete = isDelete;
        this.adminChildrenAndMemberDTO = adminChildrenAndMemberDTO;
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

    public AdminChildrenAndMemberDTO getAdminChildrenAndMemberDTO() {
        return adminChildrenAndMemberDTO;
    }

    public void setAdminChildrenAndMemberDTO(AdminChildrenAndMemberDTO adminChildrenAndMemberDTO) {
        this.adminChildrenAndMemberDTO = adminChildrenAndMemberDTO;
    }

    @Override
    public String toString() {
        return "AdminTaleAndChildrenDTO{" +
                "taleNo='" + taleNo + '\'' +
                ", createdDate=" + createdDate +
                ", lastViewedDate=" + lastViewedDate +
                ", isDelete=" + isDelete +
                ", adminChildrenAndMemberDTO=" + adminChildrenAndMemberDTO +
                '}';
    }
}
