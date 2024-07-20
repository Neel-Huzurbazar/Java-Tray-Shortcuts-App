package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertRecord
{
    static Connection con;
    static PreparedStatement ps;
    static String sql;

    public static void insert(String name,String path)
    {
        con=DBConection.getconnection();
        sql="INSERT INTO shortcuts VALUES(?,?)";
        try
        {
            ps=con.prepareStatement(sql);

            ps.setString(1,name);
            ps.setString(2,path);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"Record Inserted!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
