package controller;

import model.IFolio;
import model.IFolioTracker;
import model.IStock;
import view.FolioView;

public class Controller {

    private FolioView folioView;

    private IFolio iFolio;
    private IFolioTracker iFolioTracker;
    private IStock iStock;

    private CreateListener lCreate;

    public Controller(FolioView folioView)
    {
        this.folioView = folioView;

        //Listeners
        lCreate = new CreateListener(folioView.getjtpStocks());
    }

    public void create()
    {
        folioView.getmiCreate().addActionListener(lCreate);
    }

}
