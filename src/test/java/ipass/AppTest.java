package ipass;

import ipass.mangareader.domeinlaag.Admin;
import ipass.mangareader.domeinlaag.Chapter;
import ipass.mangareader.domeinlaag.Page;
import ipass.mangareader.domeinlaag.Serie;
import ipass.mangareader.persistentie.PersistentieManager;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AppTest
{
    @BeforeEach
    public void initialize() {
        try {
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
            Admin admin = new Admin("stijn", "test");

            try {
                PersistentieManager.loadSerieFromAzure();
                System.out.println("Serie loaded");
            } catch (Exception e){
                System.out.println("Cannot load serie");
                e.printStackTrace();
            }
        }catch(Exception e){
                String errorMessage = "Exception: " + e.getMessage();
                System.out.println(errorMessage);
        }
    }

    @Test
    public void userIsAdmin(){
        List<Admin> allAdmins = Admin.getAllAdmins();
        for (Admin admin : allAdmins){
            String role = admin.getRole();
            assertTrue(role.equals("admin"));
        }

    }

    @Test
    public void userHasPassword(){
        List<Admin> allAdmins = Admin.getAllAdmins();
        for (Admin admin : allAdmins){
            String password = admin.getPlainPassword();
            assertTrue(password.equals("test"));
        }
    }

    @Test
    public void usernameLongerThan4(){
        List<Admin> allAdmins = Admin.getAllAdmins();
        for (Admin admin : allAdmins){
            int length = admin.getName().length();
            assertTrue(length> 4);
        }
    }

    @Test
    public void passwordLongerThan4(){
        List<Admin> allAdmins = Admin.getAllAdmins();
        for (Admin admin : allAdmins){
            int length = admin.getPlainPassword().length();
            assertTrue(length> 4);
        }
    }

    @Test
    public void loginTest(){
        assertTrue(Admin.validateLogin("Stijn", "test").equals("admin"));
    }
}
