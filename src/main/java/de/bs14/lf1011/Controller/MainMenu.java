package de.bs14.lf1011.Controller;

import java.util.Scanner;

public class MainMenu {

    //private final GameModeMenu gameModeMenu;


    public void showMainMenu() {
        String nextLine = System.lineSeparator();
        String productFormat = "| %-9s | %-30s | %-20s | %-15s | %-10s | %-20s |%n";

        Scanner in = new Scanner(System.in);
        boolean x = true;
        while(x) {
            System.out.println("___________________________________________________________");
            System.out.printf(productFormat, "Menü", "Übersicht", "Hinzufügen", "Bearbeiten", "Abbrechen", "Beenden" + nextLine);
            System.out.printf(productFormat, " ", "m1", "m2", "m3", "m4", "exit" + nextLine);
            System.out.println("___________________________________________________________");
            System.out.println("Wähle einen Menüpunkt: ");
          
          System.out.println("Gib deine Wahl ein und bestätige mit Enter: ");

          String s = in.nextLine();

            switch (s) {
                case "m1":
                System.out.println("Übersicht deiner gespeicherten Lebensmittel");
                //gameModeMenu.chooseGameMode();
                break;

                case "m2":
                System.out.println("Füge ein neues Lebensmittel hinzu");
                //rankingService.showRankingList();
                break;

                case "m3":
                System.out.println("Bearbeite die Menge eines Lebensmittels");
                x = false;
                break;

                case "m4":
                    System.out.println("Abbruch und Rückkehr zum Startmenü.");
                    System.out.println("-------------------------");
                    //insertService.newInsertQuestion();
                    break;

                case "h":
                    System.out.println("Willkommen ins Help Menu");
                    System.out.println("----------------------------");
                    //helpService.showHelp();
                    break;

                default:
                    System.out.println("Ungültige Eingabe " + s);
                    break;
                }



     }
  }

}