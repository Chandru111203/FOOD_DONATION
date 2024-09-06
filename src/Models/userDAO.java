package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Resources.LoginDTO;
import Resources.UserDTO;

public class userDAO extends Connect {
    protected static userDAO inst;
    protected PreparedStatement insertLogin;
    protected PreparedStatement insertUser;
    protected PreparedStatement viewadmin;
    protected PreparedStatement deleteadmin;
    protected PreparedStatement deletelogin;

    private userDAO() throws Exception {
        insertLogin = conn.prepareStatement("INSERT INTO login(email,password,user_id) VALUES(?,?,?)");
        insertUser = conn.prepareStatement("INSERT INTO user(name,phone_no,role) VALUES(?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        viewadmin = conn.prepareStatement("select user_id,name from user where role='admin' ");
        deleteadmin = conn.prepareStatement("delete  from user  where user_id=?");
        deletelogin = conn.prepareStatement("delete  from login  where user_id=?");
    }

    public static userDAO getInstance() throws Exception {

        if (inst == null) {
            inst = new userDAO();
        }
        return inst;
    }

    public void addadmin(UserDTO user, LoginDTO login) throws Exception {
        insertUser.setString(1, user.getName());
        insertUser.setString(2, user.getPhone_no());
        insertUser.setString(3, user.getRole());

        insertUser.executeUpdate();
        ResultSet r1 = insertUser.getGeneratedKeys();
        if (r1.next()) {
            insertLogin.setString(1, login.getEmail());
            insertLogin.setString(2, login.getPassword());
            insertLogin.setInt(3, r1.getInt(1));

            insertLogin.executeUpdate();

        }
    }

    public ArrayList<UserDTO> removeadmin() throws Exception {
        ResultSet rs = viewadmin.executeQuery();
        ArrayList<UserDTO> ar = new ArrayList<>();
        while (rs.next()) {
            ar.add(new UserDTO(rs.getInt(1), rs.getString(2), null, null, 0));
        }
        return ar;

    }

    public void deleteadmin(UserDTO user, LoginDTO login) throws Exception {
        deleteadmin.setInt(1, user.getUser_id());
        deleteadmin.executeUpdate();
        deletelogin.setInt(1, login.getUserId());
        deletelogin.executeUpdate();
    }

}
