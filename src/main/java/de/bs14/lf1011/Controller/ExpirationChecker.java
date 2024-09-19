package de.bs14.lf1011.Controller;

import de.bs14.lf1011.Model.Product;
import de.bs14.lf1011.Repository.ProductRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExpirationChecker {

  private final ProductRepository productRepository;
  private final PrintService printService;

  public void checkProducts() {
    LocalDate alertDate = LocalDate.now().plusDays(2);
    List<Product> myProductsList = productRepository.findByMhdLessThanEqual(alertDate);

    System.out.println("Folgende Produkte solltes du verbrauchen:");
    printService.printProducts(myProductsList);
  }
}

