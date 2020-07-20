package ipass.mangareader.domeinlaag;

import java.io.Serializable;
import java.util.HashSet;

public class User implements Serializable {
    private String name;
    private String password;
    private static HashSet<User> allUsers = new HashSet<User>();

    public User(String name, String password){
        this.name = name;
        this.password = password;
        allUsers.add(this);
    }

    public String giveName(){
        return name;
    }

    public String givePassword(){
        return password;
    }

    public User createUser(String name, String password){
        User user = new User(name, password);
        return user;
    }

    @Override
    public String toString(){
        return "User [name=" + name + ", password=" + password + "]";
    }
}
