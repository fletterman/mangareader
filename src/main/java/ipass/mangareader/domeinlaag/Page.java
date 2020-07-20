package ipass.mangareader.domeinlaag;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Page implements Serializable {
    private int pageID;
    private String pageNumber;
    private int chapterID;
    private int seriesID;
    private Serie serie;

    public Page(int pageID, String pageNumber, int chapterID, int seriesID){
        this.pageID = pageID;
        this.pageNumber = pageNumber;
        this.chapterID = chapterID;
        this.seriesID = seriesID;
        String path = "images/" + seriesID + "/" + chapterID + "/" + pageNumber + ".png";
        ArrayList<Serie> allSeries = serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if(seriesKey==seriesID){
                TreeMap<String, Chapter> allChapters = entry.getAllChapters();
                for (Map.Entry<String, Chapter> chapter : allChapters.entrySet()){
                    if(chapter.getValue().getChapterID() == chapterID){
                        chapter.getValue().addPage(path);
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
