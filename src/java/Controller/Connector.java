package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector {
  public static Connection connectDb() {
    String host = "localhost";
    String user = "root";
    String password = "";
    String dbName = "lf10_11";
    String url = "jdbc:mysql://" + host + "/" + dbName;

    Connection connection = null;

    try {
      connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

}
