package main.domeinlaag;

import java.util.HashSet;
import java.util.TreeMap;

public class Series {
    private String name;
    private String summary;
    private boolean favorite = false;
    private static HashSet<Series> allSeries = new HashSet<Series>();

    public Series(String name, String summary){
        this.name = name;
        this.summary = summary;
        TreeMap<String, Series> allSeries = new TreeMap<String, Series>();
    }

    public static TreeMap<String, Series> giveAllSeries(){
        TreeMap<String, Series> all = new TreeMap<String, Series>();
        for (Series series : allSeries){
            String name = series.name;
            all.put(name, series);
        }
        return all;
    }

    public String getSeriesName(){
        return name;
    }

    public String getSeriesSummary(){
        return summary;
    }

    public void setFavorite(boolean favorite){
        this.favorite = favorite;
    }

    public boolean getFavorite(){
        return favorite;
    }

    public Series createSeries(String name, String summary){
        Series newSeries = new Series(name, summary);
        allSeries.add(newSeries);
        return newSeries;
    }

    @Override
    public String toString(){
        return "Series [name=" + name + ", summary=" + summary + "]";
    }
}
