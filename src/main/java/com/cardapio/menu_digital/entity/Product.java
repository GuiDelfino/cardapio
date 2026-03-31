package com.cardapio.menu_digital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "O nome é obrigatório meu anjo!")
    private String name;
    @NotBlank(message = "É obrigatório atribuir uma descrição, meu chapa!")
    private String description;
    @NotNull(message = "O preço é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private Double price;
    @NotBlank(message = "Usa uma imagenzinha ai vai, papo de agregar valor ao produto!!")
    private String imageUrl;

    public Product() {

    }

    public Product(Long id, String name, String description, Double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
