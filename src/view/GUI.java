package view;

import javax.swing.*;
import java.awt.*;

public class GUI {



    private GUI()
    {
        JFrame frMain = new JFrame();
        //Tabbed Pane
        JTabbedPane jtpStocks = new JTabbedPane();
        //Panel for tabbed pane
        JPanel panTab = new JPanel();
        panTab.add(jtpStocks);

        //menu items
        JMenuItem miCreate = new JMenuItem("Create");
        miCreate.addActionListener(new CreateListener(jtpStocks));
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

        //Panel for menu bar
        JPanel panBar = new JPanel();
        panBar.add(mb, BorderLayout.WEST);


        //Set up the JFrame
        frMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frMain.setSize(500,500);
        frMain.setLocationRelativeTo(null);
        frMain.add(panBar, BorderLayout.PAGE_START);
        frMain.add(panTab, BorderLayout.PAGE_END);
        frMain.setVisible(true);
    }

    public static void main(String[] args) {

        GUI gui = new GUI();
        (new Thread(new GuiRunnable(gui))).start();

    }
}
