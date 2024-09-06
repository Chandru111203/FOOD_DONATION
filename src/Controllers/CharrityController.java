package Controllers;

import java.util.ArrayList;

import Models.CharityDAO;
import Models.FoodTransaction;
import Resources.Charity_DetailDTO;
import Resources.Food_TransactionDTO;
import Resources.UserDTO;

public class CharrityController {
    public static void updatemember(int ID, int no_of_member) throws Exception {
        Charity_DetailDTO update = new Charity_DetailDTO();
        update.setNo_of_members(no_of_member);
        update.setCharity_id(ID);

        CharityDAO updatecharity = CharityDAO.getInstance();
        updatecharity.change(update);
    }

    public static void updatelocation(int Id, String district, String city) throws Exception {
        Charity_DetailDTO locationupdate = new Charity_DetailDTO();
        locationupdate.setCharity_id(Id);
        locationupdate.setDistrict(district);
        locationupdate.setCity(city);

        CharityDAO updatelocation = CharityDAO.getInstance();
        updatelocation.changelocation(locationupdate);
    }

    public static ArrayList<Food_TransactionDTO> getByLocation(String location) throws Exception {
        FoodTransaction foodModal = FoodTransaction.getInstance();
        return foodModal.getByLocation(location);
    }

    public static ArrayList<Charity_DetailDTO> getCharity() throws Exception {
        CharityDAO amount = CharityDAO.getInstance();
        return amount.getCharity();
    }

    public static ArrayList<Charity_DetailDTO> getCharityfordeletion() throws Exception {
        CharityDAO delete = CharityDAO.getInstance();
        return delete.getCharityfordeletion();
    }

    public static void acceptdonation(int id, int user_id) throws Exception {
        Food_TransactionDTO accept = new Food_TransactionDTO();
        accept.setTransacton_id(id);

        UserDTO user=new UserDTO();
        user.setUser_id(user_id);
        FoodTransaction food = FoodTransaction.getInstance();
        food.acceptdonate(accept,user);

    }

    public static ArrayList<Food_TransactionDTO> getbyid(int charity_id) throws Exception {
        FoodTransaction foodmodal = FoodTransaction.getInstance();
        return foodmodal.getbyid(charity_id);
    }

    public static void acceptrequest(int id,int user_id) throws Exception {
        Food_TransactionDTO accept = new Food_TransactionDTO();
        accept.setTransacton_id(id);
        UserDTO user=new UserDTO();
        user.setUser_id(user_id);

        FoodTransaction food = FoodTransaction.getInstance();
        food.selrequest(accept,user);

    }

}
