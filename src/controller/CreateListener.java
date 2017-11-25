package controller;

import view.CreateView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateListener implements ActionListener {

    CreateView createView;

    CreateListener (CreateView createView)
    {
        this.createView = createView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createView.setFolioName();
        createView.create();
    }
}
