package ipass.mangareader.domeinlaag;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class Admin implements Principal{
    private static List<Admin> allAdmins = new ArrayList<>();
    private String username, plainPassword, role;

    public static List<Admin> getAllAdmins() {
        return allAdmins;
    }

    public Admin(String username, String plainPassword){
        this.username = username;
        this.plainPassword = plainPassword;
        this.role = "admin";
        if(!allAdmins.contains(this)){
            allAdmins.add(this);
        }
    }

    @Override
    public String getName() {
        return username;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public String getRole() {
        return role;
    }

    public static Admin getUser(String username){
        for (Admin admin : allAdmins){
            if (admin.getName().equals(username)){
                return admin;
            }
        }
        return null;
    }

    public static String validateLogin(String username, String password){
        Admin found = getUser(username);
        if(found != null){
            return password.equals(found.plainPassword) ? found.getRole(): null;
        }
        return null;
    }
}
