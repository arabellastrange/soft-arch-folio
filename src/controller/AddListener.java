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

    AddListener(String title, DefaultTableModel dftModel, JTextField tickField, JTextField nameField, JFormattedTextField shareField, IFolioTracker f)
    {
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
            addStock(tickField.getText(), nameField.getText(), Integer.valueOf(shareField.getValue().toString()));
            Object[] newRow = new Object[]{tickField.getText(), nameField.getText(), shareField.getValue().toString(), "def", "def"};
            dftModel.addRow(newRow);
    }

//
//    public boolean alreadyExists(String ticker) {
//        for (int i = 0; i < dftModel.getRowCount(); i++) {
//            if (dftModel.getValueAt(i, 0).toString().equals(ticker)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int getRow(String ticker) {
//        for (int i = 0; i < dftModel.getRowCount(); i++) {
//            if (dftModel.getValueAt(i, 0).toString().equals(ticker)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public int getPrevShares(String ticker) {
//        for (int i = 0; i < dftModel.getRowCount(); i++) {
//            if (dftModel.getValueAt(i, 0).toString().equals(ticker)) {
//                return Integer.valueOf(dftModel.getValueAt(i, 2).toString().replaceAll(",", ""));
//            }
//        }
//        return -1;
//    }

    public String addStock(String ticker, String name, int nshares){
        try {
            s.createStock(ticker, name, nshares);
            return "successfully added stock";
        } catch (InvalidNameException e) {
            return "Invalid name exception";
        } catch (NegativeSharesException negativeShares) {
            return "Negative shares exception";
        } catch (NoSuchTickerException e) {
            return "No such ticker exception";
        } catch (WebsiteDataException e) {
            return "the website died";
        }
    }

}
