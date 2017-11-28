package controller;

import model.IFolio;
import model.IFolioTracker;
import view.FolioView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {

    private final IFolioTracker folioTracker;
    private final IFolio folio;
    private final FolioView folioView;

    public DeleteListener(FolioView folioView, IFolioTracker folioTracker, IFolio folio) {
        this.folioView = folioView;
        this.folioTracker = folioTracker;
        this.folio = folio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!folioView.getConfirmation("Are you sure you want to delete this folio?")) return;
        folioTracker.deleteFolio(folio);
    }

}
