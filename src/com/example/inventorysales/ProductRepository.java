package com.example.inventorysales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private final DatabaseManager databaseManager = new DatabaseManager();

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id, name, sku, quantity, reorder_level, unit_price, supplier_name, category FROM products ORDER BY name";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("sku"),
                        rs.getInt("quantity"),
                        rs.getInt("reorder_level"),
                        rs.getDouble("unit_price"),
                        rs.getString("supplier_name"),
                        rs.getString("category")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> findLowStock() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id, name, sku, quantity, reorder_level, unit_price, supplier_name, category " +
                     "FROM products WHERE quantity <= reorder_level ORDER BY quantity ASC";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("sku"),
                        rs.getInt("quantity"),
                        rs.getInt("reorder_level"),
                        rs.getDouble("unit_price"),
                        rs.getString("supplier_name"),
                        rs.getString("category")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
