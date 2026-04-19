package com.example.inventorysales.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sale_records")
public class SaleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String category;
    private Integer quantitySold;
    private Double unitPrice;
    private LocalDate saleDate;

    public SaleRecord() {
    }

    public SaleRecord(Long id, String itemName, String category, Integer quantitySold, Double unitPrice, LocalDate saleDate) {
        this.id = id;
        this.itemName = itemName;
        this.category = category;
        this.quantitySold = quantitySold;
        this.unitPrice = unitPrice;
        this.saleDate = saleDate;
    }

    public Double getTotalRevenue() {
        return (quantitySold == null || unitPrice == null) ? 0.0 : quantitySold * unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(Integer quantitySold) {
        this.quantitySold = quantitySold;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
