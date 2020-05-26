package domeinlaag;

import org.junit.jupiter.api.BeforeEach;

class SeriesTest {
    private main.domeinLaag.Series series;
    private main.domeinLaag.Chapter chapter;
    private main.domeinLaag.Guest guest;
    private main.domeinLaag.Admin admin;
    private main.domeinLaag.User user;

    @BeforeEach
    public void initialize(){
        try{
            seriesTest = new series("Test", "This is a test");
            chapterTest = new Main.domeinlaag.Chapter("Chapter-name", 1, "Test");
            guestTest = new Main.domeinlaag.Guest("Guest");
            admin = new Main.domeinlaag.Admin("Admin", "password");
            user = new Main.domeinlaag.User("User", "password");
            System.out.println(series);
        } catch (Exception e){
            String errorMessage = "Exception: " + e.getMessage();
            System.out.println(errorMessage);
        }
    }
}