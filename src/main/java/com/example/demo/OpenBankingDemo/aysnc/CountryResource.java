package com.example.demo.OpenBankingDemo.aysnc;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
@RestController
public class CountryResource {

    private final CountryClient countryClient;

    public CountryResource(
            CountryClient countryClient
    ) {
        this.countryClient = countryClient;
    }

    @GetMapping("/countries")
    public List<String> getAllEuropeanFrenchSpeakingCountries() throws Throwable {
        CompletableFuture<List<Country>> countriesByLanguageFuture = countryClient.getCountriesByLanguage("fr");
        CompletableFuture<List<Country>> countriesByRegionFuture = countryClient.getCountriesByRegion("europe");
        List<String> europeanFrenchSpeakingCountries;
        try {
            europeanFrenchSpeakingCountries = new ArrayList<>(countriesByLanguageFuture.get().stream().map(Country::getName).collect(Collectors.toList()));
            europeanFrenchSpeakingCountries.retainAll(countriesByRegionFuture.get().stream().map(Country::getName).collect(Collectors.toList()));
        } catch (Throwable e) {
            throw e.getCause();
        }

        return europeanFrenchSpeakingCountries;
    }
}