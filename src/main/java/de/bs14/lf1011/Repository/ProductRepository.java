package de.bs14.lf1011.Repository;

import de.bs14.lf1011.Model.Product;
import jakarta.persistence.Id;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findAll();
  List<Product> findProductByProductId(int id);
  List<Product> findByDescription(String description);

}
