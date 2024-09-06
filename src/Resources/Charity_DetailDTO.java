package Resources;

public class Charity_DetailDTO {
    private int charity_id;
    private String charity_name;
    private String district;
    private String city;
    private int no_of_members;
    private String name;
    private String Phone_no;
    private int user_id;

    public Charity_DetailDTO() {
    }

    public Charity_DetailDTO(int charity_id, String charity_name, String district, String city, int no_of_members,
            String name, String Phone_no, int user_id) {
        this.charity_id = charity_id;
        this.charity_name = charity_name;
        this.district = district;
        this.city = city;
        this.no_of_members = no_of_members;
        this.Phone_no = Phone_no;
        this.name = name;
        this.user_id = user_id;
    }

    public int getCharity_id() {
        return this.charity_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return this.Phone_no;
    }

    public void setPhone_no(String Phone_no) {
        this.Phone_no = Phone_no;
    }

    public void setCharity_id(int charity_id) {
        this.charity_id = charity_id;
    }

    public String getCharity_name() {
        return this.charity_name;
    }

    public void setCharity_name(String charity_name) {
        this.charity_name = charity_name;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNo_of_members() {
        return this.no_of_members;
    }

    public void setNo_of_members(int no_of_members) {
        this.no_of_members = no_of_members;

    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

}
