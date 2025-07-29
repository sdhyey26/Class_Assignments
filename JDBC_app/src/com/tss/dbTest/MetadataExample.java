package com.tss.dbTest;

import java.sql.*;

public class MetadataExample {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/TSS_Students";
        String dbUser = "root";
        String dbPassword = "Dhyey1212";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {

            DatabaseMetaData dbMeta = conn.getMetaData();
            System.out.println("=== Database Metadata ===");
            System.out.println("Database Driver Name: " + dbMeta.getDriverName());
            System.out.println("Database Driver Version: " + dbMeta.getDriverVersion());

            ResultSet tables = dbMeta.getTables("tss_students", null, "%", new String[]{"TABLE"});
            System.out.println("\nTables and Their Column Details:\n");

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName );
                ResultSetMetaData rsMeta = rs.getMetaData();
                int columnCount = rsMeta.getColumnCount();

                System.out.println(" - Number of Columns: " + columnCount);
                System.out.println(" - Columns:");
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("     * " + rsMeta.getColumnName(i) + " : " + rsMeta.getColumnTypeName(i));
                }

                rs.close();
                stmt.close();
                System.out.println();
            }

            tables.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
