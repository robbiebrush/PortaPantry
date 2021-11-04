package tables;

import database.DBTableValues;
import database.Database;
import doas.FoodDOA;
import pojos.Food;

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
                food.getName() + "','" + food.getFoodGroup() + "','" +
                food.getFoodAllergies() + "','" + food.getAmount() + "','" +
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

    }

    @Override
    public void deleteFood(Food food) {

    }
}
