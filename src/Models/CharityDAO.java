package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// import javax.naming.spi.DirStateFactory.Result;

import Resources.Charity_DetailDTO;
// import Resources.Food_TransactionDTO;
import Resources.LoginDTO;
import Resources.UserDTO;

public class CharityDAO extends Connect {
    protected static CharityDAO inst;
    protected PreparedStatement insertLogin;
    protected PreparedStatement inserCharity;
    protected PreparedStatement insertUser;
    protected PreparedStatement deleteLogin;
    protected PreparedStatement deleteCharity;
    protected PreparedStatement deleteUser;
    protected PreparedStatement updatemember;
    protected PreparedStatement updatelocation;
    protected PreparedStatement showcharity;
    protected PreparedStatement charitydonation;
    protected PreparedStatement deletionview;

    private CharityDAO() throws SQLException {
        insertLogin = conn.prepareStatement("INSERT INTO login(email,password,user_id) VALUES(?,?,?)");
        inserCharity = conn.prepareStatement(
                "INSERT INTO charity_details(charity_name,district,city,no_of_members) VALUES(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        insertUser = conn.prepareStatement("INSERT INTO user(name,phone_no,role,charity_id) VALUES(?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);
        deleteLogin = conn.prepareStatement("Delete from login where user_id=?");
        deleteUser = conn.prepareStatement("Delete from user where charity_id=?");
        deleteCharity = conn.prepareStatement("Delete from charity_details where charity_id=?");
        updatemember = conn.prepareStatement("Update charity_details SET no_of_members =? where charity_id=?");
        updatelocation = conn.prepareStatement("update charity_details SET district=?,city=? where charity_id=?");
        showcharity = conn.prepareStatement(
                "Select c.charity_id,c.charity_name,c.city,c.no_of_members,u.name from charity_details join user using(charity_id) where city=?");
        charitydonation = conn.prepareStatement(
                "Select u.charity_id,c.charity_name,u.name,c.city,u.phone_no,c.no_of_members from charity_details as c   JOIN user as u using(charity_id)");
        deletionview = conn.prepareStatement(
                "Select c.charity_id,c.charity_name,u.name,c.city,u.user_id from charity_details as c   JOIN user as u using(charity_id)");

    }

    public static CharityDAO getInstance() throws SQLException {
        if (inst == null) {
            inst = new CharityDAO();
        }
        return inst;
    }

    public void addCharity(UserDTO user, LoginDTO login, Charity_DetailDTO charity) throws SQLException {
        inserCharity.setString(1, charity.getCharity_name());
        inserCharity.setString(2, charity.getDistrict());
        inserCharity.setString(3, charity.getCity());
        inserCharity.setInt(4, charity.getNo_of_members());
        inserCharity.executeUpdate();
        ResultSet res = inserCharity.getGeneratedKeys();
        if (res.next()) {
            insertUser.setString(1, user.getName());
            insertUser.setString(2, user.getPhone_no());
            insertUser.setString(3, user.getRole());
            insertUser.setInt(4, res.getInt(1));
            insertUser.executeUpdate();
            ResultSet r1 = insertUser.getGeneratedKeys();
            if (r1.next()) {
                insertLogin.setString(1, login.getEmail());
                insertLogin.setString(2, login.getPassword());
                insertLogin.setInt(3, r1.getInt(1));
                insertLogin.executeUpdate();
            }
        }

    }

    public void deletecharity(UserDTO user1, LoginDTO login1, Charity_DetailDTO charity1) throws SQLException {
        deleteCharity.setInt(1, charity1.getCharity_id());
        deleteCharity.executeUpdate();

        deleteUser.setInt(1, user1.getCharity_id());
        deleteUser.executeUpdate();

        deleteLogin.setInt(1, login1.getUserId());
        deleteLogin.executeUpdate();
    
    }

    public void change(Charity_DetailDTO update) throws SQLException {
        updatemember.setInt(1, update.getNo_of_members());
        updatemember.setInt(2, update.getCharity_id());
        updatemember.executeUpdate();

    }

    public void changelocation(Charity_DetailDTO locationupdate) throws Exception {
        updatelocation.setString(1, locationupdate.getDistrict());
        updatelocation.setString(2, locationupdate.getCity());
        updatelocation.setInt(3, locationupdate.getCharity_id());
        updatelocation.executeUpdate();
    }

    public ArrayList<Charity_DetailDTO> getCharity() throws Exception {
        ResultSet res = charitydonation.executeQuery();
        ArrayList<Charity_DetailDTO> arr = new ArrayList<>();
        while (res.next()) {
            arr.add(new Charity_DetailDTO(res.getInt(1), res.getString(2), null, res.getString(4), res.getInt(6),
                    res.getString(3), res.getString(5), 0));
        }
        return arr;

    }

    public ArrayList<Charity_DetailDTO> getCharityfordeletion() throws Exception {
        ResultSet rs = deletionview.executeQuery();
        ArrayList<Charity_DetailDTO> ar = new ArrayList<>();
        while (rs.next()) {
            ar.add(new Charity_DetailDTO(rs.getInt(1), rs.getString(2), null, rs.getString(4), 0, rs.getString(3), null,
                    rs.getInt(5)));
        }
        return ar;

    }

}
