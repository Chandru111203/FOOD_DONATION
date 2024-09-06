package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.DonatorDTO;
import Resources.Food_TransactionDTO;
import Resources.UserDTO;

public class FoodTransaction extends Connect {
    private PreparedStatement selectFood;
    private PreparedStatement addFood;
    private PreparedStatement addFoodrandom;
    private PreparedStatement randomdonator;
    protected PreparedStatement acceptdonator;
    protected PreparedStatement adddonatorcharity;

    private PreparedStatement addFooddonator;
    private PreparedStatement selectrequest;
    private PreparedStatement request;
   
    private PreparedStatement selectslot;

    private static FoodTransaction instance;

    private FoodTransaction() throws SQLException {
        selectFood = conn.prepareStatement(
                "SELECT Transaction_id,Location,Food_availability,Date,Session,food_donator FROM food_transaction WHERE Charity_id is NULL AND Location=?");
        addFood = conn.prepareStatement(
                "Insert into food_transaction(charity_id,date,session,location,food_donator,food_availability,status) Values(?,?,?,?,?,?,false)");
        addFooddonator = conn
                .prepareStatement("Insert into donator_details(donator_name,phone_no,charity_id) Values(?,?,?) ");
        addFoodrandom = conn.prepareStatement(
                "Insert into food_transaction(date,session,location,food_donator,food_availability,status) Values(?,?,?,?,?,false) ");
        randomdonator = conn.prepareStatement("Insert into donator_details(donator_name,phone_no) Values(?,?) ");
        acceptdonator = conn
                .prepareStatement("update food_transaction set status=true,charity_id=(select charity_id from user where user_id=?) where transaction_id=?");
        adddonatorcharity=conn.prepareStatement("update donator_details set charity_id=(select charity_id from user where user_id=?)");
        selectrequest = conn.prepareStatement(
                "SELECT Transaction_id,Location,Food_availability,Date,Session,food_donator FROM food_transaction WHERE Charity_id =(select charity_id from user where user_id=?) and status='0'");
        request = conn.prepareStatement("update food_transaction set status=true ,charity_id=(select charity_id from user where user_id=?) where transaction_id=?");
      
        selectslot = conn.prepareStatement(
                "select DATE(date),session from food_transaction where charity_id=? and DATE(date)=? and session=?");
    }

    public static FoodTransaction getInstance() throws SQLException {
        if (instance == null) {
            instance = new FoodTransaction();
        }
        return instance;
    }

    public ArrayList<Food_TransactionDTO> getByLocation(String location) throws SQLException {
        selectFood.setString(1, location);
        ResultSet res = selectFood.executeQuery();
        ArrayList<Food_TransactionDTO> arr = new ArrayList<>();
        while (res.next()) {
            arr.add(new Food_TransactionDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4),
                    res.getString(5), res.getString(6), 0));
        }
        return arr;
    }

    public ArrayList<Food_TransactionDTO> getbyid(int user_id) throws Exception {
        selectrequest.setInt(1, user_id);
        ResultSet res = selectrequest.executeQuery();
        ArrayList<Food_TransactionDTO> arr = new ArrayList<>();
        while (res.next()) {
            arr.add(new Food_TransactionDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4),
                    res.getString(5), res.getString(6), 0));
        }
        return arr;

    }

    public void addfood(Food_TransactionDTO food, DonatorDTO donate) throws Exception {
        addFood.setInt(1, food.getCharity_id());
        addFood.setString(2, food.getDate());
        addFood.setString(3, food.getSession());
        addFood.setString(4, food.getLocation());
        addFood.setString(5, food.getFoodDonator());
        addFood.setInt(6, food.getFood_availability());
        addFood.executeUpdate();

        addFooddonator.setString(1, donate.getDonator_name());
        addFooddonator.setString(2, donate.getPhone_no());
        addFooddonator.setInt(3, donate.getCharity_id());
        addFooddonator.executeUpdate();
    }

    public void addfoodrandom(Food_TransactionDTO food, DonatorDTO donate) throws Exception {

        addFoodrandom.setString(1, food.getDate());
        addFoodrandom.setString(2, food.getSession());
        addFoodrandom.setString(3, food.getLocation());
        addFoodrandom.setString(4, food.getFoodDonator());
        addFoodrandom.setInt(5, food.getFood_availability());
        addFoodrandom.executeUpdate();

        randomdonator.setString(1, donate.getDonator_name());
        randomdonator.setString(2, donate.getPhone_no());
        randomdonator.executeUpdate();
    }

    public void acceptdonate(Food_TransactionDTO accept,UserDTO user) throws Exception {
        acceptdonator.setInt(1, user.getUser_id());
        acceptdonator.setInt(2, accept.getTransacton_id());
        acceptdonator.executeUpdate();
        adddonatorcharity.setInt(1, user.getUser_id());
        adddonatorcharity.executeUpdate();
    }

    public void selrequest(Food_TransactionDTO accept,UserDTO user) throws Exception {
        request.setInt(1, user.getUser_id());
        request.setInt(2, accept.getTransacton_id());
        request.executeUpdate();
     
    }

    public Food_TransactionDTO getbycharityid(int id, String date, String session) throws Exception {
        selectslot.setInt(1, id);
        selectslot.setString(2, date);
        selectslot.setString(3, session);
        ResultSet rs = selectslot.executeQuery();
        while (rs.next()) {
            return new Food_TransactionDTO(0, null, 0, rs.getString(1), rs.getString(2), null, 0);
        }
        return null;
    }

}
