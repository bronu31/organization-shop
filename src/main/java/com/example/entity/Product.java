package com.example.entity;


import com.example.service.OrganizationService;
import com.example.service.impl.OrganizationServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @ManyToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinTable(
            name = "active_sales",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "sale_id"))
    private List<Sale> saleId;

    //private List<Reviews> reviews;
    private String keywords;

    //TODO Сделать таблицу характеристик private
    //на будущее так как понятия не имею как это реализовать
    private Float rating;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prodName='" + prodName + '\'' +
                ", prodDescription='" + prodDescription + '\'' +
                ", orgId=" + orgId +
                ", price=" + price +
                ", inStock=" + inStock +
                ", saleId=" + saleId +
                ", keywords='" + keywords + '\'' +
                ", rating=" + rating +
                '}';
    }
}
