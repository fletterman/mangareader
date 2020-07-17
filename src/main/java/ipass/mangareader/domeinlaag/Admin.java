package ipass.mangareader.domeinlaag;

import java.util.ArrayList;
import java.util.HashSet;

public class Admin extends Guest{
    private String password;
    private static ArrayList<Admin> allAdmins = new ArrayList<>();

    public Admin(String name, String password){
        super(name);
        this.password = password;
        allAdmins.add(this);
    }

    public String giveName(){
        return super.getName();
    }

    public String givePassword(){
        return password;
    }

    public static ArrayList<Admin> getAllAdmins() {
        return allAdmins;
    }

    public Admin createAdmin(String name, String password){
        return new Admin(name, password);
    }

    @Override
    public String toString(){
        return "Admin [name=" + super.getName() + ", password=" + password + "]";
    }
}
