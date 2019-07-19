import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Currency chfA = getCurrency("a", "chf");
        Currency chfC = getCurrency("c", "chf");
        System.out.println(chfA.code + " " + chfA.rates[0].mid + "; 100 PLN -> " + String.format("%.2f", 100 / chfC.rates[0].ask) + " CHF");

        Currency eurA = getCurrency("a", "eur");
        Currency eurC = getCurrency("c", "eur");
        System.out.println(eurA.code + " " + eurA.rates[0].mid + "; 100 PLN -> " + String.format("%.2f", 100 / eurC.rates[0].ask) + " EUR");

        Currency gbpA = getCurrency("a", "gbp");
        Currency gbpC = getCurrency("c", "gbp");
        System.out.println(gbpA.code + " " + gbpA.rates[0].mid + "; 100 PLN -> " + String.format("%.2f", 100 / gbpC.rates[0].ask) + " GBP");

        Currency usdA = getCurrency("a", "usd");
        Currency usdC = getCurrency("c", "usd");
        System.out.println(usdA.code + " " + usdA.rates[0].mid + "; 100 PLN -> " + String.format("%.2f", 100 / usdC.rates[0].ask) + " USD");
    }

    public static Currency getCurrency(String table, String currency) throws IOException {
        String urlStr = "http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + currency + "/?format=json";
        URL url = new URL(urlStr);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        Scanner scanner = new Scanner(connection.getInputStream());
        String jsonText = scanner.nextLine();

        Gson gson = new Gson();
        return gson.fromJson(jsonText, Currency.class);
    }
}
