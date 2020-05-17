package main.domeinLaag;

import java.util.HashSet;

public class Admin {
    private String name;
    private String password;
    private static HashSet<Admin> allAdmins = new HashSet<Admin>();

    public Admin(String name, String password){
        this.name = name;
        this.password = password;
        Admin.allAdmins.add(this);
    }

    public String giveName(){
        return name;
    }

    public String givePassword(){
        return password;
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
