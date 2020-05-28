package domeinlaag;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    public static void main(String args[]) {
        // try {
        //     Class.forName("com.mysql.jdbc.Driver");
        //     Connection conn = null;
        //     conn = DriverManager.getConnection("jdbc:mysql://localhost/mangareader", "root", "");
        //     System.out.print("Database is connected");
        //     conn.close();
        // } catch (Exception e) {
        //     //TODO: handle exception
        //     System.out.print("Couldn't connect to the DB. Error: "+e);
        // }

        String driverName = "org.gjt.mm.mysql.Driver";
        Class.forName(driverName);

        String serverName = "localhost";
        String mydatabase = "mangareader";
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

        String username = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected");
    }

    public static String chaptername(){
        return "Name of the chapter";
    }
}
