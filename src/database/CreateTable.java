package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable
{
    static  Connection con;
    static String sql;
    static Statement st;
    static boolean flag;

    /**
     * Creates a table
     */
    public static boolean createtable()
    {

        con=DBConection.getconnection();

        sql="create table if not exists shortcuts (Nam Varchar(40) Not null, Pathe Varchar(40) Not null)";

        try
        {
            st=con.createStatement();
            st.execute(sql);
            System.out.println("Table created!!");
            flag=true;
        }
        catch (SQLException s)
        {
            s.printStackTrace();
            System.out.println("Could not create table");
            flag=false;
        }

        return flag;

    }


}
