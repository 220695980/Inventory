package com.example.inventorysales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DashboardService {
    private final ProductRepository productRepository = new ProductRepository();
    private final SaleRecordRepository saleRecordRepository = new SaleRecordRepository();

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getLowStockProducts() {
        return productRepository.findLowStock();
    }

    public List<SaleRecord> getSales() {
        return saleRecordRepository.findAll();
    }

    public int getTotalProducts() {
        return getProducts().size();
    }

    public int getLowStockCount() {
        return getLowStockProducts().size();
    }

    public long getSupplierCount() {
        return getProducts().stream()
                .map(Product::getSupplierName)
                .distinct()
                .count();
    }

    public int getTotalUnitsSold() {
        return getSales().stream()
                .mapToInt(SaleRecord::getQuantitySold)
                .sum();
    }

    public double getTotalRevenue() {
        return getSales().stream()
                .mapToDouble(SaleRecord::getRevenue)
                .sum();
    }

    public Map<String, Double> getRevenueByCategory() {
        return getSales().stream()
                .collect(Collectors.groupingBy(
                        SaleRecord::getCategory,
                        HashMap::new,
                        Collectors.summingDouble(SaleRecord::getRevenue)
                ));
    }
}
