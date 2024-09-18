package de.bs14.lf1011.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import de.bs14.lf1011.Model.Product;
import de.bs14.lf1011.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExpirationChecker {

  private final ProductRepository productRepository;

  public void checkProducts() {
    String nextLine = System.lineSeparator();
    String productFormat = "%-9s | %-30s | %-20s | %-15s | %-10s | %-20s%n";

    System.out.printf(productFormat, "ProductId", "description", "stockDate", "mhd", "price (ct)", "quantity" + nextLine);

    LocalDate alertDate = LocalDate.now().plusDays(2);
    List<Product> myProductsList = productRepository.findByMhd(alertDate);

    for (Product product : myProductsList) {
      System.out.printf(productFormat, product.getProductId(), product.getDescription(), product.getStockDate(), product.getMhd(),
          product.getPrice(), product.getQuantity() + nextLine);
    }

  }
}

