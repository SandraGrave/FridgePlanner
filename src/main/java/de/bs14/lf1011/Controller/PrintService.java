package de.bs14.lf1011.Controller;

import de.bs14.lf1011.Model.Product;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PrintService {

  private final String productFormat = "%-9s | %-30s | %-20s | %-15s | %-10s | %-20s%n";

  public void printProducts(List<Product>productList){
    printHeadLineProduct();
    for (Product product : productList){
      printProduct(product);
    }

  }
  private void printHeadLineProduct(){
    System.out.printf(productFormat, "ID", "Produkt", "Datum Einlagerung", "Aufbrauchen zum", "Preis (ct)", "Menge");
  }

  void printProduct(Product product){
      System.out.printf(productFormat, product.getProductId(), product.getDescription(), product.getStockDate(), product.getMhd(),
          product.getPrice(), product.getQuantity());
    }
  }
