package de.bs14.lf1011.Controller;

import de.bs14.lf1011.Model.Product;
import de.bs14.lf1011.Repository.FridgeRepository;
import de.bs14.lf1011.Repository.ProductRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataBaseUpdater {
  private final ProductRepository productRepository;
  private final FridgeRepository fridgeRepository;
  private final InputReaderService inputReaderService;
  private final String nextLine = System.lineSeparator();


  public void updateQuantity(){

  }

  public void addNewProduct(){
    System.out.println("Gib die Produktbezeichnung ein");
    String producDiscription = inputReaderService.readInput();

    System.out.println("Wann hast du das Produkt in den Kühlschrank gepackt (YYYY-MM-DD)");
    LocalDate stockDate = LocalDate.parse(inputReaderService.readInput());

    System.out.println("Wenn auf dem Produkt ein mhd steht, trage es jetzt ein (YYYY-MM-DD)");
    LocalDate mhd = LocalDate.parse(inputReaderService.readInput());

    System.out.println("ggf. hier den Preis eingeben (in cent)");
    Long price = Long.valueOf(inputReaderService.readInput());

    System.out.println("Gib hier die Menge an, die du eingelagert hast");
    int quantity = Integer.parseInt(inputReaderService.readInput());


    Product product = new Product(producDiscription,stockDate,mhd,price,quantity);
    productRepository.save(product);

    System.out.println("Dein Produkt wurde erfolgreich hinzugefügt.");
  }

}
