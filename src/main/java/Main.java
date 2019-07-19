import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(getCurrency("a", "eur"));
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
