package com.shortcuts;


import database.DeleteRecord;
import database.GetRecords;
import database.InsertRecord;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Vector;

public class CRUD
{

    String t1;
    String t2;
    int state;
    String del;

    public CRUD()
    {
        JFrame frame=new JFrame("Settings");

        frame.setBounds(250,100,600,180);
        frame.setIconImage(Tray.img);

        Font f=new Font("Serif",Font.PLAIN,20);

        Vector<String> d=new Vector<>();

        JComboBox<String> list=new JComboBox<>(d);
        list.setBounds(310,40,200,20);
        list.setVisible(false);

        JLabel l3=new JLabel("Create");
        l3.setFont(f);
        l3.setBounds(50,20,100,40);

        JCheckBox c3=new JCheckBox();
        c3.setBounds(120,20,40,45);


        /////////////////////

        JLabel l5=new JLabel("Delete");
        l5.setFont(f);
        l5.setBounds(50,50,100,40);

        JCheckBox c5=new JCheckBox();
        c5.setBounds(120,50,40,45);


        /////////////////////

        JTextArea a=new JTextArea();
        a.setBounds(180,10,10,100);
        a.setBackground(Color.black);

        ///////////////////

        JLabel l6=new JLabel("Name");
        l6.setFont(f);
        l6.setBounds(250,35,50,20);

        JTextField tf=new JTextField();
        tf.setBounds(310,40,200,20);


        ///////////////////

        JLabel l7=new JLabel("Path");
        l7.setFont(f);
        l7.setBounds(250,60,50,20);

        JTextField t=new JTextField();
        t.setBounds(310,65,200,20);

        JButton b=new JButton("Save");
        b.setBounds(360,100,65,20);


        frame.add(l3);
        frame.add(c3);
        frame.add(list);
        frame.add(c5);
        frame.add(l5);
        frame.add(tf);
        frame.add(l6);
        frame.add(t);
        frame.add(l7);
        frame.add(b);
        frame.add(a);


        frame.setLayout(null);
        frame.setVisible(true);


        //Action listeners

        c5.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                state=e.getStateChange();

                if(state==1)
                {
                    l7.setVisible(false);
                    t.setVisible(false);
                    tf.setVisible(false);
                    b.setText("Delete");                                         //Adjust UI
                    b.setBounds(360,100,85,20);
                    list.setVisible(true);
                    l6.setText("Select ");
                    l6.setBounds(250,35,100,20);

                    //Add items to  Default list

                    for(Map.Entry<String,String> m : GetRecords.fileM.entrySet())
                    {
                        d.addElement(m.getKey());

                    }

                    for(Map.Entry<String,String> m : GetRecords.browserMenus.entrySet())
                    {
                        d.addElement(m.getKey());

                    }



                }
                else
                {
                    l7.setVisible(true);
                    t.setVisible(true);
                    b.setText("Save");                                    //Get original UI
                    b.setBounds(360,100,65,20);
                    list.setVisible(false);
                    l6.setText("Name");
                    tf.setVisible(true);
                    list.setVisible(false);
                }
            }
        });


        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                t1=tf.getText();
                t2=t.getText();

                if( !c3.isSelected() && !c5.isSelected())
                    JOptionPane.showMessageDialog(null,"Please select either of 2 choices");

                else if(c3.isSelected() && (t1!=null) &&( t2!=null))
                {
                    InsertRecord.insert(t1,t2);

                    frame.dispose();
                    SystemTray.getSystemTray().remove(Tray.ti);
                    /*
                            Remove earlier icon present
                            GetRecords.getrecords() add another icon

                     */
                    GetRecords.getrecords();  //Refresh the tray data


                }

                else if(c5.isSelected() && del!=null)
                {
                        System.out.println("del="+""+del);
                        DeleteRecord.delete(del);
                        frame.dispose();
                }

            }
        });

        list.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                del=list.getItemAt(list.getSelectedIndex()); //Get th selected String
            }
        });

    }


}
