package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resources.LoginDTO;

public class LoginDAO extends Connect {
    PreparedStatement loginData;

    public LoginDAO() throws SQLException {
        loginData = conn.prepareStatement(
                "SELECT L.email,L.password,L.user_id,U.Role FROM Login L JOIN User U USING(User_id) WHERE Email=?");
    }

    public LoginDTO getLoginData(String email) throws SQLException {
        loginData.setString(1, email);
        ResultSet res = loginData.executeQuery();
        if (res.next()) {
            return new LoginDTO(res.getString(1), res.getString(2), res.getInt(3), res.getString(4));
        }
        return null;
    }
}