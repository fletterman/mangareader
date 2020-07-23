package ipass.mangareader.domeinlaag;

import java.io.Serializable;
import java.util.ArrayList;

public class Chapter implements Serializable {
    private String name;
    private int number;
    private int seriesID;
    private int chapterID;
    private boolean hasPrevious;
    private ArrayList<String> pages = new ArrayList<String>();
    private Serie serie;

    public Chapter(String name, int number, int chapterID, int seriesID){
        this.name = name;
        this.number = number;
        this.chapterID = chapterID;
        this.seriesID = seriesID;
        if (number != 1){
            this.hasPrevious = true;
        } else {
            this.hasPrevious = false;
        }

        ArrayList<Serie> allSeries = serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if (seriesKey == seriesID) {
                entry.addChapter(this);
//                System.out.println(this);
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSeriesID(int seriesID) {
        this.seriesID = seriesID;
    }

    public int getChapterID() {
        return chapterID;
    }

    public String giveName() {
        return name;
    }

    public int giveNumber(){
        return number;
    }

    public int giveSeriesID(){
        return seriesID;
    }

    public void addPage(String path){
        pages.add(path);
    }

    public ArrayList<String> getPages() {
        return pages;
    }

    @Override
    public String toString(){
        return "Chapter [name=" + name + ", number=" + number + "]";
    }
}
