package com.example.demo.OpenBankingDemo.aysnc;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CountryClient {
    RestTemplate restTemplate = new RestTemplate();

    @Async
    public CompletableFuture<List<Country>> getCountriesByLanguage(String language) {
        String url = "https://restcountries.eu/rest/v2/lang/" + language + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);

        return CompletableFuture.completedFuture(Arrays.asList(response));
    }

    @Async
    public CompletableFuture<List<Country>> getCountriesByRegion(String region) {
        String url = "https://restcountries.eu/rest/v2/region/" + region + "?fields=name";
        Country[] response = restTemplate.getForObject(url, Country[].class);

        return CompletableFuture.completedFuture(Arrays.asList(response));
    }
}
