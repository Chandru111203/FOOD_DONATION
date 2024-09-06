package Resources;

public class UserDTO {
    public int user_id;
    private String name;
    private String phone_no;
    private String role;
    private int charity_id;

    public UserDTO() {
    }

    public UserDTO(int user_id, String name, String phone_no, String role, int charity_id) {
        this.user_id = user_id;
        this.name = name;
        this.phone_no = phone_no;
        this.role = role;
        this.charity_id = charity_id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone_no() {
        return this.phone_no;
    }

    public String getRole() {
        return this.role;
    }

    public int getCharity_id() {
        return this.charity_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setcharity_id(int charity_id) {
        this.charity_id = charity_id;
    }

}
