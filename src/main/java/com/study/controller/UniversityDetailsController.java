package com.study.controller;

import com.study.dto.UniversityDetailsDto;
import com.study.entity.UniversityDetails;
import com.study.service.UniversityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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

    @GetMapping("/country/{country}")
    public UniversityDetails getByCountry(@PathVariable (required = true) String country){
        return universityDetailsService.getByCountry(country);
    }

    @GetMapping("/state/{state}")
    public UniversityDetails getByState(@PathVariable (required = true) String state){
        return universityDetailsService.getByState(state);
    }

    @GetMapping("/domain/{domain}")
    public UniversityDetails getByDomain(@PathVariable (required = true) String domain){
        return universityDetailsService.getByDomain(domain);
    }

    @DeleteMapping("/{domain}")
    public void deleteUniversityDetails(@PathVariable (required = true) String domain) {
        universityDetailsService.delete(domain);
    }

    @GetMapping(value = "/callUniversityApi")
    public List<Object> getUniversityDetailsApi(){

        String url = "http://universities.hipolabs.com/search?country=india";
        RestTemplate restTemplate = new RestTemplate();
        Object[] universities = restTemplate.getForObject(url, Object[].class);
        System.out.println(universities);
        return Arrays.asList(universities);
    }
}
