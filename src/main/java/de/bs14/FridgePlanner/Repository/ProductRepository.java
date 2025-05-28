package de.bs14.FridgePlanner.Repository;

import de.bs14.FridgePlanner.Model.Product;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findAll();
  List<Product> findProductByProductId(int id);
  List<Product> findByDescription(String description);
  List<Product> findByMhdLessThanEqual(LocalDate mhd);
  List<Product> findByBarcode(String barcode);
}
