package com.challenge.converter.models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QueryCurrency {
    public CurrencyExchangeRate getCurrency(String inputCurrency, String outputCurrency, double value){
        URI url = URI.create("https://v6.exchangerate-api.com/v6/"+System.getenv("API_KEY")+"/pair/"+inputCurrency+"/"+outputCurrency+"/"+value);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CurrencyExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa divisa.");
        }
    }
}
