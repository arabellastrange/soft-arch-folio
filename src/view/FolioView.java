package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class FolioView implements Observer{

    JTabbedPane jtpStocks;

    JMenuItem miCreate;
    JMenuItem miExit;
    JMenuItem miOpen;
    JMenuItem miSave;
    JFrame frMain;

    public FolioView()
    {
        frMain = new JFrame();
        //Tabbed Pane
        jtpStocks = new JTabbedPane();
        //Panel for tabbed pane
        JPanel panTab = new JPanel();
        panTab.add(jtpStocks);
        panTab.setLayout(new BoxLayout(panTab, BoxLayout.PAGE_AXIS));
        panTab.setBackground(Color.WHITE);

        //menu items
        miCreate = new JMenuItem("Create");
        miOpen = new JMenuItem("Open...");
        miSave = new JMenuItem("Save...");
        miExit = new JMenuItem("Exit");

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

    public JMenuItem getmiExit() {
        return miExit;
    }

    public JMenuItem getMiOpen() {
        return miOpen;
    }

    public JMenuItem getMiSave() {
        return miSave;
    }

    public JTabbedPane getjtpStocks()
    {
        return jtpStocks;
    }

    public JFrame getfrMain()
    {
        return frMain;
    }


    @Override
    public void update(java.util.Observable o, Object arg) {
        
    }
}
