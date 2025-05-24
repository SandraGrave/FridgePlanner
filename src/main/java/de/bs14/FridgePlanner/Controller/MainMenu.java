package de.bs14.FridgePlanner.Controller;

import java.util.Scanner;

import de.bs14.FridgePlanner.Services.ProductReaderService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MainMenu {

    private final ProductReaderService productReaderService;
    private final DataBaseUpdater dataBaseUpdater;

    public void showMainMenu() {
        String nextLine = System.lineSeparator();
        String productFormat = "| %-10s | %-20s | %-20s | %-20s | %-10s|%n";

        Scanner in = new Scanner(System.in);
        boolean x = true;
        while(x) {
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf(productFormat, "Menü", "Übersicht", "Hinzufügen", "Bearbeiten", "Beenden");
            System.out.printf(productFormat, " ", "'m1'", "'m2'", "'m3'", "'exit'");
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Wähle einen Menüpunkt und bestätige mit Enter: ");

            String s = in.nextLine();

            switch (s) {
                case "m1":
                    System.out.println("Übersicht deiner gespeicherten Lebensmittel:");
                    productReaderService.showMyProducts();
                    break;

                case "m2":
                    System.out.println("Füge ein neues Lebensmittel hinzu:");
                    dataBaseUpdater.addNewProduct();
                    break;

                case "m3":
                    System.out.println("Bearbeite die Menge eines Lebensmittels:");
                    dataBaseUpdater.updateQuantity();
                    break;

                case "exit":
                    System.out.println("Programm wird beendet.");
                    x = false;
                    break;

                default:
                    System.out.println("Ungültige Eingabe " + s);
                    break;
                }



     }
  }

}
