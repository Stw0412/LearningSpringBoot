package com.example.demo.dto;


public class CowDTO {
    private Long id;
    private String cowName;
    private String birth;
    private String type;

    public CowDTO(Long id, String cowName, String birth, String type) {
        this.id = id;
        this.cowName = cowName;
        this.birth = birth;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getCowName() {
        return cowName;
    }

    public String getBirth() {
        return birth;
    }

    public String getType() {
        return type;
    }
}
