package de.bs14.lf1011.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.bs14.lf1011.Model.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findAll();

  @Query(value = "SELECT * FROM product WHERE mhd <= :alertDate")
  List<Product> findByMhd(@Param("alertDate") LocalDate mhd);
}
