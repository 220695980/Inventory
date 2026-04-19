package com.example.inventorysales;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {
    private final DashboardService dashboardService = new DashboardService();

    public MainFrame() {
        setTitle("Inventory + Cafeteria Sales Analysis");
        setSize(1200, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(new Color(8, 16, 30));

        JLabel header = new JLabel("Inventory and Cafeteria Sales Analysis");
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Arial", Font.BOLD, 26));
        header.setBorder(BorderFactory.createEmptyBorder(18, 18, 10, 18));
        root.add(header, BorderLayout.NORTH);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Dashboard", createDashboardPanel());
        tabs.add("Inventory", createInventoryPanel());
        tabs.add("Sales Analysis", createSalesPanel());
        tabs.add("Recommendations", createRecommendationsPanel());

        root.add(tabs, BorderLayout.CENTER);
        setContentPane(root);
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout(18, 18));
        panel.setBackground(new Color(8, 16, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JPanel metrics = new JPanel(new GridLayout(1, 4, 12, 12));
        metrics.setBackground(new Color(8, 16, 30));
        metrics.add(UIUtils.createCard("Products", String.valueOf(dashboardService.getTotalProducts())));
        metrics.add(UIUtils.createCard("Low Stock", String.valueOf(dashboardService.getLowStockCount())));
        metrics.add(UIUtils.createCard("Suppliers", String.valueOf(dashboardService.getSupplierCount())));
        metrics.add(UIUtils.createCard("Revenue", "R " + String.format("%.2f", dashboardService.getTotalRevenue())));

        panel.add(metrics, BorderLayout.NORTH);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                createLowStockSection(),
                createRevenueSection());
        splitPane.setDividerLocation(700);
        panel.add(splitPane, BorderLayout.CENTER);

        return panel;
    }

    private JScrollPane createLowStockSection() {
        String[] columns = {"Product", "SKU", "Qty", "Reorder Level", "Supplier", "Category"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        List<Product> lowStock = dashboardService.getLowStockProducts();

        for (Product product : lowStock) {
            model.addRow(new Object[]{
                    product.getName(),
                    product.getSku(),
                    product.getQuantity(),
                    product.getReorderLevel(),
                    product.getSupplierName(),
                    product.getCategory()
            });
        }

        JTable table = new JTable(model);
        UIUtils.styleTable(table);
        return new JScrollPane(table);
    }

    private JPanel createRevenueSection() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(14, 24, 42));
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel title = new JLabel("Revenue by Category");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(title);
        panel.add(Box.createVerticalStrut(12));

        Map<String, Double> revenue = dashboardService.getRevenueByCategory();
        double totalRevenue = Math.max(dashboardService.getTotalRevenue(), 1.0);

        for (Map.Entry<String, Double> entry : revenue.entrySet()) {
            JLabel label = new JLabel(entry.getKey() + " - R " + String.format("%.2f", entry.getValue()));
            label.setForeground(new Color(210, 220, 235));
            panel.add(label);

            JProgressBar bar = new JProgressBar(0, 100);
            int percent = (int) Math.round((entry.getValue() / totalRevenue) * 100);
            bar.setValue(percent);
            bar.setStringPainted(true);
            panel.add(bar);
            panel.add(Box.createVerticalStrut(10));
        }

        return panel;
    }

    private JPanel createInventoryPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(8, 16, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        String[] columns = {"Product", "SKU", "Category", "Qty", "Reorder", "Supplier", "Unit Price", "Low Stock"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (Product product : dashboardService.getProducts()) {
            model.addRow(new Object[]{
                    product.getName(),
                    product.getSku(),
                    product.getCategory(),
                    product.getQuantity(),
                    product.getReorderLevel(),
                    product.getSupplierName(),
                    "R " + String.format("%.2f", product.getUnitPrice()),
                    product.isLowStock() ? "Yes" : "No"
            });
        }

        JTable table = new JTable(model);
        UIUtils.styleTable(table);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createSalesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(8, 16, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JPanel top = new JPanel(new GridLayout(1, 2, 12, 12));
        top.setBackground(new Color(8, 16, 30));
        top.add(UIUtils.createCard("Units Sold", String.valueOf(dashboardService.getTotalUnitsSold())));
        top.add(UIUtils.createCard("Sales Revenue", "R " + String.format("%.2f", dashboardService.getTotalRevenue())));
        panel.add(top, BorderLayout.NORTH);

        String[] columns = {"Item", "Category", "Qty Sold", "Unit Price", "Revenue", "Sale Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        for (SaleRecord sale : dashboardService.getSales()) {
            model.addRow(new Object[]{
                    sale.getItemName(),
                    sale.getCategory(),
                    sale.getQuantitySold(),
                    "R " + String.format("%.2f", sale.getUnitPrice()),
                    "R " + String.format("%.2f", sale.getRevenue()),
                    sale.getSaleDate()
            });
        }

        JTable table = new JTable(model);
        UIUtils.styleTable(table);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createRecommendationsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(8, 16, 30));
        panel.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setBackground(new Color(14, 24, 42));
        textArea.setForeground(Color.WHITE);
        textArea.setText(
                "Operational Recommendations\n\n" +
                "1. Reorder fast-moving meal items that are already below or near reorder level.\n" +
                "2. Track supplier performance for frequently restocked items.\n" +
                "3. Compare daily sales with inventory movements to reduce shortages and overstock.\n" +
                "4. Focus on high-revenue categories when planning promotions and stock allocation.\n" +
                "5. Extend the project with charts, login, and CRUD forms for a fuller portfolio system."
        );

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return panel;
    }
}
