package com.example.ecommerce.dto;

public class ProductRequestDTO {

    private String nome;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String nome, String description, Double price, String imgUrl) {
        this.nome = nome;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
