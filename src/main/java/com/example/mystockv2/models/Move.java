package com.example.mystockv2.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

/**
 * Перемещение (Номер, Склад1, Склад2, Список товаров). Заводится при перемещении товара между складами.
 * Содержит список товаров и их количество. В документе указывается склад,
 * с которого списывают товары и склад, на который они поступают.
 */
@Data
@NoArgsConstructor
@Table(name = "moving")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "quantity")
    int quantity;
    @ManyToOne
    Stock stockFrom;
    @ManyToOne
    Stock stockTo;
    @OneToOne
    Product product;

}
