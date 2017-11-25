package controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBtnListener implements ActionListener {

    JTabbedPane tabbedPane;

    public AddBtnListener(JTabbedPane tabbedPane)
    {
        this.tabbedPane = tabbedPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JPanel allPan = null;

        //Retrieve first panel from tab
        Component[] components = tabbedPane.getComponents();
        for(int i = 0; i < components.length; i++)
        {
            if (components[i] instanceof JPanel)
            {
                allPan = (JPanel) components[i];
                System.out.println("jpanel found!");
            }
        }

        //Retrieve internal panels?
        JPanel[] internalPanels = new JPanel[3];
        int j = 0;
        Component[] internalComps = allPan.getComponents();
        for(int i = 0; i < internalComps.length; i++)
        {
            if (internalComps[i] instanceof JPanel)
            {
                internalPanels[j] = (JPanel) internalComps[i];
                j++;
            }
        }

        //Components of the internal panels
        for(int i = 0; i < internalPanels.length; i++)
        {
            Component[] panComps = internalPanels[i].getComponents();
            for(int k = 0; k < panComps.length; k++)
            {
                System.out.println(panComps[k]);
            }
            System.out.println("-----------------");
        }


    }
}
