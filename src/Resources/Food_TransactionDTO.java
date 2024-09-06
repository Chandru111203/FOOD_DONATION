package Resources;

public class Food_TransactionDTO {
    private int transacton_id;
    private String location;
    private int food_availability;
    private String date;
    private String session;
    private int charity_id;
    private String foodDonator;

    public Food_TransactionDTO() {
    }

    public Food_TransactionDTO(int transacton_id, String location, int food_availability, String date, String session,
            String foodDonator, int charity_id) {
        this.transacton_id = transacton_id;
        this.location = location;
        this.food_availability = food_availability;
        this.date = date;
        this.session = session;
        this.charity_id = charity_id;
        this.foodDonator = foodDonator;
    }

    public String getFoodDonator() {
        return this.foodDonator;
    }

    public void setFoodDonator(String foodDonator) {
        this.foodDonator = foodDonator;
    }

    public int getTransacton_id() {
        return this.transacton_id;
    }

    public void setTransacton_id(int transacton_id) {
        this.transacton_id = transacton_id;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFood_availability() {
        return this.food_availability;
    }

    public void setFood_availability(int food_availability) {
        this.food_availability = food_availability;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getCharity_id() {
        return this.charity_id;
    }

    public void setCharity_id(int charity_id) {
        this.charity_id = charity_id;
    }

}
