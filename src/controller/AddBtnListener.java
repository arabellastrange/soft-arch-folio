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

        Component[] components = tabbedPane.getComponents();
        for(int i = 0; i < components.length; i++)
        {
            System.out.println(components[i]);
        }
    }
}
