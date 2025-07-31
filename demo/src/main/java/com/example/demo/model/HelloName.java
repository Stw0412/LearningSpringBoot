package com.example.demo.model;
import jakarta.validation.constraints.NotBlank;



public class HelloName {
	@NotBlank(message = "Name can not be blank")
	  private String name;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }
}

