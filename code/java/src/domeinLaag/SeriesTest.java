package domeinLaag;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {
    main.domeinLaag.Series series;
    main.domeinLaag.Chapter chapter;
    main.domeinLaag.Guest guest;
    main.domeinLaag.Admin admin;
    main.domeinLaag.User user;

    @BeforeEach
    public void initialize(){
        try{
            series = new main.domeinLaag.Series("Test", "This is a test");
            chapter = new main.domeinLaag.Chapter("Chapter-name", 1, "Test");
            guest = new main.domeinLaag.Guest("Guest");
            admin = new main.domeinLaag.Admin("Admin", "password");
            user = new main.domeinLaag.User("User", "password");
        } catch (Exception e){
            String errorMessage = "Exception: " + e.getMessage();
            System.out.println(errorMessage);
        }
    }
}