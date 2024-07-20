package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection
{
    public static Connection conn;

    static Connection getconnection()
    {
        /**
         * Returns connection to database
         */

         conn = null;
        try
        {
           // For jar testing using cmd as admin java -jar name.jar  . Use jdk 14   url=jdbc:sqlite:C:/Strings.db

            String url = "jdbc:sqlite:F:/Strings.db";           // F:/Strings.db
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");



        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return  conn;

    }




}
