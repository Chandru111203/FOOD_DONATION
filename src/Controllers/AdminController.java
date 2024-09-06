package Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Models.CharityDAO;
import Models.userDAO;
import Resources.Charity_DetailDTO;
import Resources.LoginDTO;
import Resources.UserDTO;

public class AdminController {
    public static void registerCharity(String charity_name, String district, String city, int no_of_member,
            String phone_no, String name, String email, String password) throws Exception {
        UserDTO user = new UserDTO();
        user.setName(name);
        user.setPhone_no(phone_no);
        user.setRole("charity");

        LoginDTO login = new LoginDTO();
        login.setEmail(email);
        login.setPassword(password);

        Charity_DetailDTO charity = new Charity_DetailDTO();
        charity.setCharity_name(charity_name);
        charity.setCity(city);
        charity.setDistrict(district);
        charity.setNo_of_members(no_of_member);

        CharityDAO charityModel = CharityDAO.getInstance();
        charityModel.addCharity(user, login, charity);
    }

    public static void removeCharity(int charity_id, int user_id) throws SQLException {
        UserDTO user1 = new UserDTO();
        user1.setcharity_id(charity_id);
        
        LoginDTO login1 = new LoginDTO();
        login1.setUserId(user_id);
        Charity_DetailDTO charity1 = new Charity_DetailDTO();
        charity1.setCharity_id(charity_id);
        CharityDAO charitymode = CharityDAO.getInstance();
        charitymode.deletecharity(user1, login1, charity1);
    }

    public static void registeradmin(String name, String email, String password, String phone_no) throws Exception {
        UserDTO user = new UserDTO();
        user.setName(name);
        user.setPhone_no(phone_no);
        user.setRole("admin");

        LoginDTO login = new LoginDTO();
        login.setEmail(email);
        login.setPassword(password);

        userDAO usermodel = userDAO.getInstance();
        usermodel.addadmin(user, login);
    }

    public static ArrayList<UserDTO> removeadmin() throws Exception {
        userDAO remove = userDAO.getInstance();
        return remove.removeadmin();
    }

    public static void deleteadmin(int user_id) throws Exception {
        UserDTO user = new UserDTO();
        user.setUser_id(user_id);
        LoginDTO login = new LoginDTO();
        login.setUserId(user_id);

        userDAO usermodal = userDAO.getInstance();
        usermodal.deleteadmin(user, login);

    }
}