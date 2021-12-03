package com.example.portapantry.tables;

import com.example.portapantry.database.DBTableValues;
import com.example.portapantry.database.Database;
import com.example.portapantry.doas.FoodDOA;
import com.example.portapantry.pojos.DisplayFood;
import com.example.portapantry.pojos.Food;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodsTable implements FoodDOA {
    Database db = Database.getInstance();
    ArrayList<Food> foods;

    @Override
    public void createFood(Food food) {
        String query = "INSERT INTO " + DBTableValues.TABLE_FOODS +
                "(" + DBTableValues.FOODS_COLUMN_NAME + ", " +
                DBTableValues.FOODS_COLUMN_FOOD_GROUP + ", " +
                DBTableValues.FOODS_COLUMN_FOOD_ALLERGY + ", " +
                DBTableValues.FOODS_COLUMN_AMOUNT + ", " +
                DBTableValues.FOODS_COLUMN_EXPIRY_DATE + ") VALUES ('" +
                food.getName() + "'," + food.getFoodGroup() + "," +
                food.getFoodAllergy() + ",'" + food.getAmount() + "','" +
                food.getExpiryDate() + "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Food> getAllFoods() {
        //SELECT * FROM FOODS
        String query = "SELECT * FROM " + DBTableValues.TABLE_FOODS;
        foods = new ArrayList<>();
        try {
            Statement getFoods =
                    db.getConnection().createStatement();
            ResultSet data = getFoods.executeQuery(query);

            while(data.next()){
                foods.add(
                        new Food(data.getInt(DBTableValues.FOODS_COLUMN_ID),
                                data.getString(DBTableValues.FOODS_COLUMN_NAME),
                                data.getInt(DBTableValues.FOODS_COLUMN_FOOD_GROUP),
                                data.getInt(DBTableValues.FOODS_COLUMN_FOOD_ALLERGY),
                                data.getString(DBTableValues.FOODS_COLUMN_AMOUNT),
                                data.getString(DBTableValues.FOODS_COLUMN_EXPIRY_DATE))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    @Override
    public Food getFood(int id) {
        String query = "SELECT * FROM " + DBTableValues.TABLE_FOODS +
                " WHERE " + DBTableValues.FOODS_COLUMN_ID + " = " + id;
        try {
            Statement getFood = db.getConnection().createStatement();
            ResultSet data = getFood.executeQuery(query);
            if(data.next()){
                Food food =  new Food(data.getInt(DBTableValues.ALLERGIES_COLUMN_ID),
                        data.getString(DBTableValues.ALLERGIES_COLUMN_NAME),
                        data.getInt(DBTableValues.FOODS_COLUMN_FOOD_GROUP),
                        data.getInt(DBTableValues.FOODS_COLUMN_FOOD_ALLERGY),
                        data.getString(DBTableValues.FOODS_COLUMN_AMOUNT),
                        data.getString(DBTableValues.FOODS_COLUMN_EXPIRY_DATE));
                return food;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateFood(Food food) {
        String query = "UPDATE " + DBTableValues.TABLE_FOODS + " SET " +
                DBTableValues.FOODS_COLUMN_NAME + " = '" + food.getName() +  "', " +
                DBTableValues.FOODS_COLUMN_FOOD_GROUP + " = " + food.getFoodGroup() +  ", " +
                DBTableValues.FOODS_COLUMN_FOOD_ALLERGY + " = " + food.getFoodAllergy() + ", " +
                DBTableValues.FOODS_COLUMN_AMOUNT + " = '" + food.getAmount() + "', " +
                DBTableValues.FOODS_COLUMN_EXPIRY_DATE + " = '" + food.getExpiryDate() +
                "' WHERE " + DBTableValues.FOODS_COLUMN_ID + " = " + food.getId();
        try {
            Statement updateFood = db.getConnection().createStatement();
            updateFood.executeUpdate(query);
            System.out.println("Record Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFood(int food) {
        String query  = "DELETE FROM " + DBTableValues.TABLE_FOODS + " WHERE " +
                DBTableValues.FOODS_COLUMN_ID + " = " + food;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted record");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DisplayFood> getPrettyFoods(){
        ArrayList<DisplayFood> foods = new ArrayList<DisplayFood>();
        String query = "SELECT foods.id, foods.name, food_groups.name AS food_group," +
                " food_allergies.name AS food_allergy, foods.amount, foods.expiry_date" +
                " from foods " +
                "JOIN food_groups on foods.food_group = food_groups.id " +
                "JOIN food_allergies on foods.food_allergy = food_allergies.id " +
                "ORDER BY foods.id ASC";
        try {
            Statement getFoods = db.getConnection().createStatement();
            ResultSet data = getFoods.executeQuery(query);
            while(data.next()) {
                foods.add(new DisplayFood(data.getInt("id"),
                        data.getString("name"),
                        data.getString("food_group"),
                        data.getString("food_allergy"),
                        data.getString("amount"),
                        data.getString("expiry_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foods;
    }

    public int getFoodGroupCount(int foodGroup) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT * FROM " + DBTableValues.TABLE_FOODS + " WHERE "
                                    + DBTableValues.FOODS_COLUMN_FOOD_GROUP + " = '" + foodGroup + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count = data.getRow();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
