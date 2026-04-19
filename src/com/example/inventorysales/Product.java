package com.example.inventorysales;

public class Product {
    private int id;
    private String name;
    private String sku;
    private int quantity;
    private int reorderLevel;
    private double unitPrice;
    private String supplierName;
    private String category;

    public Product(int id, String name, String sku, int quantity, int reorderLevel,
                   double unitPrice, String supplierName, String category) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.unitPrice = unitPrice;
        this.supplierName = supplierName;
        this.category = category;
    }

    public boolean isLowStock() {
        return quantity <= reorderLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getCategory() {
        return category;
    }
}
