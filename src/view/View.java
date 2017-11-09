package view;

import model.IFolioTracker;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class View extends JPanel implements Observer {

    private IFolioTracker folioTracker;

    @Override
    public void update(Observable o, Object arg) {
       //repaint
    }
}
