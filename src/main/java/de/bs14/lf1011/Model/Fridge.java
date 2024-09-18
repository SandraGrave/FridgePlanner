package de.bs14.lf1011.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Fridge")
@Getter
@NoArgsConstructor
public class Fridge {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int fridgeId;

  @Column
  private String location;

}
