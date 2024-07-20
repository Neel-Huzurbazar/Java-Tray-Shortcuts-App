package com.shortcuts;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class AWTDesktop
{
    static Desktop d=Desktop.getDesktop();

    /**
     *
     * @param name
     * @param fileMenus
     *
     * finds the corresponding path of a menu item of given string name
     */
    public static void getpath(String name, HashMap<String,String> fileMenus)
    {
        //Iterate over fileMenus

        for(Map.Entry<String,String> m : fileMenus.entrySet())
        {

            if(m.getKey().equals(name))
            {
                openwindow(m.getValue());
            }
        }


    }

    /**
     *
     * @param path
     *
     * Opens up the window
     */
    public static void openwindow(String path)
    {
        System.out.println(path);

        try
        {
            d.open(new File(path));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Path could not be found !");

        }

    }

    /**
     *
     * @param name
     * @param browserMenu
     *
     * Gets the link from browser menu and passes to openbroswer method
     */
    public   static void getlink(String name,HashMap<String,String> browserMenu)
    {

        //Iterate over browser menus

        for(Map.Entry<String,String> m : browserMenu.entrySet())
        {

            if(m.getKey().equals(name))
            {
                openbrowser(m.getValue());
            }
        }

    }

    /**
     *
     * @param value
     *
     * Opens url in browser
     */
    private static void openbrowser(String value)
    {
        System.out.println(value);
        try
        {
            d.browse(new URI(value));

        }
        catch ( Exception e)
        {
            JOptionPane.showMessageDialog(null,"Path could not be found");
        }

    }
}
