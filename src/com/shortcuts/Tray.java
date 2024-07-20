package com.shortcuts;

import java.awt.*;

public class Tray
{
    public static TrayIcon ti;
    static Image img;

    public boolean checktraypresence()
    {

        return  SystemTray.isSupported();
    }

    public void addicon(PopupMenu pop,SystemTray st)
    {
        img= Toolkit.getDefaultToolkit().getImage("C://Users//images.png");

        ti = new TrayIcon(img, "Shortcuts", pop);

        ti.setImageAutoSize(true);


        try
        {
            st.add(ti);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
