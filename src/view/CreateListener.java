package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateListener implements ActionListener {

    private JTabbedPane jtpStocks;

    CreateListener(JTabbedPane jtpStocks)
    {
        this.jtpStocks = jtpStocks;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        create();
    }

    public void create()
    {
        //
        JTextField tsym = new JTextField("Ticker Symbol: ");
        JTextField nshares = new JTextField("Number of Shares: ");

        JPanel panInput = new JPanel();
        panInput.add(tsym, BorderLayout.WEST);
        panInput.add(nshares, BorderLayout.EAST);

        String[] columnNames = {"Ticker Symbol", "Stock Name", "Number of Shares", "Price Per Share", "Value of Holding"};
        //Dummy row data
        String[][] rowData = new String[1][5];
        rowData[0][0] = "";
        rowData[0][1] = "";
        rowData[0][2] = "";
        rowData[0][3] = "";
        rowData[0][4] = "";
        JTable tableStocks = new JTable(rowData, columnNames); //needs to be filled with stocks
        tableStocks.addMouseListener(new RightClickRow(tableStocks));
        JPanel panTable = new JPanel();
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

        jtpStocks.add(panAll);

    }
}
