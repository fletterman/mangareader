package ipass.mangareader.domeinlaag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class Series {
    private String name;
    private String summary;
    private int seriesID;
    private boolean favorite = false;
    private static HashSet<Series> allSeries = new HashSet<Series>();
    private ArrayList<Chapter> allChapters = new ArrayList<Chapter>();

    public Series(String name, String summary, int seriesID){
        this.name = name;
        this.summary = summary;
        this.seriesID = seriesID;
        System.out.println(seriesID);
        allSeries.add(this);
    }

    public static TreeMap<Integer, Series> giveAllSeries(){
        TreeMap<Integer, Series> allS = new TreeMap<Integer, Series>();
        for (Series series : allSeries){
            int seriesID = series.seriesID;
//            System.out.println(series + " Testing");
            allS.put(seriesID, series);
//            System.out.println(allS);
        }
        return allS;
    }

    public ArrayList<Chapter> getAllChapters() {
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

    public Series createSeries(String name, String summary, int seriesID){
        Series newSeries = new Series(name, summary, seriesID);
        return newSeries;
    }

    public void addChapter(Chapter chapter){
        allChapters.add(chapter);
    }

    @Override
    public String toString(){
        return "Series [name=" + name + ", summary=" + summary + "]";
    }
}
