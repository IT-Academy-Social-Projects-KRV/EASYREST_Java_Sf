package com.easyrestaurant.core;

import com.easyrestaurant.utils.Defaults;

import java.sql.*;

public class PSQL extends Defaults {
    private Connection con;
    private ResultSet res;
    private Statement stm;


    protected void connectToDb() {
        try {
            con = DriverManager.getConnection(SQL_URL, SQL_USERNAME, SQL_PASSWORD);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Use executeQuery method for SELECT statements
    public void executeQueryAndGetResults(String query) {
        try {
            stm = con.createStatement();
            res = stm.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                System.out.println(id + ": " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Use executeUpdate method for DML (INSERT, UPDATE or DELETE)
    public void executeUpdate(String query) {
        try {
            stm = con.createStatement();
            stm.executeUpdate(query);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }


    protected void tearDown() {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
