package ipass.mangareader.domeinlaag;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class Serie {
    private String name;
    private String summary;
    private int seriesID;
    private boolean favorite = false;
    private static HashSet<Serie> allSeries = new HashSet<>();
    private TreeMap<String, Chapter> allChapters = new TreeMap<>();

    public Serie(String name, String summary, int seriesID){
        this.name = name;
        this.summary = summary;
        this.seriesID = seriesID;
        allSeries.add(this);
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
        return new Serie(name, summary, seriesID);
    }

    public void addChapter(Chapter chapter){
        allChapters.put(chapter.giveName(), chapter);
    }

    public boolean setCover(File cover){
        return false;
    }

    @Override
    public String toString(){
        return "Series [name=" + name + ", summary=" + summary + "]";
    }
}
