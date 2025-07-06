package com.ormlearn;

import com.ormlearn.model.Country;
import com.ormlearn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Manually insert countries
        Country c1 = new Country("IN", "India");
        Country c2 = new Country("US", "United States");
        Country c3 = new Country("JP", "Japan");

        countryService.saveCountry(c1);
        countryService.saveCountry(c2);
        countryService.saveCountry(c3);

        System.out.println("All Countries:");
        countryService.getAllCountries().forEach(System.out::println);
    }
}
