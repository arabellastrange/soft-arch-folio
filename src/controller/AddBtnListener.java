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

        JPanel inputPan = internalPanels[0];
        JPanel tablePan = internalPanels[1];

        //TextFields of the input panel
        Component[] inputComps = inputPan.getComponents();
        JTextField[] textFields = new JTextField[3];
        JFormattedTextField noOfShares = null;
        int a = 0;
        for(int i = 0; i < inputComps.length; i++)
        {
            if(inputComps[i] instanceof JTextField)
            {
                textFields[a] = (JTextField) inputComps[i];
                a++;
            }
        }

        JTextField tickField = textFields[0];
        JTextField nameField = textFields[1];
        JTextField numField = textFields[2];

        //JTable from table panel
        Component[] tpComps = tablePan.getComponents();
        JTable thisTable = null;
        for (int i = 0; i < tpComps.length; i++)
        {
            if (tpComps[i] instanceof JTable)
            {
                System.out.println("JTABLE FOUND");
                thisTable = (JTable) tpComps[i];
            }
        }
        System.out.println(tpComps.length);


    }
}
