package com.example.mystockv2.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

/**
 * Поступление (Номер, Склад, Список товаров). Заводится при поступлении товара.
 * Содержит список товаров, их количество и закупочные цены.
 * В документе указывается склад, на который поступают товары.
 */
@Data
@NoArgsConstructor
@Table(name = "admissions")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "quantity")
    int quantity;
    @Column(name = "purchase_price")
    Integer purchasePrice;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    Stock stock;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    List<Product> products;


}
