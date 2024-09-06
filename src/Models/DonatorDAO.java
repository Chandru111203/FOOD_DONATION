package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Resources.DonatorDTO;

public class DonatorDAO extends Connect {
    protected static DonatorDAO inst;
    protected PreparedStatement adddonator;
    protected PreparedStatement viewdonator;

    private DonatorDAO() throws Exception {
        adddonator = conn.prepareStatement(
                "Insert into donator_details(charity_id,donator_name,phone_no,amount) Values(?,?,?,?)");
        viewdonator = conn.prepareStatement(
                "Select donator_name,amount from donator_details where charity_id=(select charity_id from user where user_id=? and amount >0)");
    }

    public static DonatorDAO getInstance() throws Exception {
        if (inst == null) {
            inst = new DonatorDAO();
        }
        return inst;
    }

    public void adddonate(DonatorDTO donate) throws Exception {

        adddonator.setInt(1, donate.getCharity_id());
        adddonator.setString(2, donate.getDonator_name());
        adddonator.setString(3, donate.getPhone_no());
        adddonator.setInt(4, donate.getAmount());
        adddonator.executeUpdate();
    }

    public ArrayList<DonatorDTO> donationreceived(int user_id) throws Exception {
        viewdonator.setInt(1, user_id);
        ResultSet rs = viewdonator.executeQuery();
        ArrayList<DonatorDTO> arr = new ArrayList<>();
        while (rs.next()) {
            arr.add(new DonatorDTO(rs.getString(1), null, rs.getInt(2), null, 0));
        }
        return arr;

    }

}
