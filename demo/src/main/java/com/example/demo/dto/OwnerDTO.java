package com.example.demo.dto;

public class OwnerDTO {
    private Long id;
    private String name;
    private String surName;
    private String address;

    public OwnerDTO(Long id, String name, String surName, String address) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getAddress() {
        return address;
    }
}
