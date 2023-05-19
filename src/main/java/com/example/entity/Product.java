package com.example.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
//@Entity
@NoArgsConstructor
public class Product {

    public Product(Integer id, String prod_name,
                   String prod_description, Integer org_id,
                   Float price, Integer in_stock, String[] keywords) {
        this.id = id;
        this.prod_name = prod_name;
        this.prod_description = prod_description;
        this.org_id = org_id;
        this.price = price;
        this.in_stock = in_stock;
        this.keywords = keywords;
    }
@Id
@GeneratedValue
    private Integer id;

    private String prod_name;

    private String prod_description;

    private Integer org_id;

    private Float price;

    private Integer in_stock;

    private String[] keywords;

    private Sale sale_id;

    private List<Reviews> reviews;

    //TODO Сделать таблицу характеристик private

    private Float rating;
}
