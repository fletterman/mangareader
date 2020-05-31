package ipass.mangareader.domeinlaag;

public class Guest {
    private String name = "Guest";

    public Guest (String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Guest [name=" + name + "]";
    }
}
