package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sale {

    @Id

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sale_seq")
    @SequenceGenerator(name = "sale_seq",sequenceName = "sale_seq",allocationSize = 1,initialValue = 1)
    private Long id;

    @ManyToMany
    
    private List<Product> productsOnSale;

    private Byte saleSize;

    private Date saleEnd;
}
