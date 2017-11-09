package view;

import model.IFolioTracker;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class FolioTrackerGUI extends JFrame {

    public static void main(String[] args) {
        new FolioTrackerGUI();
    }

    public FolioTrackerGUI() {

        //Creates a new Toolkit object
        Toolkit tk = Toolkit.getDefaultToolkit();
        //Creates a new dimension - might use.
        Dimension dim = tk.getScreenSize();
        //Set the size of the frame
        this.setSize(400, 400);
        //Centres the application
        this.setLocationRelativeTo(null);
        //Exits on close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets the title for the JFrame
        this.setTitle("FolioTracker");

        //Creates a new JPanel
        JPanel panel = new JPanel();

        //Creates a new scroll bar that will appear as needed, adds it to the panel - may need to be moved or removed later
        JScrollPane scrollbar = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //Creates the 'Folio' menu bar
        JMenuBar menuBar = new JMenuBar();
        //Creates the 'Folio' menu
        JMenu menuFolio = new JMenu("Folio");
        //Creates the menu items
        JMenuItem mCreate = new JMenuItem("Create");
        JMenuItem mOpen = new JMenuItem("Open...");
        JMenuItem mSave = new JMenuItem("Save...");
        JMenuItem mExit = new JMenuItem("Exit");
        //Adds the menu items to the menu
        menuFolio.add(mCreate);
        menuFolio.add(mOpen);
        menuFolio.add(mSave);
        menuFolio.add(mExit);
        //Adds the menu to the menu bar
        menuBar.add(menuFolio);
        //Adds the menuBar to the panel
        panel.add(menuBar, SpringLayout.NORTH);

        //Creates a new tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        //Creates a default 'untitled' tab for when the program is first opened
        JPanel defaultPanel = new JPanel();
        tabbedPane.add("Untitled", defaultPanel);
        //Adds Tabbed Pane to the panel
        panel.add(tabbedPane, SpringLayout.VERTICAL_CENTER);

        //adds panel to frame
        this.add(panel);

        //Set the visibility of the frame
        this.setVisible(true);
    }

}

