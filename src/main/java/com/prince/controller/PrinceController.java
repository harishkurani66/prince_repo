package com.prince.controller;

import com.prince.entity.Prince;
import com.prince.paylod.PrinceDto;
import com.prince.service.PrinceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/prince")
public class PrinceController {
    private PrinceService princeService;

    public PrinceController(PrinceService princeService) {
        this.princeService = princeService;
    }
    @PostMapping("/savePrince")
    public ResponseEntity<PrinceDto> saveAllPrince(@RequestBody PrinceDto princeDto){
        PrinceDto dtos = princeService.addPrinceDetails(princeDto);
        return new ResponseEntity<>(princeDto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
  public ResponseEntity<PrinceDto> updatePrince(@PathVariable PrinceDto princeDto, Long id){
    PrinceDto Dto = princeService.updatePrince(princeDto,id);
    return new ResponseEntity<>(Dto,HttpStatus.OK);
    }
}