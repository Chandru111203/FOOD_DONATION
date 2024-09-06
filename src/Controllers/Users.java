package Controllers;

import Models.LoginDAO;
import Resources.LoginDTO;
import Util.Cookie;

public class Users {
    public static int login(String email, String password) throws Exception {
        LoginDAO login = new LoginDAO();
        LoginDTO user = login.getLoginData(email);
        if (user == null) {
            throw new Exception("Not a User");
        }
        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid password");
        }
        Cookie.setUser(user);
        if (user.getRole().equals("admin")) {
            return 1;
        }
        return 2;
    }

}
