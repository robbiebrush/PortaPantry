package pojos;

public class Food {
    private int id;
    private String name;
    private int foodGroup;
    private int foodFacts;
    private String amount;
    private String expiryDate;

    public Food(int id, String name) {
        this.id = id;
        this.name = name;
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

    public int getFoodFacts() { return foodFacts; }

    public void setFoodFacts(int foodFacts) { this.foodFacts = foodFacts; }

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }

    public String getExpiryDate() { return expiryDate; }

    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

}
