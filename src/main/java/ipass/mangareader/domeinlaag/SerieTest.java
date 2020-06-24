package ipass.mangareader.domeinlaag;

import org.junit.jupiter.api.BeforeEach;

class SerieTest {
    private Serie serie;
    private Chapter chapter;
    private Guest guest;
    private Admin admin;
    private User user;

    @BeforeEach
    public void initialize(){
        try{
            Serie serieTest = new Serie("Test", "This is a test", 0);
            Chapter chapterTest = new Chapter("Chapter-name", 1, 0, 1);
            Guest guestTest = new Guest("Guest");
            Admin admin = new Admin("Admin", "password");
            User user = new User("User", "password");
            System.out.println(serieTest);
        } catch (Exception e){
            String errorMessage = "Exception: " + e.getMessage();
            System.out.println(errorMessage);
        }
    }
}