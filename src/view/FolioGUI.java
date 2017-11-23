package view;

import model.IFolioTracker;

import javax.swing.*;
import java.awt.*;

public class FolioGUI {



    public FolioGUI(IFolioTracker folioTracker)
    {
        JFrame frMain = new JFrame();
        //Tabbed Pane
        JTabbedPane jtpStocks = new JTabbedPane();
        //Panel for tabbed pane
        JPanel panTab = new JPanel();
        panTab.add(jtpStocks);
        panTab.setLayout(new BoxLayout(panTab, BoxLayout.PAGE_AXIS));
        panTab.setBackground(Color.WHITE);

        //menu items
        JMenuItem miCreate = new JMenuItem("Create");
        miCreate.addActionListener(new CreateListener(jtpStocks, folioTracker));
        JMenuItem miOpen = new JMenuItem("Open...");
        miOpen.addActionListener(new OpenListener(frMain));
        JMenuItem miSave = new JMenuItem("Save...");
        miSave.addActionListener(new SaveListener(frMain));
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(new ExitListener(frMain));

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


}
