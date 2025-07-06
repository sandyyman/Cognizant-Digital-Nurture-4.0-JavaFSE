package com.ormlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country {

    @Id
    private String code;
    private String name;

    // ✅ No-arg constructor required by JPA
    public Country() {
    }

    // ✅ Optional convenience constructor
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // ✅ Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
