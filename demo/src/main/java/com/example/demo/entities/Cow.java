package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cowName;

    private LocalDate birth;

    private String type;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    @JsonBackReference
    private Farm farm;

    // --- Getter/Setter ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCowName() { return cowName; }
    public void setCowName(String cowName) { this.cowName = cowName; }

    public LocalDate getBirth() { return birth; }
    public void setBirth(LocalDate birth) { this.birth = birth; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Farm getFarm() { return farm; }
    public void setFarm(Farm farm) { this.farm = farm; }
}
