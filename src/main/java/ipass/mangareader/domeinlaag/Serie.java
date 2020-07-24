package ipass.mangareader.domeinlaag;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Serie {
    private String name;
    private String summary;
    private int seriesID;
    private boolean favorite = false;
    private static ArrayList<Serie> allSeries = new ArrayList<>();
    private static TreeMap<String, Chapter> allChapters = new TreeMap<>();

    public Serie(String name, String summary, int seriesID){
        this.name = name;
        this.summary = summary;
        this.seriesID = seriesID;
        if (allSeries.contains(this)){
        } else {
            allSeries.add(this);
        }
    }

    public static ArrayList<Serie> giveAllSeries(){
        ArrayList<Serie> allS = new ArrayList<>();
        for (Serie serie : allSeries){
            allS.add(serie);
        }
        return allS;
    }

    public static Serie getSeries(int seriesID){
        Serie requestedSerie = null;
        for (Serie serie : allSeries){
            if (serie.getSeriesID() == seriesID){
                requestedSerie = serie;
            }
        }
        return requestedSerie;
    }

    public static TreeMap<String, Chapter> getAllChapters() {
        return allChapters;
    }

    public static Chapter getChapter(int chapterID, int seriesID){
        Chapter chapter = null;
        ArrayList<Serie> allSeries = Serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if (seriesKey == seriesID) {
                TreeMap<String, Chapter> allChapters = entry.getAllChapters();
                for (Map.Entry<String, Chapter> eachChapter : allChapters.entrySet()) {
                    if (eachChapter.getValue().getChapterID() == chapterID) {
                        chapter = eachChapter.getValue();
                    }
                }
            }
        }
        return chapter;
    }

    public String getSeriesName(){
        return name;
    }

    public String getSeriesSummary(){
        return summary;
    }

    public void setSeriesID(int seriesID) {
        this.seriesID = seriesID;
    }

    public int getSeriesID() {
        return seriesID;
    }

    public void setFavorite(boolean favorite){
        this.favorite = favorite;
    }

    public boolean getFavorite(){
        return favorite;
    }

    public Serie createSeries(String name, String summary, int seriesID){
        return new Serie(name, summary, seriesID);
    }

    public void addChapter(Chapter chapter){
        allChapters.put(chapter.giveName(), chapter);
    }

    public boolean setCover(File cover){
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public static boolean deleteSerie(int seriesID){
        if (seriesID >= 0){
            return allSeries.remove(allSeries.indexOf(Serie.getSeries(seriesID))) != null;
        }
        return false;
    }

    public static void setAllSeries(ArrayList<Serie> allSeries) {
        Serie.allSeries = allSeries;
    }

    @Override
    public String toString(){
        return "Series [name=" + name + ", summary=" + summary + "]";
    }
}
