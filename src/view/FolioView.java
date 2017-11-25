package view;

import controller.CreateListener;
import controller.ExitListener;
import controller.OpenListener;
import controller.SaveListener;

import javax.swing.*;
import java.awt.*;

public class FolioView {

    JTabbedPane jtpStocks;

    JMenuItem miCreate;

    public FolioView()
    {
        JFrame frMain = new JFrame();
        //Tabbed Pane
        jtpStocks = new JTabbedPane();
        //Panel for tabbed pane
        JPanel panTab = new JPanel();
        panTab.add(jtpStocks);
        panTab.setLayout(new BoxLayout(panTab, BoxLayout.PAGE_AXIS));
        panTab.setBackground(Color.WHITE);

        //menu items
        miCreate = new JMenuItem("Create");
        JMenuItem miOpen = new JMenuItem("Open...");
        JMenuItem miSave = new JMenuItem("Save...");
        JMenuItem miExit = new JMenuItem("Exit");

        //menu for the menu items
        JMenu mFolio = new JMenu("Folio");
        mFolio.add(miCreate);
        mFolio.add(miOpen);
        mFolio.add(miSave);
        mFolio.add(miExit);

        //menu bar for the menu
        JMenuBar mb = new JMenuBar();
        mb.add(mFolio);

        //Set up the JFrame
        frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frMain.setSize(900,300);
        //frMain.setLayout();
        frMain.setLocationRelativeTo(null);
        frMain.setJMenuBar(mb);
        frMain.add(panTab);
        frMain.setVisible(true);
    }

    public JMenuItem getmiCreate()
    {
        return miCreate;
    }

    public JTabbedPane getjtpStocks()
    {
        return jtpStocks;
    }

}
