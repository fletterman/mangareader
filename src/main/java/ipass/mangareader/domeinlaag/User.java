package ipass.mangareader.domeinlaag;

import java.util.HashSet;

public class User extends Guest{
    private String password;
    private static HashSet<User> allUsers = new HashSet<>();

    public User(String name, String password){
        super(name);
        this.password = password;
        allUsers.add(this);
    }

    public String givePassword(){
        return password;
    }

    public User createUser(String name, String password){
        return new User(name, password);
    }

    @Override
    public String toString(){
        return "User [name=" + super.getName() + ", password=" + password + "]";
    }
}
