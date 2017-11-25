import controller.*;
import view.FolioView;
import view.CreateView;

public class FolioDriver{

    public static void main(String[] args) {
        FolioView fV = new FolioView();
        Controller cv = new Controller(fV);
        cv.create();
//        cv.add();
    }

}
