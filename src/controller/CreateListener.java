package controller;

import model.IFolio;
import model.IFolioTracker;
import view.CreateView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateListener implements ActionListener {

    IFolio iFolio;
    IFolioTracker iFolioTracker;
    CreateView createView;

    CreateListener (CreateView createView, IFolioTracker iFolioTracker)
    {
        this.iFolioTracker = iFolioTracker;
        this.createView = createView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createView.setFolioName();
        createView.create();
        iFolioTracker.createFolio(createView.getFolioName());
        createView.getAddButton().addActionListener(new AddListener(createView.getFolioName(), createView.getDftModel(), createView.getTsym(), createView.getTname(), createView.getNshares(), iFolioTracker));
    }
}
