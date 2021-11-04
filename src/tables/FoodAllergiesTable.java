package tables;

import database.DBTableValues;
import database.Database;
import doas.FoodAllergyDOA;
import pojos.FoodAllergy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodAllergiesTable implements FoodAllergyDOA {

    Database db = Database.getInstance();
    ArrayList<FoodAllergy> foodAllergies;

    @Override
    public ArrayList<FoodAllergy> getAllFoodAllergies() {
        //SELECT * FROM FOOD_ALLERGIES
        String query = "SELECT * FROM " + DBTableValues.TABLE_FOOD_ALLERGIES;
        foodAllergies = new ArrayList<>();
        try {
            Statement getFoodGroups =
                    db.getConnection().createStatement();
            ResultSet data = getFoodGroups.executeQuery(query);

            while(data.next()){
                foodAllergies.add(
                        new FoodAllergy(data.getInt(DBTableValues.ALLERGIES_COLUMN_ID),
                                data.getString(DBTableValues.ALLERGIES_COLUMN_NAME))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodAllergies;
    }

    @Override
    public FoodAllergy getFoodAllergy(int id) {
        String query = "SELECT * FROM " + DBTableValues.TABLE_FOOD_ALLERGIES +
                " WHERE " + DBTableValues.ALLERGIES_COLUMN_ID + " = " + id;
        try {
            Statement getFoodAllergy = db.getConnection().createStatement();
            ResultSet data = getFoodAllergy.executeQuery(query);
            if(data.next()){
                FoodAllergy foodAllergy =  new FoodAllergy(data.getInt(DBTableValues.ALLERGIES_COLUMN_ID),
                        data.getString(DBTableValues.ALLERGIES_COLUMN_NAME));
                return foodAllergy;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
