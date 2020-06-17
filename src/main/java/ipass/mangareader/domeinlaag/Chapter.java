package ipass.mangareader.domeinlaag;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Chapter {
    private String name;
    private int number;
    private int seriesID;
    private int chapterID;
    private ArrayList<String> pages = new ArrayList<String>();
    private Series series;

    public Chapter(String name, int number, int chapterID, int seriesID){
        this.name = name;
        this.number = number;
        this.chapterID = chapterID;
        this.seriesID = seriesID;
        ArrayList<Series> allSeries = series.giveAllSeries();
        for (Series entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if (seriesKey == seriesID) {
                entry.addChapter(this);
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
