package DatabaseClasses;

public class DBTableValues {

    //Foods TABLE
    public static final String TABLE_FOODS = "foods";
    public static final String FOODS_COLUMN_ID = "id";
    public static final String FOODS_COLUMN_NAME = "name";

    public static final String FOODS_COLUMN_FOOD_GROUP = "food_group";
    public static final String FOODS_COLUMN_FOOD_FACTS = "food_facts";

    public static final String FOODS_COLUMN_AMOUNT = "amount";
    public static final String FOODS_COLUMN_EXPIRY_DATE = "expiry_date";

    //Food_Facts TABLE
    public static final String TABLE_FOOD_FACTS = "food_facts";
    public static final String FACTS_COLUMN_ID = "id";
    public static final String FACTS_COLUMN_SERVING_SIZE = "serving_size";
    public static final String FACTS_COLUMN_CALORIES_PER_SERVING = "calories_per_servings";
    public static final String FACTS_COLUMN_SATURATED_FAT = "saturated_fat";
    public static final String FACTS_COLUMN_POLYUNSATURATED_FAT = "ployunsaturated_fat";
    public static final String FACTS_COLUMN_MONOUNSATURATED_FAT = "monounsaturated_fat";
    public static final String FACTS_COLUMN_CHOLESTEROL = "cholesterol";
    public static final String FACTS_COLUMN_SODIUM = "sodium";
    public static final String FACTS_COLUMN_DIETARY_FIBRE = "dietary_fibre";
    public static final String FACTS_COLUMN_SUGARS = "sugars";
    public static final String FACTS_COLUMN_PROTEIN = "protein";
    public static final String FACTS_COLUMN_VITAMIN_D = "vitamin_d";
    public static final String FACTS_COLUMN_CALCIUM = "calcium";
    public static final String FACTS_COLUMN_IRON = "iron";
    public static final String FACTS_COLUMN_POTASSIUM = "potassium";
    public static final String FACTS_COLUMN_VITAMIN_A = "vitamin_a";
    public static final String FACTS_COLUMN_VITAMIN_C = "vitamin_c";

    //Food_Groups TABLE
    public static final String TABLE_FOOD_GROUPS = "food_groups";
    public static final String GROUPS_COLUMN_ID = "id";
    public static final String GROUPS_COLUMN_NAME = "name";

    //Table Create Statements
    public static final String CREATE_TABLE_FOODS =
            "CREATE TABLE " + TABLE_FOODS + " (" +
                FOODS_COLUMN_ID + " int(11) NOT NULL, " +
                FOODS_COLUMN_NAME + " varchar(20) NOT NULL, " +
                FOODS_COLUMN_FOOD_GROUP + " int(11) NOT NULL, " +
                FOODS_COLUMN_FOOD_FACTS + " int(11) NOT NULL, " +
                FOODS_COLUMN_AMOUNT + " varchar(20) NOT NULL, " +
                FOODS_COLUMN_EXPIRY_DATE + " date NOT NULL; " +
                    "PRIMARY KEY(" + FOODS_COLUMN_ID + ")" +
                    ");";

    public static final String CREATE_TABLE_FOOD_FACTS =
            "CREATE TABLE " + TABLE_FOOD_FACTS + " (" +
                    FACTS_COLUMN_ID + " int(11) NOT NULL, " +
                    FACTS_COLUMN_SERVING_SIZE + " varchar(20) NOT NULL, " +
                    FACTS_COLUMN_CALORIES_PER_SERVING + " int(11) NOT NULL, " +
                    FACTS_COLUMN_SATURATED_FAT + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_POLYUNSATURATED_FAT + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_MONOUNSATURATED_FAT + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_CHOLESTEROL + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_SODIUM + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_DIETARY_FIBRE + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_SUGARS + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_PROTEIN + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_VITAMIN_D + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_CALCIUM + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_IRON + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_POTASSIUM + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_VITAMIN_A + " decimal(10,0) NOT NULL, " +
                    FACTS_COLUMN_VITAMIN_C + " decimal(10,0) NOT NULL, " +
                        "PRIMARY KEY(" + FACTS_COLUMN_ID + ")" +
                        ");";

    public static final String CREATE_TABLE_FOOD_GROUPS =
            "CREATE TABLE " + TABLE_FOOD_GROUPS + " (" +
                    GROUPS_COLUMN_ID + " int(11) NOT NULL, " +
                    GROUPS_COLUMN_NAME + " varchar(15) NOT NULL, " +
                        "PRIMARY KEY(" + GROUPS_COLUMN_ID + ")" +
                        ");";
}
