package ipass.mangareader.domeinlaag;

import java.util.ArrayList;
import java.util.HashSet;

public class Admin {
    private String name;
    private String password;
    private static ArrayList<Admin> allAdmins = new ArrayList<Admin>();

    public Admin(String name, String password){
        this.name = name;
        this.password = password;
        allAdmins.add(this);
    }

    public String giveName(){
        return name;
    }

    public String givePassword(){
        return password;
    }

    public static ArrayList<Admin> getAllAdmins() {
        return allAdmins;
    }

    public Admin createAdmin(String name, String password){
        Admin admin = new Admin(name, password);
        return admin;
    }

    @Override
    public String toString(){
        return "Admin [name=" + name + ", password=" + password + "]";
    }
}
