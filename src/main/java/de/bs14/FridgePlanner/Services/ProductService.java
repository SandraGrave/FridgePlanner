package de.bs14.FridgePlanner.Services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import de.bs14.FridgePlanner.Model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final InputReaderService inputReaderService;

    public Product scanProduct() {
        Product productobj = new Product();
        System.out.print("Bitte Barcode scannen.");
        String barcode = inputReaderService.readInput();
        productobj.setBarcode(barcode);

        try {
            JsonObject product = fetchProduct(barcode);
            if (product != null) {
                String name = getAsString(product, "product_name");
                String mhd = getAsString(product, "expiration_date");

                System.out.println("Produktname: " + name);
                System.out.println("Mindesthaltbarkeitsdatum: " + mhd);

                productobj.setDescription(name);
                productobj.setMhd(LocalDate.parse(mhd));

            } else {
                System.out.println("Produkt wurde nicht gefunden.");
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Abrufen des Produkts: " + e.getMessage());
        }
        return productobj;
    }
    private JsonObject fetchProduct(String barcode) throws Exception {
        String urlStr = "https://world.openfoodfacts.org/api/v0/product/" + barcode + ".json";

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("HTTP Fehler: " + status);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.toString(), JsonObject.class);

            if (json.get("status").getAsInt() == 1) {
                return json.getAsJsonObject("product");
            } else {
                return null;
            }
        }
    }

    private String getAsString(JsonObject obj, String key) {
        JsonElement el = obj.get(key);
        if (el != null && !el.isJsonNull()) {
            return el.getAsString();
        }
        System.out.println(key + " wurde nicht gefunden, bitte manuell eingeben: (YYYY-MM-DD)");
        return inputReaderService.readInput();
    }
}