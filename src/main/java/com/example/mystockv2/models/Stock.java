package com.example.mystockv2.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * Склад (Наименование). На складе может храниться несколько товаров.
 */
@Data
@NoArgsConstructor
@Table(name = "stocks")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "quantity")
    int quantity;
}
