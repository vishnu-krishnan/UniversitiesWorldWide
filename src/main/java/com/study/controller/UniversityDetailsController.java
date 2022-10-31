package com.study.controller;

import com.study.entity.UniversityDetails;
import com.study.service.UniversityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityDetailsController {

    @Autowired
    UniversityDetailsService universityDetailsService;

    @GetMapping
    public List<UniversityDetails> getUniversityDetails(){
        return universityDetailsService.getUniversityDetails();
    }

    @PostMapping
    public void postUniversityDetails(@RequestBody UniversityDetailsDto universityDetailsDto){
        universityDetailsService.add(universityDetailsDto);
    }

    @GetMapping("/{country}")
    public UniversityDetails getByCountry(@PathVariable (required = true) String country){
        return universityDetailsService.getByCountry(country);
    }

    @GetMapping("/{state}")
    public UniversityDetails getByState(@PathVariable (required = true) String state){
        return universityDetailsService.getByState(state);
    }

    @GetMapping("/{domain}")
    public UniversityDetails getByDomain(@PathVariable (required = true) String domain){
        return universityDetailsService.getByDomain(domain);
    }

    @DeleteMapping("/{domain}")
    public void deleteUniversityDetails(@PathVariable (required = true) String domain) {
        universityDetailsService.delete(domain);
    }
}
