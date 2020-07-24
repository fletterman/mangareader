package ipass;

import ipass.mangareader.domeinlaag.Chapter;
import ipass.mangareader.domeinlaag.Page;
import ipass.mangareader.domeinlaag.Serie;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AppTest
{
    @Test
    public void testSeries(){
        Page page;
        Chapter chapter;
        Serie serie;

        new Serie("LV999", "Villager of LV999", 1);
        new Chapter("Searching for the phantom monster", 1, 0, 1);
        int id = 0;
        while (id < 28) {
            if(id != 21) {
                Page pageAdd = new Page(id, String.valueOf(id + 1), 0, 1);
                id += 1;
            }
            if (id == 22) {
                id+=1;
            } else {
                String pageNumber = String.valueOf(id + 1) + "-" + String.valueOf(id + 2);
                Page pageAdd = new Page(id, pageNumber, 0, 1);
                id += 1;
            }
        }
        new Serie("World Teacher", "Assassin died and reincarnated in another world", 0);
        new Chapter("Princess Riefel", 15, 0, 0);
        for (int i = 0; i < 26; i++) {
            new Page(i+28, String.valueOf(i+1), 0, 0);
        }

        new Serie("Kuitsume", "Swordsman restarting his life", 2);
        new Chapter("Reality is merciless!", 4, 2, 2);
        for (int i = 0; i < 26; i++) {
            new Page(i+53, String.valueOf(i+1), 2, 2);
        }
        ArrayList allSeries = Serie.giveAllSeries();
//        System.out.println(allSeries.size());
        boolean testSeries = allSeries.size() == 15;
        assertTrue(testSeries);
    }

    @Test
    public void testDelete(){
        Page page;
        Chapter chapter;
        Serie serie;

        new Serie("LV999", "Villager of LV999", 1);
        new Chapter("Searching for the phantom monster", 1, 0, 1);
        int id = 0;
        while (id < 28) {
            if(id != 21) {
                Page pageAdd = new Page(id, String.valueOf(id + 1), 0, 1);
                id += 1;
            }
            if (id == 22) {
                id+=1;
            } else {
                String pageNumber = String.valueOf(id + 1) + "-" + String.valueOf(id + 2);
                Page pageAdd = new Page(id, pageNumber, 0, 1);
                id += 1;
            }
        }
        new Serie("World Teacher", "Assassin died and reincarnated in another world", 0);
        new Chapter("Princess Riefel", 15, 0, 0);
        for (int i = 0; i < 26; i++) {
            new Page(i+28, String.valueOf(i+1), 0, 0);
        }

        new Serie("Kuitsume", "Swordsman restarting his life", 2);
        new Chapter("Reality is merciless!", 4, 2, 2);
        for (int i = 0; i < 26; i++) {
            new Page(i+53, String.valueOf(i+1), 2, 2);
        }
//        System.out.println(Serie.giveAllSeries());
        assertTrue(Serie.deleteSerie(1));
//        System.out.println(Serie.giveAllSeries());
    }

    @Test
    public void testEditSerie(){
        Page page;
        Chapter chapter;
        Serie serie;

        new Serie("LV999", "Villager of LV999", 1);
        new Chapter("Searching for the phantom monster", 1, 0, 1);
        int id = 0;
        while (id < 28) {
            if(id != 21) {
                Page pageAdd = new Page(id, String.valueOf(id + 1), 0, 1);
                id += 1;
            }
            if (id == 22) {
                id+=1;
            } else {
                String pageNumber = String.valueOf(id + 1) + "-" + String.valueOf(id + 2);
                Page pageAdd = new Page(id, pageNumber, 0, 1);
                id += 1;
            }
        }
        new Serie("World Teacher", "Assassin died and reincarnated in another world", 0);
        new Chapter("Princess Riefel", 15, 0, 0);
        for (int i = 0; i < 26; i++) {
            new Page(i+28, String.valueOf(i+1), 0, 0);
        }

        new Serie("Kuitsume", "Swordsman restarting his life", 2);
        new Chapter("Reality is merciless!", 4, 2, 2);
        for (int i = 0; i < 26; i++) {
            new Page(i+53, String.valueOf(i+1), 2, 2);
        }

        int seriesID = 1;
        String title = "Level 999";
        String summary = "test edit";
        ArrayList<Serie> allSeries = Serie.giveAllSeries();
        for (Serie entry : allSeries) {
            int seriesKey = entry.getSeriesID();
            if (seriesKey == seriesID) {
                entry.setName(title);
                entry.setSummary(summary);
            }
        }
        ArrayList<Serie> testSeries = Serie.giveAllSeries();
        for (Serie test : testSeries){
            if (seriesID == test.getSeriesID()){
                assertTrue(test.getSeriesName().equals("Level 999") && test.getSeriesSummary().equals("test edit"));
            }
        }
    }

    @Test
    public void createSerie(){
        new Serie("LV999", "Villager of LV999", 1);
        new Chapter("Searching for the phantom monster", 1, 0, 1);
        int id = 0;
        while (id < 28) {
            if(id != 21) {
                Page pageAdd = new Page(id, String.valueOf(id + 1), 0, 1);
                id += 1;
            }
            if (id == 22) {
                id+=1;
            } else {
                String pageNumber = String.valueOf(id + 1) + "-" + String.valueOf(id + 2);
                Page pageAdd = new Page(id, pageNumber, 0, 1);
                id += 1;
            }
        }
        new Serie("World Teacher", "Assassin died and reincarnated in another world", 0);
        new Chapter("Princess Riefel", 15, 0, 0);
        for (int i = 0; i < 26; i++) {
            new Page(i+28, String.valueOf(i+1), 0, 0);
        }

        new Serie("Kuitsume", "Swordsman restarting his life", 2);
        new Chapter("Reality is merciless!", 4, 2, 2);
        for (int i = 0; i < 26; i++) {
            new Page(i+53, String.valueOf(i+1), 2, 2);
        }

        new Serie("Test", "testing serie", 3);
//        System.out.println(Serie.giveAllSeries().size());
//        System.out.println(Serie.giveAllSeries());
        assertTrue(Serie.giveAllSeries().size() == 10);
    }

    @Test
    public void editChapter(){
        new Serie("LV999", "Villager of LV999", 1);
        new Chapter("Searching for the phantom monster", 1, 0, 1);
        int id = 0;
        while (id < 28) {
            if(id != 21) {
                Page pageAdd = new Page(id, String.valueOf(id + 1), 0, 1);
                id += 1;
            }
            if (id == 22) {
                id+=1;
            } else {
                String pageNumber = String.valueOf(id + 1) + "-" + String.valueOf(id + 2);
                Page pageAdd = new Page(id, pageNumber, 0, 1);
                id += 1;
            }
        }
        new Serie("World Teacher", "Assassin died and reincarnated in another world", 0);
        new Chapter("Princess Riefel", 15, 0, 0);
        for (int i = 0; i < 26; i++) {
            new Page(i+28, String.valueOf(i+1), 0, 0);
        }

        new Serie("Kuitsume", "Swordsman restarting his life", 2);
        new Chapter("Reality is merciless!", 4, 2, 2);
        for (int i = 0; i < 26; i++) {
            new Page(i+53, String.valueOf(i+1), 2, 2);
        }

        Chapter chapter = Serie.getChapter(0,0);
        chapter.setName("New title");
        assertTrue(Serie.getChapter(0,0).giveName().equals("New title"));
    }

    @Test
    public void deleteChapter(){
        for (Serie serie : Serie.giveAllSeries()){
            if (serie.getSeriesID() == 0){
//                System.out.println(serie.getAllChapters());
            }
        }
        assertTrue(Chapter.deleteChapter(0,0));
        for (Serie serie : Serie.giveAllSeries()){
            if (serie.getSeriesID() == 0){
//                System.out.println(serie.getAllChapters());
            }
        }
    }

    @Test
    public void newChapter(){
        for (Serie serie : Serie.giveAllSeries()){
            if (serie.getSeriesID() == 0){
//                System.out.println(serie.getAllChapters().size());
            }
        }
        new Chapter("test", 4, 4, 0);
        for (Serie serie : Serie.giveAllSeries()){
            if (serie.getSeriesID() == 0){
//                System.out.println(serie.getAllChapters().size() == 3);
                assertTrue(serie.getAllChapters().size() == 4);
            }
        }
        for (Serie serie : Serie.giveAllSeries()){
            if (serie.getSeriesID() == 0){
//                System.out.println(serie.getAllChapters().size());
            }
        }

    }
}
