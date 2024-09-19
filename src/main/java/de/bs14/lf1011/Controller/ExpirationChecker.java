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
  private final PrintService printService;

  public void checkProducts() {
    LocalDate alertDate = LocalDate.now().plusDays(2);
    List<Product> myProductsList = productRepository.findByMhdLessThanEqual(alertDate);

    if (myProductsList.size() > 0) {
      System.out.println("-----------------------------------------------------------------------------------------------");
      System.out.println("Diese Lebensmittel laufen bald ab!");
      printService.printProducts(myProductsList);
    }

  }
}

