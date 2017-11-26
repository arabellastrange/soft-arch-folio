package controller;

import model.IFolio;
import model.IFolioTracker;
import model.IStock;
import view.FolioView;
import view.CreateView;

public class Controller {

    private FolioView folioView;
    private CreateView createView;

    private IFolio iFolio;
    private IFolioTracker iFolioTracker;
    private IStock iStock;

    private CreateListener createListener;
    private AddBtnListener addBtnListener;

    public Controller(FolioView folioView, IFolioTracker iFolioTracker)
    {
        this.iFolioTracker = iFolioTracker;
        this.folioView = folioView;
        createView = new CreateView(folioView.getjtpStocks());

        createListener = new CreateListener(createView, iFolioTracker);
        addBtnListener = new AddBtnListener(folioView.getjtpStocks(), iFolioTracker);
    }

    public void create()
    {
        folioView.getmiCreate().addActionListener(createListener);
        createView.getAddButton().addActionListener(addBtnListener);
    }

    public void addIt() {createView.getAddButton().addActionListener(addBtnListener);}


}
