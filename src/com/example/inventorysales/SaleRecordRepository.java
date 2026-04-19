package com.example.inventorysales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SaleRecordRepository {
    private final DatabaseManager databaseManager = new DatabaseManager();

    public List<SaleRecord> findAll() {
        List<SaleRecord> sales = new ArrayList<>();
        String sql = "SELECT id, item_name, category, quantity_sold, unit_price, sale_date FROM sale_records ORDER BY sale_date DESC, id DESC";

        try (Connection connection = databaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                sales.add(new SaleRecord(
                        rs.getInt("id"),
                        rs.getString("item_name"),
                        rs.getString("category"),
                        rs.getInt("quantity_sold"),
                        rs.getDouble("unit_price"),
                        rs.getDate("sale_date").toLocalDate()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sales;
    }
}
