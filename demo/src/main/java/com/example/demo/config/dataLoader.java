package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.Cow;
import com.example.demo.entities.Farm;
import com.example.demo.entities.Owner;
import com.example.demo.repositories.CowRepository;
import com.example.demo.repositories.FarmRepository;
import com.example.demo.repositories.OwnerRepository;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class dataLoader {

 /*   @Bean
    public CommandLineRunner loadData(OwnerRepository ownerRepo, FarmRepository farmRepo, CowRepository cowRepo) {
        return args -> {
            // Owner 1
            Owner owner1 = new Owner();
            owner1.setName("Painon");
            owner1.setSurName("Hsr");
            owner1.setAddress("Chiang Mai");

            // Farm 1
            Farm farm1 = new Farm();
            farm1.setName("Rangdow");
            farm1.setOwner(owner1);

            // Cow 1
            Cow cow1 = new Cow();
            cow1.setCowName("NongKluy");
            cow1.setBirth(LocalDate.of(2020, 3, 10));
            cow1.setType("Holstein");
            cow1.setFarm(farm1);

            Cow cow2 = new Cow();
            cow2.setCowName("Nongtonhom");
            cow2.setBirth(LocalDate.of(2021, 5, 20));
            cow2.setType("Jersey");
            cow2.setFarm(farm1);

            farm1.setCows(Arrays.asList(cow1, cow2));
            owner1.setFarms(Arrays.asList(farm1));

            ownerRepo.save(owner1);

            // Owner 2
            Owner owner2 = new Owner();
            owner2.setName("March7");
            owner2.setSurName("konsouy");
            owner2.setAddress("Khon Kaen");

            // Farm 2
            Farm farm2 = new Farm();
            farm2.setName("Nong March Farm");
            farm2.setOwner(owner2);

            // Cow 3
            Cow cow3 = new Cow();
            cow3.setCowName("Lulu");
            cow3.setBirth(LocalDate.of(2019, 7, 15));
            cow3.setType("Thai Native");
            cow3.setFarm(farm2);

            farm2.setCows(Arrays.asList(cow3));
            owner2.setFarms(Arrays.asList(farm2));

            ownerRepo.save(owner2);
        };
    }*/
}

