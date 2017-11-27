package controller;

import model.IFolio;
import model.IFolioTracker;
import model.NegativeSharesException;
import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener {

    private String title;
    private DefaultTableModel dftModel;
    private JTextField tickField;
    private JTextField nameField;
    private JFormattedTextField shareField;
    private IFolioTracker f;
    private IFolio s;
    private JPanel panel;

    AddListener(JPanel panel, String title, DefaultTableModel dftModel, JTextField tickField, JTextField nameField, JFormattedTextField shareField, IFolioTracker f)
    {
        this.panel = panel;
        this.title = title;
        this.dftModel = dftModel;
        this.tickField = tickField;
        this.nameField = nameField;
        this.shareField = shareField;
        this.f = f;
        s = f.getFolioByName(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(addStock(tickField.getText(), nameField.getText(), Integer.valueOf(shareField.getValue().toString())).equals("successfully added stock")){
            Object[] newRow = new Object[]{tickField.getText(), nameField.getText(), shareField.getValue().toString(), s.getStockByTicker(tickField.getText().trim()).getPricePerShare(), s.getStockByTicker(tickField.getText().trim()).getHoldingValue()};
            dftModel.addRow(newRow);
        }
    }


    public String addStock(String ticker, String name, int nshares){
        try {
            s.createStock(ticker, name, nshares);
            return "successfully added stock";

        } catch (InvalidNameException e) {

            JOptionPane.showMessageDialog(panel,"Invalid name.", "Error", JOptionPane.ERROR_MESSAGE);
            return "invalid name";

        } catch (NegativeSharesException negativeShares) {

            JOptionPane.showMessageDialog(panel,"Cannot add negative shares.", "Error", JOptionPane.ERROR_MESSAGE);
            return "negative shares";

        } catch (NoSuchTickerException e) {

            JOptionPane.showMessageDialog(panel,"No such ticker with the name: " + ticker, "Error", JOptionPane.ERROR_MESSAGE);
            return "no such ticker";

        } catch (WebsiteDataException e) {

            JOptionPane.showMessageDialog(panel,"The website died.", "Error", JOptionPane.ERROR_MESSAGE);
            return "dead website";
            
        }
    }
}
