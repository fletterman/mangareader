package ipass.setup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import ipass.mangareader.domeinlaag.*;

@WebListener
public class myservletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce){
        new Serie("LV999", "Villager of LV999", 1);
        new Chapter("Searching for the phantom monster", 1, 0, 1);
        int id = 0;
        while (id < 28) {
            if(id == 21) {
                String pageNumber = String.valueOf(id + 1) + "-" + String.valueOf(id + 2);
                Page pageAdd = new Page(id, pageNumber, 0, 1);
                id += 1;
            }
            if (id == 22) {
                id+=1;
            } else {
                Page pageAdd = new Page(id, String.valueOf(id + 1), 0, 1);
                id += 1;
            }
        }
        new Serie("World Teacher", "Assassin died and reincarnated in another world", 0);
        new Chapter("Princess Riefel", 1, 0, 0);
        for (int i = 0; i < 26; i++) {
            new Page(id+i, String.valueOf(i+1), 0, 0);
            id++;
        }
        new Chapter("My Prince", 2, 1, 0);
        for (int i = 0; i < 30; i++) {
            new Page(id+1, String.valueOf(i+1), 1, 0);
            id++;
        }

        new Serie("Kuitsume", "Swordsman restarting his life", 2);
        new Chapter("Reality is merciless!", 1, 0, 2);
        for (int i = 0; i < 26; i++) {
            new Page(id+i, String.valueOf(i+1), 1, 2);
            id++;
        }

        new Serie("Isekai Maou", "Transported to a game-world", 3);
        new Chapter("Interlude 1", 1, 1, 3);
        for (int i = 0; i < 18; i++) {
            new Page(id+i, String.valueOf(i+1), 1, 3);
            id++;
        }

        new Admin("stijn", "test");
    }
}
