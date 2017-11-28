import model.IFolioTracker;
import model.FolioTracker;
import view.FolioTrackerView;

public class FolioDriver {

    public static void main(String[] args) {
        IFolioTracker folioTracker = new FolioTracker();
        FolioTrackerView fV = new FolioTrackerView(folioTracker);
    }

}
