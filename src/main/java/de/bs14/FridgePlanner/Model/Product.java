package de.bs14.FridgePlanner.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Product")
@Getter
@NoArgsConstructor
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int productId;

  @Column
  private String description;

  @Column
  private LocalDate stockDate;

  @Column
  private LocalDate mhd;

  @Column
  private int quantity;

  @Column
  private String barcode;


  public Product(String description, LocalDate stockDate, LocalDate mhd, int quantity){
    this.description = description;
    this.stockDate = stockDate;
    this.mhd = mhd;
    this. quantity = quantity;
  }

  public Product(String description, LocalDate stockDate, LocalDate mhd, int quantity, String barcode){
    this.description = description;
    this.stockDate = stockDate;
    this.mhd = mhd;
    this.quantity = quantity;
    this.barcode = barcode;
  }
}
