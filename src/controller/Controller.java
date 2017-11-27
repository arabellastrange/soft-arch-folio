package controller;

import model.IFolioTracker;
import model.IStock;
import view.FolioTrackerView;
import view.FolioView;

public class Controller {

    private FolioTrackerView folioTrackerView;
    private FolioView folioView;

    private IFolioTracker iFolioTracker;
    private IStock iStock;

    private CreateFolioListener createFolioListener;
    private ExitListener exitListener;
    private OpenListener openListener;
    private SaveListener saveListener;

    public Controller(FolioTrackerView folioTrackerView, IFolioTracker iFolioTracker)
    {
        this.iFolioTracker = iFolioTracker;
        this.folioTrackerView = folioTrackerView;
        iFolioTracker.registerObserver(folioView);

        exitListener = new ExitListener(folioTrackerView);
        openListener = new OpenListener(folioTrackerView);
        saveListener = new SaveListener(folioTrackerView);

    }

    public void create()
    {
        folioTrackerView.getmiCreate().addActionListener(createFolioListener);
    }

//    public void rightClick() {
//        folioView.getTable();
//    }
}
