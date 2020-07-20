package ipass.mangareader.domeinlaag;

import java.io.Serializable;

public class Guest implements Serializable {
    private String name = "Guest";

    public Guest (String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Guest [name=" + name + "]";
    }
}
