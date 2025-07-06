package com.ormlearn.service;

import com.ormlearn.model.Country;
import com.ormlearn.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country findByCode(String code) {
        return countryRepository.findById(code).orElse(null);
    }

    public List<Country> searchByPartialName(String part) {
        return countryRepository.findByNameContainingOrderByNameAsc(part);
    }
    public void saveCountry(Country c) {
        countryRepository.save(c);
    }

}
