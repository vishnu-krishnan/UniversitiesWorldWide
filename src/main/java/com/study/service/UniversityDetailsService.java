package com.study.service;

import com.study.dto.UniversityDetailsDto;
import com.study.entity.UniversityDetails;
import com.study.exceptionHandling.UniversityDetailsNotFoundException;
import com.study.repository.UniversityDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UniversityDetailsService {

    @Autowired
    UniversityDetailsRepository repository;

    public void add(UniversityDetailsDto universityDetailsDto){
        repository.save(toEntity(universityDetailsDto));
    }

    public void delete(String domain){
        repository.deleteById(domain);
    }

    public List<UniversityDetails> getUniversityDetails(){
        return (List<UniversityDetails>) repository.findAll();
    }

    public UniversityDetails getByDomain(String domain){
        Optional<UniversityDetails> optionalUniversityDetails = repository.findById(domain);
        return optionalUniversityDetails.orElseThrow(() -> new UniversityDetailsNotFoundException("Couldn't find University detail with domain "+domain));
    }

    public UniversityDetails getByCountry(String country){
        Optional<UniversityDetails> optionalUniversityDetails = repository.findById(country);
        return optionalUniversityDetails.orElseThrow(() -> new UniversityDetailsNotFoundException("Couldn't find University detail with country "+country));
    }

    public UniversityDetails getByState(String state_province){
        Optional<UniversityDetails> optionalUniversityDetails = repository.findById(state_province);
        return optionalUniversityDetails.orElseThrow(() -> new UniversityDetailsNotFoundException("Couldn't find University detail with state "+state_province));
    }

    private UniversityDetails toEntity(UniversityDetailsDto universityDetailsDto) {

        UniversityDetails universityDetailsEntity = new UniversityDetails();
        universityDetailsEntity.setDomain(universityDetailsDto.getDomain());
        universityDetailsEntity.setCountry(universityDetailsDto.getCountry());
        universityDetailsEntity.setAlpha_two_code(universityDetailsDto.getAlpha_two_code());
        universityDetailsEntity.setState_province(universityDetailsDto.getState_province());
        return universityDetailsEntity;
    }


}
