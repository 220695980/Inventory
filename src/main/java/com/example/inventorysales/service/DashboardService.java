package com.example.inventorysales.service;

import com.example.inventorysales.model.Product;
import com.example.inventorysales.model.SaleRecord;
import com.example.inventorysales.repository.ProductRepository;
import com.example.inventorysales.repository.SaleRecordRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final ProductRepository productRepository;
    private final SaleRecordRepository saleRecordRepository;

    public DashboardService(ProductRepository productRepository, SaleRecordRepository saleRecordRepository) {
        this.productRepository = productRepository;
        this.saleRecordRepository = saleRecordRepository;
    }

    public Map<String, Object> getSummary() {
        List<Product> products = productRepository.findAll();
        List<SaleRecord> sales = saleRecordRepository.findAll();

        int totalProducts = products.size();
        long lowStockCount = products.stream().filter(Product::isLowStock).count();
        long supplierCount = products.stream().map(Product::getSupplierName).filter(Objects::nonNull).distinct().count();
        double totalRevenue = sales.stream().mapToDouble(SaleRecord::getTotalRevenue).sum();
        long totalUnitsSold = sales.stream().mapToLong(s -> s.getQuantitySold() == null ? 0 : s.getQuantitySold()).sum();

        Map<String, Double> revenueByCategory = sales.stream()
                .collect(Collectors.groupingBy(
                        s -> s.getCategory() == null ? "Other" : s.getCategory(),
                        LinkedHashMap::new,
                        Collectors.summingDouble(SaleRecord::getTotalRevenue)
                ));

        List<Product> lowStockItems = products.stream()
                .filter(Product::isLowStock)
                .sorted(Comparator.comparing(Product::getQuantity))
                .toList();

        Map<String, Object> summary = new HashMap<>();
        summary.put("totalProducts", totalProducts);
        summary.put("lowStockCount", lowStockCount);
        summary.put("supplierCount", supplierCount);
        summary.put("totalRevenue", totalRevenue);
        summary.put("totalUnitsSold", totalUnitsSold);
        summary.put("revenueByCategory", revenueByCategory);
        summary.put("lowStockItems", lowStockItems);
        summary.put("products", products);
        summary.put("sales", sales);
        return summary;
    }
}
