package com.example.inventorysales;

import java.time.LocalDate;

public class SaleRecord {
    private int id;
    private String itemName;
    private String category;
    private int quantitySold;
    private double unitPrice;
    private LocalDate saleDate;

    public SaleRecord(int id, String itemName, String category, int quantitySold, double unitPrice, LocalDate saleDate) {
        this.id = id;
        this.itemName = itemName;
        this.category = category;
        this.quantitySold = quantitySold;
        this.unitPrice = unitPrice;
        this.saleDate = saleDate;
    }

    public double getRevenue() {
        return quantitySold * unitPrice;
    }

    public int getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }
}
