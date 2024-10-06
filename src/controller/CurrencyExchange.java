package controller;

import com.google.gson.Gson;
import model.Currency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyExchange {
    public Currency exchange(String originCurrency, String targetCurrency, double amount) {
        String url = "https://v6.exchangerate-api.com/v6/590abf8dc507c1d71a431707/pair/" + originCurrency + "/" + targetCurrency + "/" + amount;
        URI apiUri = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiUri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
