package com.example.entity;


import com.example.service.OrganizationService;
import com.example.service.impl.OrganizationServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
        this.rating=0F;

    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq",sequenceName = "product_seq",allocationSize = 1,initialValue = 1)
    private Long id;
    @NotBlank(message = "The Name can't be empty")
    private String prodName;
    @NotBlank(message = "The description can't be empty")
    private String prodDescription;
    @ManyToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    //@NotBlank (message = "Select organization")
    private Organization orgId;

    //@NotBlank
    private Float price;
    //@NotNull(message = "Show how many items are available ")
    //TODO Find a way to check Numbers
    private Integer inStock;

    @ManyToMany(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JoinTable(
            name = "active_sales",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "sale_id"))
    private List<Sale> saleId;

    //private List<Reviews> reviews;
    @NotEmpty(message = "Add keywords to your product")
    private String keywords;

    //TODO Сделать таблицу характеристик private
    //на будущее так как понятия не имею как это реализовать
    //судя по всему hash таблица
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
