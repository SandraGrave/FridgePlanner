package de.bs14.lf1011.Controller;

import de.bs14.lf1011.Model.Product;
import de.bs14.lf1011.Repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductReaderService {

  private final ProductRepository productRepository;

  public void showMyProducts() {
    String nextLine = System.lineSeparator();
    String productFormat = "%-9s | %-30s | %-20s | %-15s | %-10s | %-20s%n";

    System.out.printf(productFormat, "ProductId", "description", "stockDate", "mhd", "price (ct)", "quantity" + nextLine);

    List<Product> myProductsList = productRepository.findAll();

    for (Product product : myProductsList) {
      System.out.printf(productFormat, product.getProductId(), product.getDescription(), product.getStockDate(), product.getMhd(),
          product.getPrice(), product.getQuantity() + nextLine);
    }

  }
}

