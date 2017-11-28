package view;

import controller.CreateFolioListener;
import model.IFolio;
import model.IFolioTracker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class FolioTrackerView implements Observer {

    private JTabbedPane jtpStocks;
    private JMenuItem miCreate;
    private JMenuItem miExit;
    private JMenuItem miOpen;
    private JMenuItem miSave;
    private JFrame frMain;

    private IFolioTracker folioTracker;

    private Map<String, FolioView> nameToFolioView;

    public FolioTrackerView(IFolioTracker iFolioTracker) {
        folioTracker = iFolioTracker;
        folioTracker.registerObserver(this);
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
        miCreate.addActionListener(new CreateFolioListener(this, folioTracker));
        miOpen = new JMenuItem("Open...");
        miSave = new JMenuItem("Save...");
        miExit = new JMenuItem("Exit");
        miExit.addActionListener(e -> System.exit(0));

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
        frMain.setSize(900, 300);
        //frMain.setLayout();
        frMain.setLocationRelativeTo(null);
        frMain.setJMenuBar(mb);
        frMain.add(panTab);
        frMain.setVisible(true);

        nameToFolioView = new HashMap<>();
    }

    public JMenuItem getmiCreate() {
        return miCreate;
    }

    public String getFolioName() {
        String folioName = JOptionPane.showInputDialog("Enter folio name: ");
        if (folioName == null || folioName == "") throw new NullPointerException();
        return folioName;
    }

    public void createFolioView(String folioName, FolioView newFolioView) {
        jtpStocks.addTab(folioName, newFolioView.getPanAll());
        nameToFolioView.put(folioName, newFolioView);
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        removeAnyTabs();
        for (FolioView f : nameToFolioView.values()) {
            f.updateTableModel();
        }
    }

    private void removeAnyTabs() {
        ArrayList<String> toBeDeleted = new ArrayList<>();
        nameToFolioView
                .keySet()
                .forEach(key -> {
                    boolean r = false;
                    for (IFolio f : folioTracker.getFolios()) {
                        if (f.getName().equals(key)) {
                            r = true;
                            break;
                        }
                    }
                    if (!r) {
                        toBeDeleted.add(key);
                        jtpStocks.remove(jtpStocks.getSelectedComponent());
                    }
                });

        toBeDeleted.forEach(key -> nameToFolioView.remove(key));
    }

    public Component getfrMain() {
        return null;
    }
}
