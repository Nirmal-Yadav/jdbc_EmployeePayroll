package com.employeepayroll;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class DBDemo {

    public static void main(String[] args) throws SQLException {
        System.out.println("welcome to employee payroll jdbc");

        String jdbcURL="jdbc:mysql://localhost:3306/test_payroll";
        String userName = "root";
        String password="root";
        Connection connection;
        try{
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        connection= DriverManager.getConnection(jdbcURL,userName,password);
        System.out.println("Driver loaded");
            System.out.println("connecting to database: " +jdbcURL);
            System.out.println("connection successful!!!!! " +connection);
            listDrivers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()) {
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println("  " + driverClass.getClass().getName());
        }
    }
}
