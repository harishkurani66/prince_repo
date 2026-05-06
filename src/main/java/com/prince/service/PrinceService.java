package com.prince.service;

import com.prince.entity.Prince;
import com.prince.paylod.PrinceDto;
import com.prince.repository.PrinceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PrinceService {
    private PrinceRepository princeRepository;
    private ModelMapper modelMapper;

    public PrinceService(PrinceRepository princeRepository, ModelMapper modelMapper) {
        this.princeRepository = princeRepository;
        this.modelMapper = modelMapper;
    }

    public PrinceDto addPrinceDetails(PrinceDto princeDto) {
        //copy Dto to entity

        Prince princes = mapToEntity(princeDto);
        Prince savedEntity = princeRepository.save(princes);

        // copy entity to dto

        PrinceDto dto = mapToDto(savedEntity);
        return dto;
    }

    Prince mapToEntity(PrinceDto princeDto){
        Prince princes = modelMapper.map(princeDto,Prince.class);
        return princes;
    }

    PrinceDto mapToDto(Prince prince){
        PrinceDto dto = modelMapper.map(prince,PrinceDto.class);
        return dto;
    }

    public PrinceDto updatePrince(PrinceDto princeDto, Long id) {

        Prince prince = princeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prince not found"));

        // update fields
        prince.setName(princeDto.getName());
        prince.setEmail(princeDto.getEmail());
        prince.setMobile(princeDto.getMobile());
      //  Prince princes = mapToEntity(princeDto);

        Prince savedPrince = princeRepository.save(prince);

        return mapToDto(savedPrince);
    }
}
