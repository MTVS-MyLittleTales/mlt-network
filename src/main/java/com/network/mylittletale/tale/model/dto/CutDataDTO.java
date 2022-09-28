package com.network.mylittletale.tale.model.dto;


public class CutDataDTO {
    private  int cutNo;
    private String inputSentence;
    private int taleNo;
    private int cutSequence;
    private String imgName;
    private String memberYN;

    public CutDataDTO() {
    }

    public CutDataDTO(int cutNo, String inputSentence, int taleNo, int cutSequence, String imgName, String memberYN) {
        this.cutNo = cutNo;
        this.inputSentence = inputSentence;
        this.taleNo = taleNo;
        this.cutSequence = cutSequence;
        this.imgName = imgName;
        this.memberYN = memberYN;
    }

    public int getCutNo() {
        return cutNo;
    }

    public void setCutNo(int cutNo) {
        this.cutNo = cutNo;
    }

    public String getInputSentence() {
        return inputSentence;
    }

    public void setInputSentence(String inputSentence) {
        this.inputSentence = inputSentence;
    }

    public int getTaleNo() {
        return taleNo;
    }

    public void setTaleNo(int taleNo) {
        this.taleNo = taleNo;
    }

    public int getCutSequence() {
        return cutSequence;
    }

    public void setCutSequence(int cutSequence) {
        this.cutSequence = cutSequence;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getMemberYN() {
        return memberYN;
    }

    public void setMemberYN(String memberYN) {
        this.memberYN = memberYN;
    }

    @Override
    public String toString() {
        return "CutDataDTO{" +
                "cutNo=" + cutNo +
                ", inputSentence='" + inputSentence + '\'' +
                ", taleNo=" + taleNo +
                ", cutSequence=" + cutSequence +
                ", imgName='" + imgName + '\'' +
                ", memberYN='" + memberYN + '\'' +
                '}';
    }
}