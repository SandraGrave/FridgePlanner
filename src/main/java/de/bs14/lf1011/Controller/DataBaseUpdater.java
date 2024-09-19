package de.bs14.lf1011.Controller;

import de.bs14.lf1011.Model.Product;
import de.bs14.lf1011.Repository.ProductRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataBaseUpdater {

  private final ProductRepository productRepository;
  private final InputReaderService inputReaderService;
  private final PrintService printService;


  public void updateQuantity() {
    System.out.println("Von welchem Produkt möchtest du die Menge anpassen? Gib die Produktbezeichnung ein.");
    String description = inputReaderService.readInput();

    List<Product> myProductList = productRepository.findByDescription(description);

    if (myProductList.size() > 1) {
      System.out.println("Du hast mehrere Produkte mit dieser Bezeichnung in deinem Kühlschrank.");
    }

    printService.printProducts(myProductList);

    System.out.println("Bitte gib die ID ein, von welchem Produkt du die Menge ändern möchtest.");
    int productId = Integer.parseInt(inputReaderService.readInput());
    List<Product> myProductListById = productRepository.findProductByProductId(productId);
    Product myProduct = myProductListById.get(0);

    System.out.println("Wie viel hast du verbraucht?");
    int actualQuantity = myProduct.getQuantity();
    int takeQuantity = Integer.parseInt(inputReaderService.readInput());
    int newQuantity = actualQuantity - takeQuantity;
    myProduct.setQuantity(newQuantity);
    productRepository.save(myProduct);
  }


  public void addNewProduct() {
    System.out.println("Gib die Produktbezeichnung ein");
    String productDescription = inputReaderService.readInput();

    System.out.println("Wann hast du das Produkt in den Kühlschrank gepackt (YYYY-MM-DD)");
    LocalDate stockDate = LocalDate.parse(inputReaderService.readInput());

    System.out.println("Zu wann willst du das Produkt aufbrauchen, ggf. mhd? (YYYY-MM-DD)");
    LocalDate mhd = LocalDate.parse(inputReaderService.readInput());

    System.out.println("ggf. hier den Preis eingeben (in cent)");
    Long price = Long.valueOf(inputReaderService.readInput());

    System.out.println("Gib hier die Menge an, die du eingelagert hast");
    int quantity = Integer.parseInt(inputReaderService.readInput());

    Product product = new Product(productDescription, stockDate, mhd, price, quantity);
    productRepository.save(product);

    System.out.println("Dein Produkt wurde erfolgreich hinzugefügt.");
  }

}
