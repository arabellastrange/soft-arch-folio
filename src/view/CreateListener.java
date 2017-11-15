package view;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateListener implements ActionListener {

    private JTabbedPane jtpStocks;
    private ImageIcon icon;

    CreateListener(JTabbedPane jtpStocks)
    {
        this.jtpStocks = jtpStocks;
        icon = new ImageIcon("img/close", "close");
        System.out.println(icon.getIconHeight() + icon.getDescription());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        create();
    }

    public void create()
    {
        //
        JLabel lsym = new JLabel("Ticker Symbol: ");
        JTextField tsym = new JTextField();
        tsym.setColumns(10);
        JLabel lname =  new JLabel("Share Name: ");
        JTextField tname = new JTextField();
        tname.setColumns(10);
        JLabel lshares = new JLabel("Number of Shares: ");
        JTextField nshares = new JTextField();
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

        String[] columnNames = {"Ticker Symbol", "Stock Name", "Number of Shares", "Price Per Share", "Value of Holding"};
        //Dummy row data
        String[][] rowData = new String[1][5];
        rowData[0][0] = "";
        rowData[0][1] = "";
        rowData[0][2] = "";
        rowData[0][3] = "";
        rowData[0][4] = "";

        JTable tableStocks = new JTable(rowData, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //needs to be filled with stocks
        tableStocks.addMouseListener(new RightClickRow(tableStocks));
        JTableHeader tableHeader = tableStocks.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        JPanel panTable = new JPanel();
        panTable.setLayout(new BoxLayout(panTable, BoxLayout.PAGE_AXIS));
        panTable.add(tableHeader);
        panTable.add(tableStocks);

        JScrollPane jspTable = new JScrollPane(panTable);

        JButton bClose = new JButton("Close");
        JButton bDelete = new JButton("Delete");
        JPanel panButton = new JPanel();
        panButton.add(bClose, BorderLayout.WEST);
        panButton.add(bDelete, BorderLayout.EAST);

        JPanel panAll = new JPanel();
        panAll.add(panInput);
        panAll.add(panTable);
        panAll.add(panButton);
        panAll.setLayout(new BoxLayout(panAll, BoxLayout.PAGE_AXIS));

        jtpStocks.addTab("Folio Name", icon, panAll);

    }
}
