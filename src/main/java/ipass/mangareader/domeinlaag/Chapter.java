package ipass.mangareader.domeinlaag;

import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Chapter {
    private String name;
    private int number;
    private int seriesID;
    private final int chapterID;
    private final boolean hasPrevious;
    private boolean hasNext;
    private final ArrayList<String> pages = new ArrayList<String>();
    private Serie serie;

    public Chapter(String name, int number, int chapterID, int seriesID) {
        this.name = name;
        this.number = number;
        this.chapterID = chapterID;
        this.seriesID = seriesID;
        this.hasPrevious = number != 1;
        this.hasNext = false;
        if (number != 1) {
            TreeMap<String, Chapter> allChapters = Serie.getAllChapters();
            for (Map.Entry<String, Chapter> eachChapter : allChapters.entrySet()) {
                if (eachChapter.getValue().giveNumber() == number - 1) {
                    eachChapter.getValue().setHasNext(true);
                }
            }
        }
        ArrayList<Serie> allSeries = Serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if (seriesKey == seriesID) {
                entry.addChapter(this);
//                System.out.println(this);
            }
        }
    }

    public boolean hasPrevious() {
        return hasPrevious;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean hasNext() {
        return hasNext;
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

    public static boolean deleteChapter(int seriesID, int chapterID){
        if (seriesID >= 0){
            return Serie.getAllChapters().remove(Serie.getChapter(chapterID, seriesID).giveName()) != null;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Chapter [name=" + name + ", number=" + number + "]";
    }
}
