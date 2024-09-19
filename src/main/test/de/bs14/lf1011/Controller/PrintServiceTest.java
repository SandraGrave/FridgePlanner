package de.bs14.lf1011.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.bs14.lf1011.Model.Product;
import de.bs14.lf1011.Repository.ProductRepository;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PrintServiceTest {
  Product product = new Product("Milch", LocalDate.of(2024,9,19) , LocalDate.of(2024,9,22), 90L, 2);
  Product product2 = new Product("Salami", LocalDate.of(2024,9,19) , LocalDate.of(2024,9,22), 90L, 2);
  PrintService printService = spy(new PrintService());

  @Test
  void printProducts() {
    //when
    printService.printProducts(List.of(product, product2));

    //then
    verify(printService, times(2)).printProduct(any());
  }
}