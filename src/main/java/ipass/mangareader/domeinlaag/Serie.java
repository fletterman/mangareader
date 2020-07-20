package ipass.mangareader.domeinlaag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class Serie implements Serializable {
    private String name;
    private String summary;
    private int seriesID;
    private boolean favorite = false;
    private static HashSet<Serie> allSeries = new HashSet<Serie>();
    private TreeMap<String, Chapter> allChapters = new TreeMap<>();

    private static Serie mySerie = new Serie();

    public Serie(String name, String summary, int seriesID){
        this.name = name;
        this.summary = summary;
        this.seriesID = seriesID;
        allSeries.add(this);
    }

    private Serie(){};

    public static void setSerie(Serie serie) {
        mySerie = serie;
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
//        System.out.println(requestedSerie);
        return requestedSerie;
    }

    public TreeMap<String, Chapter> getAllChapters() {
        return allChapters;
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
        Serie newSerie = new Serie(name, summary, seriesID);
        return newSerie;
    }

    public void addChapter(Chapter chapter){
        allChapters.put(chapter.giveName(), chapter);
    }

    @Override
    public String toString(){
        return "Series [name=" + name + ", summary=" + summary + "]";
    }
}
