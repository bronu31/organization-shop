package com.example.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotNull
    private List<Product> productsOnSale;
    @NotNull
    private Byte saleSize;
    @NotBlank
    private Date saleEnd;
}
