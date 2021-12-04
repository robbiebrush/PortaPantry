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
    public static final String TABLE_FOOD_ALLERGIES = "Food_Allergies";
    public static final String ALLERGIES_COLUMN_ID = "id";
    public static final String ALLERGIES_COLUMN_NAME = "name";

    //Food_Groups TABLE
    public static final String TABLE_FOOD_GROUPS = "Food_Groups";
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
                    ALLERGIES_COLUMN_NAME + " varchar(20) NOT NULL, " +
                        "PRIMARY KEY(" + ALLERGIES_COLUMN_ID + ")" +
                        ");";

    public static final String POPULATE_TABLE_FOOD_ALLERGIES =
            "INSERT INTO" + DBTableValues.TABLE_FOOD_ALLERGIES + " (" +
                    DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('None');" +
            "INSERT INTO" + DBTableValues.TABLE_FOOD_ALLERGIES + " (" +
                    DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('Nuts');" +
            "INSERT INTO" + DBTableValues.TABLE_FOOD_ALLERGIES + " (" +
                    DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('Sea Food');" +
            "INSERT INTO" + DBTableValues.TABLE_FOOD_ALLERGIES + " (" +
                    DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('Unknown');";

    public static final String CREATE_TABLE_FOOD_GROUPS =
            "CREATE TABLE " + TABLE_FOOD_GROUPS + " (" +
                    GROUPS_COLUMN_ID + " int(11) NOT NULL, " +
                    GROUPS_COLUMN_NAME + " varchar(15) NOT NULL, " +
                        "PRIMARY KEY(" + GROUPS_COLUMN_ID + ")" +
                        ");";

    public static final String POPULATE_TABLE_FOOD_GROUPS =
            "INSERT INTO" + DBTableValues.TABLE_FOOD_GROUPS + " (" +
                    DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Proteins');" +
                    "INSERT INTO" + DBTableValues.TABLE_FOOD_GROUPS + " (" +
                    DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Grains');" +
                    "INSERT INTO" + DBTableValues.TABLE_FOOD_GROUPS + " (" +
                    DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Vegetables');" +
                    "INSERT INTO" + DBTableValues.TABLE_FOOD_GROUPS + " (" +
                    DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Fruits');" +
                    "INSERT INTO" + DBTableValues.TABLE_FOOD_GROUPS + " (" +
                    DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Dairy');" +
                    "INSERT INTO" + DBTableValues.TABLE_FOOD_GROUPS + " (" +
                    DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Other');";
}
