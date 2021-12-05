package com.example.portapantry.database;

import java.sql.*;

import static com.example.portapantry.database.DBTableValues.TABLE_FOOD_ALLERGIES;
import static com.example.portapantry.database.DBTableValues.TABLE_FOOD_GROUPS;

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

                //Create the food_allergies table
                createTable(TABLE_FOOD_ALLERGIES,
                        DBTableValues.CREATE_TABLE_FOOD_ALLERGIES, connection);

                //Create the food_groups table
                createTable(TABLE_FOOD_GROUPS,
                        DBTableValues.CREATE_TABLE_FOOD_GROUPS, connection);

                //Create the foods table
                createTable(DBTableValues.TABLE_FOODS,
                        DBTableValues.CREATE_TABLE_FOODS, connection);

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
        ResultSet resultSet = md.getTables(DBConsts.DB_NAME,
                null, tableName, null);
        //If the table is present
        if(resultSet.next()){
            System.out.println(tableName + " table already exists!");
        }
        else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been inserted");

            if (tableName == "food_groups") {
                //Populate the food_groups table
                populateTable(TABLE_FOOD_GROUPS,
                        DBTableValues.INSERT_GROUPS_PROTEINS, connection);
                populateTable(TABLE_FOOD_GROUPS,
                        DBTableValues.INSERT_GROUPS_GRAINS, connection);
                populateTable(TABLE_FOOD_GROUPS,
                        DBTableValues.INSERT_GROUPS_VEGS, connection);
                populateTable(TABLE_FOOD_GROUPS,
                        DBTableValues.INSERT_GROUPS_FRUITS, connection);
                populateTable(TABLE_FOOD_GROUPS,
                        DBTableValues.INSERT_GROUPS_DAIRY, connection);
                populateTable(TABLE_FOOD_GROUPS,
                        DBTableValues.INSERT_GROUPS_OTHER, connection);
            } else if (tableName == "food_allergies") {
                //Populate the food_allergies table
                populateTable(TABLE_FOOD_ALLERGIES,
                        DBTableValues.INSERT_ALLERGIES_NONE, connection);
                populateTable(TABLE_FOOD_ALLERGIES,
                        DBTableValues.INSERT_ALLERGIES_NUTS, connection);
                populateTable(TABLE_FOOD_ALLERGIES,
                        DBTableValues.INSERT_ALLERGIES_SEA_FOOD, connection);
                populateTable(TABLE_FOOD_ALLERGIES,
                        DBTableValues.INSERT_ALLERGIES_UNKNOWN, connection);
            }
        }
    }

    private void populateTable(String tableName, String query,
                               Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(query);
        System.out.println("Record added to " + tableName + ".");
    }
}
