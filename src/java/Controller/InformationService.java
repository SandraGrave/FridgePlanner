package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


public class InformationService {
  public static void showMyProducts(Connection connection) {
    try {
      Statement statement = connection.createStatement();
      String sql = "SELECT * FROM product";
      ResultSet resultSet = statement.executeQuery(sql);

      System.out.printf("%-9s | %-30s | %-20s | %-15s | %-10s | %-20s%n", "ProductId", "description", "stockDate", "mhd", "price (ct)", "quantity");

      while (resultSet.next()) {
        int ProductId = resultSet.getInt("ProductId");
        String description = resultSet.getString("description");
        LocalDate stockDate = LocalDate.parse(resultSet.getString("stockDate"));
        LocalDate mhd = LocalDate.parse(resultSet.getString("mhd"));
        Long price = (long) resultSet.getInt("price");
        int quantity = resultSet.getInt("quantity");


        System.out.printf("%-9s | %-30s | %-20s | %-15s | %-10s | %-20s%n", ProductId, description, stockDate, mhd, price, quantity);
        System.out.println("------------------------------------------------------------------------------------------------------------|");
      }

      resultSet.close();
      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
