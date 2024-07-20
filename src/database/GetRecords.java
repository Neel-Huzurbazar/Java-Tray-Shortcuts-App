package database;

import com.shortcuts.PrepareGUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class GetRecords
{
    static Connection con;
    static String sql;
    static Statement st;
    static ResultSet rs;
    public static HashMap<String,String> fileM;
    public static HashMap<String,String> browserMenus;

    /**
     * Fetches records from the database ,adds in the hashmap and calls addfile method to add those in menus
     */

    public static void getrecords()
    {


        con=DBConection.getconnection();
        sql="SELECT * FROM shortcuts";

        try
        {
            fileM= new HashMap<>();
            browserMenus=new HashMap<>();
            st=con.createStatement();
            rs=st.executeQuery(sql);

            while (rs.next())
            {

                if( check(rs.getString(2)) )
                    browserMenus.put(rs.getString(1),rs.getString(2));
                else
                    fileM.put(rs.getString(1),rs.getString(2));
            }


        }
        catch (SQLException s)
        {
            s.printStackTrace();
        }


        new PrepareGUI(fileM,browserMenus);

    }

    private static boolean check(String string)
    {

        String []url ={ "www","https","http",".in",".com",".net",".us"};
        boolean flag = false;

        for (String s : url)
        {
            if (string.contains(s))
            {
                flag = true;
                break;
            }
        }

      return flag;
    }

}
