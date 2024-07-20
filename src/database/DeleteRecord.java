package database;

import com.shortcuts.Tray;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class DeleteRecord
{
    static Connection con;
    static  String sql;
    static PreparedStatement ps;
    static int i;

    public static void delete(String name)
    {

            sql="DELETE FROM shortcuts WHERE Nam=? ";
            con= DBConection.getconnection();

            try
            {
                ps=con.prepareStatement(sql);
                ps.setString(1, name);

                ps.executeUpdate();

                i=JOptionPane.showConfirmDialog(null,"Are you sure?","Warning",JOptionPane.YES_NO_OPTION);
                if(i==0)
                {
                    SystemTray.getSystemTray().remove(Tray.ti);
                    /*
                            Remove earlier icon present
                            GetRecords.getrecords() add another icon

                     */
                    JOptionPane.showMessageDialog(null,"Record Deleted Successfully!!");
                    GetRecords.getrecords();  //Refresh the tray data
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Could not delete!!");
            }
    }
}
