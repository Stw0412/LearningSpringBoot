package com.example.demo.model;

public class StudentModel {
	private String name;
   
    private String surName;
    private int age;

    public StudentModel() {
    }

    public StudentModel(String name, String surName,int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
       
    }

    // Getter และ Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
		return surName;
	}
    public void setSurName(String surName) {
		this.surName = surName;
	}
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
