package com.shortcuts;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * GetRecords class call this constructor passing HashMap of fileMenus
 */

public class PrepareGUI
{

    SystemTray st;
    PopupMenu pop;
    Menu file;
    Menu browser;
    MenuItem Manage=new MenuItem("Manage");
    MenuItem Exit=new MenuItem("Exit");
    HashMap<String,String> browserMenus;
    HashMap<String,String> fileMenus;

    public PrepareGUI(HashMap<String,String> fileMenus,HashMap<String,String> browserMenus)
    {
        pop=new PopupMenu();
        file = new Menu("File");
        browser = new Menu("Browser");

        Tray t=new Tray();

        if(t.checktraypresence())
        {
            st=SystemTray.getSystemTray();

            pop.add(file);
            pop.add(browser);
            pop.add(Exit);
            pop.add(Manage);

            if( ! fileMenus.isEmpty() || !browserMenus.isEmpty())
                addfiles(fileMenus,browserMenus);


            t.addicon(pop,st);

            // Add action listener for exit menu item
            Exit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });

            Manage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    new CRUD();
                }
            });

        }


    }

    /**
     * Creates new MenuItems dynamically and sets them a name fetched from Map and adds on the File Menu
     * @param fil
     */
    public void addfiles(HashMap<String,String> fil,HashMap<String,String> bMenus)
    {
        fileMenus=fil;
        browserMenus=bMenus;

        //File items
        for(Map.Entry<String,String> m : fil.entrySet())
        {
            file.add( new MenuItem(m.getKey()));

            System.out.println("File"+"" +m.getKey());
        }

        //Browser Items
        if( ! browserMenus.isEmpty())
        {
            for (Map.Entry<String, String> m : browserMenus.entrySet())
            {
                browser.add(new MenuItem(m.getKey()));

                System.out.println("Browser"+"" +m.getKey());
            }
        }


        int count=file.getItemCount();
        System.out.println(count);

        int browse=browserMenus.size();
        System.out.println("B"+" "+browse);


        // Add Action listener to every file menu item and calls getpath method passing name of a menu item clicked
        for(int i=0;i<count;i++)
        {
            file.getItem(i).addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String name=e.getActionCommand();
                    AWTDesktop.getpath(name,fileMenus);
                }
            });
        }


        // Add Action listener to every menu item and calls getpath method passing name of a menu item clicked
        for(int i=0;i<browse;i++)
        {
            browser.getItem(i).addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    String name=e.getActionCommand();
                    AWTDesktop.getlink(name,browserMenus);
                }
            });
        }


    }





}
