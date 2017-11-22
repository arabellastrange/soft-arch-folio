package view;

import controller.CreateController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CreateListener implements ActionListener {

    private JTabbedPane jtpStocks;
    private ImageIcon icon;
    private DefaultTableModel model;
    private String folioName;
    private CreateController c;

    CreateListener(JTabbedPane jtpStocks)
    {
        this.jtpStocks = jtpStocks;
        icon = new ImageIcon("img/close.png", "close");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getFolioName();
        create();
    }

    public void create()
    {
        JLabel lsym = new JLabel("Ticker Symbol: ");
        JTextField tsym = new JTextField();
        tsym.setColumns(10);
        JLabel lname =  new JLabel("Share Name: ");
        JTextField tname = new JTextField();
        tname.setColumns(10);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(0);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setAllowsInvalid(true);

        JLabel lshares = new JLabel("Number of Shares: ");
        JFormattedTextField nshares = new JFormattedTextField(formatter);
        nshares.setColumns(10);
        JButton addButton = new JButton("Add");


        JPanel panInput = new JPanel();

        panInput.add(addButton, FlowLayout.LEFT);
        panInput.add(nshares, FlowLayout.LEFT);
        panInput.add(lshares, FlowLayout.LEFT);
        panInput.add(tname, FlowLayout.LEFT);
        panInput.add(lname, FlowLayout.LEFT);
        panInput.add(tsym, FlowLayout.LEFT);
        panInput.add(lsym, FlowLayout.LEFT);

        model = new DefaultTableModel();
        model.addColumn("Ticker Symbol");
        model.addColumn( "Stock Name");
        model.addColumn("Number of Shares");
        model.addColumn("Price Per Share");
        model.addColumn("Value of Holding");

        JTable tableStocks = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //needs to be filled with stocks
        tableStocks.addMouseListener(new RightClickRow(tableStocks));
        JTableHeader tableHeader = tableStocks.getTableHeader();
        tableHeader.setReorderingAllowed(false);

        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(alreadyExists(tsym.getText())){
                   model.setValueAt(getPrevShares(tsym.getText()) + Integer.valueOf(nshares.getValue().toString()), getRow(tsym.getText()), 2);
                }
                else {
                    c.addStock(tsym.getText(), tname.getText(), Integer.valueOf(nshares.getValue().toString()));
                    Object[] newRow = new Object[]{};
                    model.addRow(newRow);
                }

            }
        });

        TableRowSorter<TableModel> sortByValue =  new TableRowSorter<TableModel>(model);

        ArrayList<RowSorter.SortKey> sortKeys =  new ArrayList<RowSorter.SortKey>();
        sortKeys.add(new RowSorter.SortKey(4, SortOrder.DESCENDING));
        sortByValue.setSortKeys(sortKeys);
        tableStocks.setRowSorter(sortByValue);



        JPanel panTable = new JPanel();
        panTable.setLayout(new BoxLayout(panTable, BoxLayout.PAGE_AXIS));
        panTable.add(tableHeader);
        panTable.add(tableStocks);

        JScrollPane jspTable = new JScrollPane(panTable);

        JButton bClose = new JButton("Close");
        JButton bDelete = new JButton("Delete");
        bDelete.addActionListener(new DeleteListener());
        JPanel panButton = new JPanel();
        panButton.add(bClose, BorderLayout.WEST);
        panButton.add(bDelete, BorderLayout.EAST);

        JPanel panAll = new JPanel();
        panAll.add(panInput);
        panAll.add(panTable);
        panAll.add(panButton);
        panAll.setLayout(new BoxLayout(panAll, BoxLayout.PAGE_AXIS));

        jtpStocks.addTab(folioName, icon, panAll);

    }

    public boolean alreadyExists(String ticker){
        for(int i = 0; i < model.getRowCount(); i ++){
            if(model.getValueAt(i,0).toString().equals(ticker)){
                return true;
            }
        }
        return false;
    }

    public int getRow(String ticker){
        for(int i = 0; i < model.getRowCount(); i ++){
            if(model.getValueAt(i,0).toString().equals(ticker)){
                return i;
            }
        }
        return -1;
    }

    public int getPrevShares(String ticker){
        for(int i = 0; i < model.getRowCount(); i ++){
            if(model.getValueAt(i,0).toString().equals(ticker)){
                return Integer.valueOf(model.getValueAt(i, 2).toString().replaceAll(",", ""));
            }
        }
        return -1;
    }

    public void getFolioName() {
        folioName = JOptionPane.showInputDialog("Enter folio name: ");
    }
}
