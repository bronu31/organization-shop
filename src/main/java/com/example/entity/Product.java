package com.example.entity;


import com.example.service.OrganizationService;
import com.example.service.impl.OrganizationServiceImpl;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    public Product(Long id, String prodName,
                   String prodDescription, Organization orgId,
                   Float price, Integer inStock, String keywords) {
        this.id = id;
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.orgId = orgId;
        this.price = price;
        this.inStock = inStock;
        this.keywords = keywords;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    private Long id;

    private String prodName;

    private String prodDescription;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Organization orgId;


    private Float price;

    private Integer inStock;

    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Sale saleId;

    //private List<Reviews> reviews;
    private String keywords;

    //TODO Сделать таблицу характеристик private
    //на будущее так как понятия не имею как это реализовать
    private Float rating;


}
