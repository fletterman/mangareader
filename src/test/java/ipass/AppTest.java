package ipass;

import ipass.mangareader.domeinlaag.Chapter;
import ipass.mangareader.domeinlaag.Page;
import ipass.mangareader.domeinlaag.Series;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class AppTest
{
    @BeforeEach
    public void initialize() {
        try {
            Page page;
            Chapter chapter;
            Series series;

            Series seriesAdd = new Series("LV999", "Villager of LV999", 1);
            Chapter chapterAdd = new Chapter("Searching for the phantom monster", 24, 0, 1);
            int id = 0;
            while (id < 28) {
                Page pageAdd = new Page(id, id+1, 0, 1);
                id += 1;
            }
            new Series("World Teacher", "Assassin died and reincarnated in another world", 0);
            new Chapter("Princess Riefel", 15, 1, 0);
            for (int i = 0; i < 27; i++) {
                new Page(i+28, i+1, 1, 0);
            }

            new Series("Kuitsume", "Swordsman restarting his life", 2);
            new Chapter("Reality is merciless!", 4, 2, 2);
            for (int i = 0; i < 26; i++) {
                new Page(i+53, i+1, 2, 2);
            }
        }catch(Exception e){
                String errorMessage = "Exception: " + e.getMessage();
                System.out.println(errorMessage);
        }
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testSeries(){
        TreeMap<Integer, Series> allSeries = new TreeMap<Integer, Series>();
        allSeries = Series.giveAllSeries();
        assertTrue(allSeries.size() == 3);
    }



}
