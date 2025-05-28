package de.bs14.FridgePlanner.Services;

import de.bs14.FridgePlanner.Model.Product;
import de.bs14.FridgePlanner.Repository.ProductRepository;
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

