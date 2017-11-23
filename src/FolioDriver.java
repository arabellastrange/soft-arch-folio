import model.FolioTracker;
import model.IFolioTracker;
import view.FolioGUI;

public class FolioDriver {

    public static void main(String[] args) {

        IFolioTracker folioTracker = new FolioTracker();
        FolioGUI folioGUI = new FolioGUI(folioTracker);


    }

}
