package ipass.mangareader.domeinlaag;

import java.io.Serializable;

public class Guest implements Serializable {
    private String name = "Guest";
    private static String role = "guest";

    public Guest (String name){
        this.name = name;
    }

    public static String getRole() {
        return role;
    }

    @Override
    public String toString(){
        return "Guest [name=" + name + "]";
    }
}
