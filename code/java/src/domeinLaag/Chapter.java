package main.domeinlaag;

public class Chapter {
    private String name;
    private int number;
    private String seriesName;

    public Chapter(String name, int number, String seriesName){
        this.name = name;
        this.number = number;
        this.seriesName = seriesName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String giveName() {
        return name;
    }

    public int giveNumber(){
        return number;
    }

    public String giveSeriesName(){
        return seriesName;
    }

    @Override
    public String toString(){
        return "Chapter [name=" + name + ", number=" + number + "]";
    }
}
