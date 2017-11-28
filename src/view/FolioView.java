package view;

import controller.AddStockListener;
import controller.DeleteListener;
import model.IFolio;
import model.IFolioTracker;
import model.IStock;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class FolioView implements Observer {

    private IFolio folio;

    private JTextField tsym;
    private JTextField tname;
    private JFormattedTextField nshares;
    private JTable tableStocks;
    private JPanel panAll;
    private JButton addButton;
    private JButton deleteButton;
    private DefaultTableModel dftModel;
    private IFolioTracker folioTracker;
    private JLabel totalValue;
    private double valueofFolio;

    public FolioView(IFolioTracker folioTracker, IFolio folio) {
        this.folio = folio;
        this.folioTracker = folioTracker;
        create();
    }

    private void create() {
        JLabel lsym = new JLabel("Ticker Symbol: ");
        tsym = new JTextField();
        tsym.setColumns(10);
        JLabel lname = new JLabel("Share Name: ");
        tname = new JTextField();
        tname.setColumns(10);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(true);

        JLabel lshares = new JLabel("Number of Shares: ");
        nshares = new JFormattedTextField(formatter);
        nshares.setColumns(10);
        addButton = new JButton("Add");
        addButton.addActionListener(new AddStockListener(this, folio));


        JPanel panInput = new JPanel();

        panInput.add(addButton, FlowLayout.LEFT);
        panInput.add(nshares, FlowLayout.LEFT);
        panInput.add(lshares, FlowLayout.LEFT);
        panInput.add(tname, FlowLayout.LEFT);
        panInput.add(lname, FlowLayout.LEFT);
        panInput.add(tsym, FlowLayout.LEFT);
        panInput.add(lsym, FlowLayout.LEFT);


        dftModel = new DefaultTableModel();
        dftModel.addColumn("Ticker Symbol");
        dftModel.addColumn("Stock Name");
        dftModel.addColumn("Number of Shares");
        dftModel.addColumn("Price Per Share");
        dftModel.addColumn("Value of Holding");
        dftModel.addColumn("Profit/Loss");

        tableStocks = new JTable(dftModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableStocks.addMouseListener(new RightClickRow(this, tableStocks, folio));

        JTableHeader tableHeader = tableStocks.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        TableRowSorter<TableModel> sortByValue = new TableRowSorter<TableModel>(dftModel);

        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.DESCENDING));
        sortByValue.setSortKeys(sortKeys);
        tableStocks.setRowSorter(sortByValue);

        JPanel panTable = new JPanel();
        panTable.setLayout(new BoxLayout(panTable, BoxLayout.PAGE_AXIS));
        panTable.add(tableHeader);
        panTable.add(tableStocks);

        JScrollPane jspTable = new JScrollPane(panTable);

        //JLabel for the total value
        totalValue = new JLabel("Total value: " + valueofFolio);

        //JButton bClose = new JButton("Close");
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteListener(this, folioTracker, folio));
        JPanel panButton = new JPanel();
        //panButton.add(bClose, BorderLayout.WEST);
        panButton.add(deleteButton, BorderLayout.CENTER);
        panButton.add(totalValue, BorderLayout.SOUTH);

        panAll = new JPanel();
        panAll.add(panInput);
        panAll.add(panTable);
        panAll.add(panButton);
        panAll.setLayout(new BoxLayout(panAll, BoxLayout.PAGE_AXIS));
    }

    public JPanel getPanAll() {
        return panAll;
    }

    @Override
    public void update(Observable o, Object arg) {
        nshares.setValue(0);
        updateTableModel();
        updateTotalValue();
    }

    public void updateTableModel() {
        for (int i = dftModel.getRowCount() - 1; i >= 0; i--) {
            dftModel.removeRow(i);
        }

        for (IStock s : folio.getStocks()) {
            Object[] row = new Object[6];
            row[0] = s.getTicker();
            row[1] = s.getName();
            row[2] = s.getShares();
            row[3] = s.getPricePerShare();
            row[4] = s.getHoldingValue();
            row[5] = s.lossProfit();
            dftModel.addRow(row);
        }
    }

    public void updateTotalValue()
    {
        valueofFolio = folio.getValue();
        totalValue.setText("Total value: " + valueofFolio);
    }

    public String getTicker() {
        return tsym.getText();
    }

    public String getStockName() {
        return tname.getText();
    }

    public int getNumberOfShares() {
        return (int) nshares.getValue();
    }

    public void alertErrorMsg(String msg) {
        JOptionPane.showMessageDialog(panAll, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public String inputAmount(String msg)
    {
        return JOptionPane.showInputDialog(msg);
    }

    public boolean getConfirmation(String s) {
        int dialogueButton = JOptionPane.YES_NO_OPTION;
        int r = JOptionPane.showConfirmDialog(null, s, "Warning", dialogueButton);
        if (r == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
