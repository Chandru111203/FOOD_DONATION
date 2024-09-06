package Util;

import Resources.LoginDTO;

public class Cookie {
    public static LoginDTO user;

    public static LoginDTO getUser() {
        return user;
    }

    public static void setUser(LoginDTO u) {
        user = u;
    }

}
