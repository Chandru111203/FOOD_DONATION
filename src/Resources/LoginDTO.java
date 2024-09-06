package Resources;

public class LoginDTO {
    private String email;
    private String password;
    private int userId;
    private String role;

    public LoginDTO() {
    }

    public LoginDTO(String email, String password, int userId, String role) {
        this.email = email;
        this.password = password;
        this.userId = userId;
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public int getUserId() {
        return this.userId;
    }

    public String getRole() {
        return this.role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
