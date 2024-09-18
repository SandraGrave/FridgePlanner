package de.bs14.lf1011;

import de.bs14.lf1011.Controller.DataBaseUpdater;
import de.bs14.lf1011.Controller.ProductReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties
@RequiredArgsConstructor
public class Lf1011Application implements CommandLineRunner {
  private final ProductReaderService productReaderService;
  private final DataBaseUpdater dataBaseUpdater;
  public static void main(String[] args) {
    new SpringApplicationBuilder().sources(Lf1011Application.class).run(args);}

  @Override
  public void run(String... args) {
    dataBaseUpdater.addNewProduct();
    productReaderService.showMyProducts();

  }
}
