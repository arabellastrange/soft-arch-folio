package controller;

import model.IFolio;
import model.IFolioTracker;
import view.FolioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {

    private IFolioTracker f;
    private FolioView cv;
    private String folioName;

    public DeleteListener(FolioView cv, String folioName, IFolioTracker folioTracker) {
        this.cv = cv;
        f = folioTracker;
        this.folioName = folioName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!cv.getConfirmation("Are you sure you want to delete this folio?")) return;
        IFolio folio = f.getFolioByName(folioName);
        f.deleteFolio(folio);
    }

}
