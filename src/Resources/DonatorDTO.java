package Resources;

import java.sql.Date;

public class DonatorDTO {
    private String donator_name;
    private String phone_no;
    private int amount;
    private Date date;
    private int charity_id;

    public DonatorDTO() {
    }

    public DonatorDTO(
            String donator_name,
            String phone_no,
            int amount,
            Date date,
            int charity_id) {
        this.donator_name = donator_name;
        this.phone_no = phone_no;
        this.amount = amount;
        this.date = date;
        this.charity_id = charity_id;
    }

    public String getDonator_name() {
        return this.donator_name;
    }

    public void setDonator_name(String donator_name) {
        this.donator_name = donator_name;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCharity_id() {
        return this.charity_id;
    }

    public void setCharity_id(int charity_id) {
        this.charity_id = charity_id;
    }

}
