package com.example.portapantry.tables;

import com.example.portapantry.database.DBTableValues;
import com.example.portapantry.database.Database;
import com.example.portapantry.doas.FoodGroupDOA;
import com.example.portapantry.pojos.FoodGroup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodGroupsTable implements FoodGroupDOA {
    Database db = Database.getInstance();
    ArrayList<FoodGroup> foodGroups;

    @Override
    public ArrayList<FoodGroup> getAllFoodGroups() {
        //SELECT * FROM FOOD_GROUP
        String query = "SELECT * FROM " + DBTableValues.TABLE_FOOD_GROUPS;
        foodGroups = new ArrayList<>();
        try {
            Statement getFoodGroups =
                    db.getConnection().createStatement();
            ResultSet data = getFoodGroups.executeQuery(query);

            while(data.next()){
                foodGroups.add(
                        new FoodGroup(data.getInt(DBTableValues.GROUPS_COLUMN_ID),
                                data.getString(DBTableValues.GROUPS_COLUMN_NAME))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodGroups;
    }

    @Override
    public FoodGroup getFoodGroup(int id) {
        String query = "SELECT * FROM " + DBTableValues.TABLE_FOOD_GROUPS +
                " WHERE " + DBTableValues.GROUPS_COLUMN_ID + " = " + id;
        try {
            Statement getFoodGroup = db.getConnection().createStatement();
            ResultSet data = getFoodGroup.executeQuery(query);
            if(data.next()){
                FoodGroup foodGroup =  new FoodGroup(data.getInt(DBTableValues.GROUPS_COLUMN_ID),
                        data.getString(DBTableValues.GROUPS_COLUMN_NAME));
                return foodGroup;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

