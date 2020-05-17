package test;

import main.domeinLaag.Admin;
import main.domeinLaag.Chapter;
import main.domeinLaag.Guest;
import main.domeinLaag.Series;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {
    main.domeinLaag.Series series;
    main.domeinLaag.Chapter chapter;
    main.domeinLaag.Guest guest;
    main.domeinLaag.Admin admin;
    main.domeinLaag.User user;

    @BeforeEach
    public void initialize(){
        try{
            series = new Series("Test", "This is a test");
            chapter = new Chapter("Chapter-name", 1, "Test");
            guest = new Guest("Guest");
            admin = new Admin("Admin", "password");
            user = new main.domeinLaag.User("User", "password");
        } catch (Exception e){
            String errorMessage = "Exception: " + e.getMessage();
            System.out.println(errorMessage);
        }
    }
}
