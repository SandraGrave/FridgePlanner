package de.bs14.lf1011.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import de.bs14.lf1011.Model.Product;
import de.bs14.lf1011.Repository.ProductRepository;
import jakarta.persistence.Column;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

class DataBaseUpdaterTest {
  private InputReaderService inputReaderServiceMock = Mockito.mock(InputReaderService.class);
  private ProductRepository productRepositoryMock = Mockito.mock(ProductRepository.class);
  private PrintService printServiceMock = Mockito.mock(PrintService.class);
  private DataBaseUpdater dataBaseUpdater = new DataBaseUpdater(productRepositoryMock, inputReaderServiceMock, printServiceMock);

  @Test
  void testUpdateQuantity() {
  //given
    String description = "Milch";
    int id = 1;
    String takenQuantity = "1";
    Product product = new Product("Milch", LocalDate.of(2024,9,19) , LocalDate.of(2024,9,22), 90L, 2);
    List<Product> productList = Collections.singletonList(product);
    //productRepositoryMock.

    when(productRepositoryMock.findByDescription(description)).thenReturn(productList);
    when(productRepositoryMock.findProductByProductId(id)).thenReturn(productList);

    Mockito.when(inputReaderServiceMock.readInput())
        .thenReturn(description)
        .thenReturn(String.valueOf(id))
        .thenReturn(takenQuantity);

  //when
    dataBaseUpdater.updateQuantity();

  //then
    assertEquals(1,product.getQuantity());

  }

  @Test
  void testAddNewProduct() {
    //given
    String description = "Salami";
    LocalDate stockDate = LocalDate.of(2024,9,18);
    LocalDate mhd = LocalDate.of(2024,9,23);
    Long price = 120L;
    int quantity = 2;

    Mockito.when(inputReaderServiceMock.readInput())
        .thenReturn(description)
        .thenReturn(String.valueOf(stockDate))
        .thenReturn(String.valueOf(mhd))
        .thenReturn(String.valueOf(price))
        .thenReturn(String.valueOf((quantity)));

    //when
    dataBaseUpdater.addNewProduct();

    //then
    verify(productRepositoryMock, times(1)).save(any());



  }
}