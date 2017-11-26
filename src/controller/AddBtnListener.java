package controller;

import model.IFolio;
import model.IFolioTracker;
import model.NegativeSharesException;
import model.NegativeSharesException;
import model.web.NoSuchTickerException;
import model.web.WebsiteDataException;

import javax.naming.InvalidNameException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBtnListener implements ActionListener {

    private IFolioTracker f;
    private IFolio s;

    JTabbedPane tabbedPane;

    DefaultTableModel tableModel;

    public AddBtnListener(JTabbedPane tabbedPane, IFolioTracker f) {
        this.tabbedPane = tabbedPane;
        this.f = f;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String title = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());

        s = f.getFolioByName(title);

        JPanel allPan = null;

        //Retrieve first panel from tab
        Component[] components = tabbedPane.getComponents();
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JPanel) {
                allPan = (JPanel) components[i];
                System.out.println("jpanel found!");
            }
        }

        //Retrieve internal panels?
        JPanel[] internalPanels = new JPanel[3];
        int j = 0;
        Component[] internalComps = allPan.getComponents();
        for (int i = 0; i < internalComps.length; i++) {
            if (internalComps[i] instanceof JPanel) {
                internalPanels[j] = (JPanel) internalComps[i];
                j++;
            }
        }

        JPanel inputPan = internalPanels[0];
        JPanel tablePan = internalPanels[1];

        //TextFields of the input panel
        Component[] inputComps = inputPan.getComponents();
        JTextField[] textFields = new JTextField[3];
        JFormattedTextField numField = null;
        int a = 0;
        for (int i = 0; i < inputComps.length; i++) {
            if (inputComps[i] instanceof JTextField) {
                textFields[a] = (JTextField) inputComps[i];
                a++;
            }
            if (inputComps[i] instanceof JFormattedTextField) {
                numField = (JFormattedTextField) inputComps[i];
            }
        }

        JTextField tickField = textFields[0];
        JTextField nameField = textFields[1];

        //JTable from table panel
        Component[] tpComps = tablePan.getComponents();
        JTable thisTable = null;
        for (int i = 0; i < tpComps.length; i++) {
            if (tpComps[i] instanceof JTable) {
                System.out.println("JTABLE FOUND");
                thisTable = (JTable) tpComps[i];
            }
        }

        tableModel = (DefaultTableModel) thisTable.getModel();

        System.out.println(tpComps.length);

        if (alreadyExists(tickField.getText())) {
            thisTable.setValueAt(getPrevShares(tickField.getText()) + Integer.valueOf(numField.getValue().toString()), getRow(tickField.getText()), 2);
        } else {
            addStock(tickField.getText(), nameField.getText(), Integer.valueOf(numField.getValue().toString()));
            Object[] newRow = new Object[]{tickField.getText(), nameField.getText(), numField.getValue().toString(), "def", "def"};
            tableModel.addRow(newRow);
        }
    }


    public boolean alreadyExists(String ticker) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equals(ticker)) {
                return true;
            }
        }
        return false;
    }

    public int getRow(String ticker) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equals(ticker)) {
                return i;
            }
        }
        return -1;
    }

    public int getPrevShares(String ticker) {
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).toString().equals(ticker)) {
                return Integer.valueOf(tableModel.getValueAt(i, 2).toString().replaceAll(",", ""));
            }
        }
        return -1;
    }

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