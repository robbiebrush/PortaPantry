package pojos;

public class Food {
    private int id;
    private String name;
    private int foodGroup;
    private int foodAllergy;
    private String amount;
    private String expiryDate;

    public Food(int id, String name, int foodGroup, int foodAllergy, String amount, String expiryDate) {
        this.id = id;
        this.name = name;
        this.foodGroup = foodGroup;
        this.foodAllergy = foodAllergy;
        this.amount = amount;
        this.expiryDate = expiryDate;
    }

    public int getId() {
            return id;
        }

    public void setId(int id) {
            this.id = id;
        }

    public String getName() {
            return name;
        }

    public void setName(String name) { this.name = name; }

    public int getFoodGroup() { return foodGroup; }

    public void setFoodGroup(int foodGroup) { this.foodGroup = foodGroup; }

    public int getFoodAllergy() { return foodAllergy; }

    public void setFoodAllergy(int foodFacts) { this.foodAllergy = foodAllergy; }

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }

    public String getExpiryDate() { return expiryDate; }

    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

}
