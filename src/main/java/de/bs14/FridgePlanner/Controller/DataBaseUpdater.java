package de.bs14.FridgePlanner.Controller;

import de.bs14.FridgePlanner.Model.Product;
import de.bs14.FridgePlanner.Repository.ProductRepository;
import java.time.LocalDate;
import java.util.List;

import de.bs14.FridgePlanner.Services.InputReaderService;
import de.bs14.FridgePlanner.Services.PrintService;
import de.bs14.FridgePlanner.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataBaseUpdater {

  private final ProductRepository productRepository;
  private final InputReaderService inputReaderService;
  private final PrintService printService;
  private final ProductService productService;


  public void updateQuantity() {
    System.out.println("Von welchem Produkt möchtest du die Menge anpassen? Scanne den Barcode.");
    String barcode = inputReaderService.readInput();

    List<Product> myProductList = productRepository.findByBarcode(barcode);

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
    Product scannedProduct = productService.scanProduct();

    String productDescription = scannedProduct.getDescription();

    LocalDate stockDate = LocalDate.now();

    LocalDate mhd = scannedProduct.getMhd();

    System.out.println("Gib hier die Menge an, die du eingelagert hast");
    int quantity = Integer.parseInt(inputReaderService.readInput());

    String barcode = scannedProduct.getBarcode();

    Product product = new Product(productDescription, stockDate, mhd, quantity, barcode);
    productRepository.save(product);

    System.out.println("Dein Produkt wurde erfolgreich hinzugefügt.");
  }

}
