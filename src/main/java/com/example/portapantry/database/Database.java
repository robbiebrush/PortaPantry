package com.example.portapantry.database;

import java.sql.*;

public class Database {
    private static Database instance;
    private Connection connection = null;

    private Database(){
        //Database connection
        if(connection == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection =
                        DriverManager.getConnection("jdbc:mysql://localhost/"
                                        + DBConsts.DB_NAME + "?serverTimezone=UTC",
                                DBConsts.DB_USER,
                                DBConsts.DB_PASS);
                System.out.println("Created Connection");
                //Create the foods table
                createTable(DBTableValues.TABLE_FOODS,
                        DBTableValues.CREATE_TABLE_FOODS, connection);

                //Create the food_allergies table
                createTable(DBTableValues.TABLE_FOOD_ALLERGIES,
                        DBTableValues.CREATE_TABLE_FOOD_ALLERGIES, connection);
                //Populate the food_allergies table
                populateTable(DBTableValues.TABLE_FOOD_ALLERGIES,
                        DBTableValues.POPULATE_TABLE_FOOD_ALLERGIES, connection);

                //Create the food_groups table
                createTable(DBTableValues.TABLE_FOOD_GROUPS,
                        DBTableValues.CREATE_TABLE_FOOD_GROUPS, connection);
                //Populate the food_groups table
                populateTable(DBTableValues.TABLE_FOOD_GROUPS,
                        DBTableValues.POPULATE_TABLE_FOOD_GROUPS, connection);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        System.out.println("Closing connection");
        try{
            connection.close();
        }
        catch (Exception e){
            connection = null;
            e.printStackTrace();
        }
    }

    private void createTable(String tableName, String tableQuery,
                             Connection connection) throws SQLException {
        Statement createTable;
        //Get database information
        DatabaseMetaData md = connection.getMetaData();
        //Looking for the table with tableName
        ResultSet resultSet = md.getTables("rbrushjava",
                null, tableName, null);
        //If the table is present
        if(resultSet.next()){
            System.out.println(tableName + " table already exists!");
        }
        else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been inserted");
        }
    }

    private void populateTable(String tableName, String query,
                               Connection connection) throws SQLException {
        DatabaseMetaData md = connection.getMetaData();
        ResultSet resultSet = md.getColumns("rbrushjava", null, tableName, null);
        if(resultSet.next()) {
            System.out.println(tableName + " is already populated.");
        } else {
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("The " + tableName + " has been populated.");
        }
    }
}
