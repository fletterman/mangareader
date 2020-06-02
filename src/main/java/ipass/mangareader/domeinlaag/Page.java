package ipass.mangareader.domeinlaag;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Page {
    private int pageID;
    private String pageNumber;
    private int chapterID;
    private int seriesID;
    private Series series;

    public Page(int pageID, String pageNumber, int chapterID, int seriesID){
        this.pageID = pageID;
        this.pageNumber = pageNumber;
        this.chapterID = chapterID;
        this.seriesID = seriesID;
        String path = "images/" + seriesID + "/" + chapterID + "/" + pageNumber + ".png";
        TreeMap<Integer, Series> allSeries = series.giveAllSeries();
        for (Map.Entry<Integer, Series> entry : allSeries.entrySet()) {
            Series serie = entry.getValue();
            int seriesKey = entry.getKey();
            if(seriesKey==seriesID){
                ArrayList<Chapter> allChapters = serie.getAllChapters();
                for (Chapter chapter : allChapters){
                    if(chapter.getChapterID() == chapterID){
                        chapter.addPage(path);
                    }
                }
            }
        }
    }

    public void setPageID(int pageID) {
        this.pageID = pageID;
    }

    public int getPageID() {
        return pageID;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }

    public int getChapterID() {
        return chapterID;
    }
}
