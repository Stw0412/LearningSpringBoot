package com.example.demo.dto;

import java.util.List;

public class FarmWithCowsDTO {
    private Long id;
    private String name;
    private OwnerDTO owner;
    private List<CowDTO> cows;

    public FarmWithCowsDTO(Long id, String name, OwnerDTO owner, List<CowDTO> cows) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.cows = cows;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public List<CowDTO> getCows() {
        return cows;
    }
}
