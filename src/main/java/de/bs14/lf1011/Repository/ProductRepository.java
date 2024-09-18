package de.bs14.lf1011.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.bs14.lf1011.Model.Product;


public interface ProductRepository extends CrudRepository<Product, Integer> {
  List<Product> findAll();

  List<Product> findByMhdLessThanEqual(LocalDate mhd);
}
