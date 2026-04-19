Inventory + Cafeteria Sales Analysis (Java)

This is a beginner-friendly Java starter project based on the project cards you shared:

1. Inventory
   - A web-based platform to track stock levels, manage suppliers, and generate real-time reports to minimise waste and overstock.
   - Tech stack: Java, MySQL, Bootstrap

2. Cafeteria Sales Analysis
   - Analysed sales trends and inventory data to uncover patterns.
   - Delivered stock optimisation insights and actionable operational recommendations.
   - Focus areas: SQL, Excel, Data Analysis

What is included:
- Spring Boot web app
- MySQL configuration
- Bootstrap UI
- Inventory dashboard
- Supplier list
- Low-stock alerts
- Cafeteria sales analysis page
- Simple KPI reporting
- Seed data using schema.sql and data.sql

How to run:
1. Create a MySQL database called: inventory_sales_db
2. Update src/main/resources/application.properties with your MySQL username and password
3. Open the project in IntelliJ IDEA / VS Code / Spring Tool Suite
4. Run the main class: InventorySalesApplication.java
5. Open: http://localhost:8080

Project structure:
- src/main/java/.../controller   Controllers
- src/main/java/.../model        Entities
- src/main/java/.../repository   JPA repositories
- src/main/java/.../service      Business logic
- src/main/resources/templates   Thymeleaf pages
- src/main/resources/schema.sql  Database tables
- src/main/resources/data.sql    Demo data

Suggested next upgrades:
- Add authentication
- Add CRUD forms for products and suppliers
- Export reports to Excel/PDF
- Add charts with Chart.js
- Add role-based access
