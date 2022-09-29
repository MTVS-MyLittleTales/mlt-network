package com.network.mylittletale.tale.model.dto;

import java.sql.Date;
import java.util.List;

public class TaleDTO {
    private int taleNo;
    private java.sql.Date createdDate;
    private java.sql.Date lastViewDate;
    private String isDelete;
    private int childNo;
    List<CutDataDTO> cutDataDTOList;

    public TaleDTO() {
    }

    public TaleDTO(int taleNo, Date createdDate, Date lastViewDate, String isDelete, int childNo, List<CutDataDTO> cutDataDTOList) {
        this.taleNo = taleNo;
        this.createdDate = createdDate;
        this.lastViewDate = lastViewDate;
        this.isDelete = isDelete;
        this.childNo = childNo;
        this.cutDataDTOList = cutDataDTOList;
    }

    public int getTaleNo() {
        return taleNo;
    }

    public void setTaleNo(int taleNo) {
        this.taleNo = taleNo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public List<CutDataDTO> getCutDataDTOList() {
        return cutDataDTOList;
    }

    public void setCutDataDTOList(List<CutDataDTO> cutDataDTOList) {
        this.cutDataDTOList = cutDataDTOList;
    }

    @Override
    public String toString() {
        return "TaleDTO{" +
                "taleNo=" + taleNo +
                ", createdDate=" + createdDate +
                ", lastViewDate=" + lastViewDate +
                ", isDelete='" + isDelete + '\'' +
                ", childNo=" + childNo +
                ", cutDataDTOList=" + cutDataDTOList +
                '}';
    }
}
