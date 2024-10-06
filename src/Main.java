import controller.CurrencyExchange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyExchange currencyExchange = new CurrencyExchange();
        String supportedCurrencies = """
                Supported Currencies:
                [ MXN, USD, EUR, GBP, JPY, AUD, CAD, CHF, CNY, SEK, NZD ]""";

        System.out.println(supportedCurrencies);
        System.out.println("Enter the origin currency: ");
        String originCurrency = scanner.nextLine().toUpperCase();
        System.out.println("Enter the target currency to convert to: ");
        String targetCurrency = scanner.nextLine().toUpperCase();
        System.out.println("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        try {
            var convertedCurrency = currencyExchange.exchange(originCurrency, targetCurrency, amount);
            System.out.println("The amount of " + amount + " [" + originCurrency + "] is equal to " +
                    convertedCurrency.conversion_result() + " [" + targetCurrency + "]\n" +
                    "With a conversion rate of " + convertedCurrency.conversion_rate());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
}
