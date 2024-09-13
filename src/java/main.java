import static Controller.Connector.connectDb;

import Controller.InformationService;
import java.sql.Connection;

public class main {

  public static void main(String[] args) {
    Connection connection = connectDb();
    InformationService informationService = new InformationService();

    if (connection != null) {
      informationService.showMyProducts(connection);
    } else {
      System.out.println("Verbindung zur Datenbank fehlgeschlagen.");
    }
  }

}
