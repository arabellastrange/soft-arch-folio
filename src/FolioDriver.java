import controller.*;
import model.IFolio;
import model.IFolioTracker;
import model.FolioTracker;
import view.FolioView;
import view.CreateView;

public class FolioDriver{

    public static void main(String[] args) {
        IFolioTracker folioTracker = new FolioTracker();
        FolioView fV = new FolioView();
        Controller cv = new Controller(fV, folioTracker);
        cv.create();
        cv.exit();
    }

}
