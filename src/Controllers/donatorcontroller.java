package Controllers;

import java.util.ArrayList;

import Models.DonatorDAO;
import Models.FoodTransaction;
import Resources.DonatorDTO;
import Resources.Food_TransactionDTO;
// import Resources.LoginDTO;

public class donatorcontroller {
    public static void adddonation(int charity_id, String name, String phone_no, int amount) throws Exception {
        DonatorDTO donator = new DonatorDTO();
        donator.setCharity_id(charity_id);
        donator.setDonator_name(name);
        donator.setAmount(amount);
        donator.setPhone_no(phone_no);

        DonatorDAO donate = DonatorDAO.getInstance();
        donate.adddonate(donator);
    }

    public static ArrayList<DonatorDTO> donationreceived(int user_id) throws Exception {
        DonatorDAO donateamount = DonatorDAO.getInstance();
        return donateamount.donationreceived(user_id);
    }

    public static void addfood(int id, String Date, String session, String name, String Phone_no, String location,
            int availability) throws Exception {
        Food_TransactionDTO food = new Food_TransactionDTO();

        FoodTransaction slot = FoodTransaction.getInstance();

        Food_TransactionDTO details = slot.getbycharityid(id, Date, session);
        if (details != null) {
            throw new Exception("Session already booked");
        }

        food.setCharity_id(id);
        food.setDate(Date);
        food.setSession(session);
        food.setLocation(location);
        food.setFoodDonator(name);
        food.setFood_availability(availability);

        DonatorDTO donate = new DonatorDTO();
        donate.setDonator_name(name);
        donate.setPhone_no(Phone_no);
        donate.setCharity_id(id);

        FoodTransaction fooddonate = FoodTransaction.getInstance();
        fooddonate.addfood(food, donate);

    }

    public static void addfoodrandom(String Date, String session, String name, String Phone_no, String location,
            int availability) throws Exception {
        Food_TransactionDTO food = new Food_TransactionDTO();

        food.setDate(Date);
        food.setSession(session);
        food.setLocation(location);
        food.setFoodDonator(name);
        food.setFood_availability(availability);

        DonatorDTO donate = new DonatorDTO();
        donate.setDonator_name(name);
        donate.setPhone_no(Phone_no);

        FoodTransaction fooddonate = FoodTransaction.getInstance();
        fooddonate.addfoodrandom(food, donate);
    }
}
