package com.example.portapantry.database;

public class DBTableValues {

    //Foods TABLE
    public static final String TABLE_FOODS = "foods";
    public static final String FOODS_COLUMN_ID = "id";
    public static final String FOODS_COLUMN_NAME = "name";

    public static final String FOODS_COLUMN_FOOD_GROUP = "food_group";
    public static final String FOODS_COLUMN_FOOD_ALLERGY = "food_allergy";

    public static final String FOODS_COLUMN_AMOUNT = "amount";
    public static final String FOODS_COLUMN_EXPIRY_DATE = "expiry_date";

    //Food_Allergies TABLE
    public static final String TABLE_FOOD_ALLERGIES = "food_allergies";
    public static final String ALLERGIES_COLUMN_ID = "id";
    public static final String ALLERGIES_COLUMN_NAME = "name";

    //Food_Groups TABLE
    public static final String TABLE_FOOD_GROUPS = "food_groups";
    public static final String GROUPS_COLUMN_ID = "id";
    public static final String GROUPS_COLUMN_NAME = "name";

    //Table Create Statements
    public static final String CREATE_TABLE_FOODS =
            "CREATE TABLE " + TABLE_FOODS + " (" +
                FOODS_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                FOODS_COLUMN_NAME + " varchar(20) NOT NULL, " +
                FOODS_COLUMN_FOOD_GROUP + " int(11) NOT NULL, " +
                FOODS_COLUMN_FOOD_ALLERGY + " int(11) NOT NULL, " +
                FOODS_COLUMN_AMOUNT + " varchar(20) NOT NULL, " +
                FOODS_COLUMN_EXPIRY_DATE + " date NOT NULL, " +
                FOODS_COLUMN_EXPIRY_DATE + " varchar(20) NOT NULL, " +
                    " FOREIGN KEY (" + FOODS_COLUMN_FOOD_GROUP + ")" +
                            " REFERENCES " + TABLE_FOOD_GROUPS + "(" + GROUPS_COLUMN_ID +")," +
                    " FOREIGN KEY (" + FOODS_COLUMN_FOOD_ALLERGY + ")" +
                            " REFERENCES " + TABLE_FOOD_ALLERGIES + "(" + ALLERGIES_COLUMN_ID +"));";

    public static final String CREATE_TABLE_FOOD_ALLERGIES =
            "CREATE TABLE " + TABLE_FOOD_ALLERGIES + " (" +
                    ALLERGIES_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT, " +
                    ALLERGIES_COLUMN_NAME + " varchar(20) NOT NULL, " +
                        "PRIMARY KEY(" + ALLERGIES_COLUMN_ID + ")" +
                        ");";

    public static final String INSERT_ALLERGIES_NONE =
                "INSERT INTO " + DBTableValues.TABLE_FOOD_ALLERGIES + " (" + DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('None');";
    public static final String INSERT_ALLERGIES_NUTS =
                        "INSERT INTO " + DBTableValues.TABLE_FOOD_ALLERGIES + " (" + DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('Nuts');";
    public static final String INSERT_ALLERGIES_SEA_FOOD =
                        "INSERT INTO " + DBTableValues.TABLE_FOOD_ALLERGIES + " (" + DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('Sea Food');";
    public static final String INSERT_ALLERGIES_UNKNOWN =
                        "INSERT INTO " + DBTableValues.TABLE_FOOD_ALLERGIES + " (" + DBTableValues.ALLERGIES_COLUMN_NAME + ") VALUES ('Unknown');";

    public static final String CREATE_TABLE_FOOD_GROUPS =
            "CREATE TABLE " + TABLE_FOOD_GROUPS + " (" +
                    GROUPS_COLUMN_ID + " int(11) NOT NULL AUTO INCREMENT, " +
                    GROUPS_COLUMN_ID + " int(11) NOT NULL AUTO_INCREMENT, " +
                    GROUPS_COLUMN_NAME + " varchar(15) NOT NULL, " +
                        "PRIMARY KEY(" + GROUPS_COLUMN_ID + ")" +
                        ");";

    public static final String INSERT_GROUPS_PROTEINS =
            "INSERT INTO " + DBTableValues.TABLE_FOOD_GROUPS + " (" + DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Proteins');";
    public static final String INSERT_GROUPS_GRAINS =
            "INSERT INTO " + DBTableValues.TABLE_FOOD_GROUPS + " (" + DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Grains');";
    public static final String INSERT_GROUPS_VEGS =
            "INSERT INTO " + DBTableValues.TABLE_FOOD_GROUPS + " (" + DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Vegetables');";
    public static final String INSERT_GROUPS_FRUITS =
            "INSERT INTO " + DBTableValues.TABLE_FOOD_GROUPS + " (" + DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Fruits');";
    public static final String INSERT_GROUPS_DAIRY =
            "INSERT INTO " + DBTableValues.TABLE_FOOD_GROUPS + " (" + DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Dairy');";
    public static final String INSERT_GROUPS_OTHER =
            "INSERT INTO " + DBTableValues.TABLE_FOOD_GROUPS + " (" + DBTableValues.GROUPS_COLUMN_NAME + ") VALUES ('Other');";
}
