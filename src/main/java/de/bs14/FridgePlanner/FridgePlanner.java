package de.bs14.FridgePlanner;

import de.bs14.FridgePlanner.Services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import de.bs14.FridgePlanner.Controller.DataBaseUpdater;
import de.bs14.FridgePlanner.Controller.ExpirationChecker;
import de.bs14.FridgePlanner.Controller.MainMenu;
import de.bs14.FridgePlanner.Controller.ProductReaderService;
import lombok.RequiredArgsConstructor;




@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class FridgePlanner implements CommandLineRunner {
  private final ProductReaderService productReaderService;
  private final DataBaseUpdater dataBaseUpdater;
  private final ExpirationChecker expirationChecker;
  private final MainMenu mainMenu;
  private final ProductService productService;

  public static void main(String[] args) {
    new SpringApplicationBuilder().sources(FridgePlanner.class).run(args);}

  @Override
  public void run(String... args) {
    expirationChecker.checkProducts();
    mainMenu.showMainMenu();
    productService.scanProduct();

  }
}
