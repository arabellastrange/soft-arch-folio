package controller;

import model.IFolioTracker;
import model.IStock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditShareListener implements ActionListener{

    private JTable tableStocks;
    private int rowindex;
    private IFolioTracker f;
    private IStock s;
    private String ticker;

    public EditShareListener(JTable tableStocks, int rowindex, IFolioTracker f, String ticker, String fName)
    {
        this.tableStocks = tableStocks;
        this.rowindex = rowindex;
        this.f = f;
        //use IFolioTracker to get folio name reference and make s = ticker name of stock referenced
        s = f.getFolioByName(fName).getStockByTicker(ticker);
        this.ticker = ticker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        editing();
    }


    private void editing(){

        GridLayout editLayout = new GridLayout(0, 2);

        String tsymbol = (String) tableStocks.getValueAt(rowindex, 0);
        String name = (String) tableStocks.getValueAt(rowindex, 1);
        String cvalue = tableStocks.getValueAt(rowindex, 3).toString();

        JLabel Lediting = new JLabel("Editing portfolio: ");
        JLabel Lfolio = new JLabel("Dummy folio text");
        JLabel Ltsymbol = new JLabel(tsymbol);
        JLabel Lname = new JLabel(name);
        JLabel Lcvalue = new JLabel("Current value: " + cvalue);
        JLabel Ldaych = new JLabel("Daily change: ");
        JLabel Lnos = new JLabel("Number of shares:");
        JLabel Lintval = new JLabel("Initial value:");
        JLabel Ltotgain = new JLabel("Total gain: ");
        JLabel Ltgainval = new JLabel("Dummy total gain");

        JTextField jtfNos = new JTextField();
        JTextField jtfIntVal = new JTextField();

        JFrame editing = new JFrame("Edit");
        JPanel edit = new JPanel();

        edit.setLayout(editLayout);

        JButton done = new JButton("Ok");
        JButton cancel = new JButton("Cancel");

        //Adding to the layout
        //Each spaced line indicates a new row

        edit.add(Lediting);
        edit.add(Lfolio);

        edit.add(Ltsymbol);
        edit.add(Lname);

        edit.add(Lcvalue);
        edit.add(Ldaych);

        edit.add(Lnos);
        edit.add(jtfNos);

        edit.add(Lintval);
        edit.add(jtfIntVal);

        edit.add(Ltotgain);
        edit.add(Ltgainval);

        edit.add(done);
        edit.add(cancel);

        editing.add(edit);
        editing.setMinimumSize(new Dimension(300,200));
        editing.setVisible(true);
        editing.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //add call to model data to edit stock
        //s.setName(name);
    }
}
