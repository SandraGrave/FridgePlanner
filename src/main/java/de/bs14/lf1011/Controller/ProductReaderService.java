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
  private final PrintService printService;
  public void showMyProducts() {

    List<Product> myProductsList = productRepository.findAll();
    printService.printProducts(myProductsList);


  }
}

