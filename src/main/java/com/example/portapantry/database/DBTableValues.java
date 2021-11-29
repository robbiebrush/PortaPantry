package com.example.portapantry.database;

public class DBTableValues {

    //Foods TABLE
    public static final String TABLE_FOODS = "Foods";
    public static final String FOODS_COLUMN_ID = "id";
    public static final String FOODS_COLUMN_NAME = "name";

    public static final String FOODS_COLUMN_FOOD_GROUP = "food_group";
    public static final String FOODS_COLUMN_FOOD_ALLERGY = "food_allergy";

    public static final String FOODS_COLUMN_AMOUNT = "amount";
    public static final String FOODS_COLUMN_EXPIRY_DATE = "expiry_date";

    //Food_Allergies TABLE
<<<<<<< HEAD
    public static final String TABLE_FOOD_ALLERGIES = "FoodAllergies";
=======
    public static final String TABLE_FOOD_ALLERGIES = "Food_Allergies";
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
    public static final String ALLERGIES_COLUMN_ID = "id";
    public static final String ALLERGIES_COLUMN_NAME = "name";

    //Food_Groups TABLE
<<<<<<< HEAD
    public static final String TABLE_FOOD_GROUPS = "FoodGroups";
=======
    public static final String TABLE_FOOD_GROUPS = "Food_Groups";
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
    public static final String GROUPS_COLUMN_ID = "id";
    public static final String GROUPS_COLUMN_NAME = "name";

    //Table Create Statements
    public static final String CREATE_TABLE_FOODS =
            "CREATE TABLE " + TABLE_FOODS + " (" +
                FOODS_COLUMN_ID + " int(11) NOT NULL, " +
                FOODS_COLUMN_NAME + " varchar(20) NOT NULL, " +
                FOODS_COLUMN_FOOD_GROUP + " int(11) NOT NULL, " +
                FOODS_COLUMN_FOOD_ALLERGY + " int(11) NOT NULL, " +
                FOODS_COLUMN_AMOUNT + " varchar(20) NOT NULL, " +
                FOODS_COLUMN_EXPIRY_DATE + " date NOT NULL; " +
                    "PRIMARY KEY(" + FOODS_COLUMN_ID + ")" +
                    "FOREIGN KEY (" + FOODS_COLUMN_FOOD_GROUP + ")" +
                    " REFERENCES " + TABLE_FOOD_GROUPS + "(" + GROUPS_COLUMN_ID +")," +
                    "FOREIGN KEY (" + FOODS_COLUMN_FOOD_ALLERGY + ")" +
                    " REFERENCES " + TABLE_FOOD_ALLERGIES + "(" + ALLERGIES_COLUMN_ID +"));";

    public static final String CREATE_TABLE_FOOD_ALLERGIES =
            "CREATE TABLE " + TABLE_FOOD_ALLERGIES + " (" +
                    ALLERGIES_COLUMN_ID + " int(11) NOT NULL, " +
<<<<<<< HEAD
                    ALLERGIES_COLUMN_NAME + "varchar(20) NOT NULL, " +
=======
                    ALLERGIES_COLUMN_NAME + " varchar(20) NOT NULL, " +
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
                        "PRIMARY KEY(" + ALLERGIES_COLUMN_ID + ")" +
                        ");";

    public static final String CREATE_TABLE_FOOD_GROUPS =
            "CREATE TABLE " + TABLE_FOOD_GROUPS + " (" +
                    GROUPS_COLUMN_ID + " int(11) NOT NULL, " +
                    GROUPS_COLUMN_NAME + " varchar(15) NOT NULL, " +
                        "PRIMARY KEY(" + GROUPS_COLUMN_ID + ")" +
                        ");";
}
