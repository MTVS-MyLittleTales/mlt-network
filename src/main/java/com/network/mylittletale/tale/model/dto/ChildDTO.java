package com.network.mylittletale.tale.model.dto;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ChildDTO {
    String name;
    String gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    java.util.Date birth;

    public ChildDTO() {
    }

    public ChildDTO(String name, String gender, Date birth) {
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "ChildDTO{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birth=" + birth +
                '}';
    }
}
