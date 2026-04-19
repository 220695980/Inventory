package com.example.inventorysales;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UIUtils {

    public static JPanel createCard(String title, String value) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(18, 30, 52));
        panel.setBorder(new EmptyBorder(16, 16, 16, 16));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setForeground(new Color(170, 190, 215));
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel valueLabel = new JLabel(value);
        valueLabel.setForeground(Color.WHITE);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 28));

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(valueLabel);
        return panel;
    }

    public static void styleTable(JTable table) {
        table.setRowHeight(28);
        table.setBackground(new Color(14, 24, 42));
        table.setForeground(Color.WHITE);
        table.setGridColor(new Color(40, 57, 85));
        table.setSelectionBackground(new Color(44, 76, 130));
        table.getTableHeader().setBackground(new Color(22, 36, 62));
        table.getTableHeader().setForeground(Color.WHITE);
    }

    private UIUtils() {
    }
}
