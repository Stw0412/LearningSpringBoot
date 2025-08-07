package com.example.demo.Controller;

import com.example.demo.entities.Cow;
import com.example.demo.repositories.CowRepository;
import com.example.demo.repositories.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.CowDTO;
import com.example.demo.dto.CowSearchRequest;
import com.example.demo.dto.OwnerDTO;
import com.example.demo.dto.FarmWithCowsDTO;
import com.example.demo.entities.Owner;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/cows")
public class CowController {

    @Autowired
    private CowRepository cowRepo;

    @Autowired
    private FarmRepository farmRepo;

    @GetMapping("/getCowList/{farmId}")
    public ResponseEntity<?> getCowListByFarm(@PathVariable Long farmId) {
        return farmRepo.findById(farmId).map(farm -> {
            Owner owner = farm.getOwner();
            OwnerDTO ownerDTO = new OwnerDTO(
                    owner.getId(),
                    owner.getName(),
                    owner.getSurName(),
                    owner.getAddress()
            );

            List<CowDTO> cowDTOs = farm.getCows().stream()
                    .map(cow -> new CowDTO(
                            cow.getId(),
                            cow.getCowName(),
                            cow.getBirth().toString(),
                            cow.getType()
                    )).toList();

            FarmWithCowsDTO farmDTO = new FarmWithCowsDTO(
                    farm.getId(),
                    farm.getName(),
                    ownerDTO,
                    cowDTOs
            );

            return ResponseEntity.ok(farmDTO);
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping("/cowSearch")
    public ResponseEntity<?> searchCowByName(@RequestBody CowSearchRequest request) {
        String name = request.getName();

        List<Cow> cows = cowRepo.findByCowNameContainingIgnoreCase(name);

        List<FarmWithCowsDTO> result = cows.stream().map(cow -> {
            Owner owner = cow.getFarm().getOwner();
           
            CowDTO cowDTO = new CowDTO(
                    cow.getId(),
                    cow.getCowName(),
                    cow.getBirth().toString(),
                    cow.getType()
            );
            
            OwnerDTO ownerDTO = new OwnerDTO(
                    owner.getId(),
                    owner.getName(),
                    owner.getSurName(),
                    owner.getAddress()
            );

           

            FarmWithCowsDTO farmDTO = new FarmWithCowsDTO(
                    cow.getFarm().getId(),
                    cow.getFarm().getName(),
                    ownerDTO,
                    List.of(cowDTO)
            );

            return farmDTO;
        }).toList();

        return ResponseEntity.ok(result);
    }
}

