package controller;

import model.IFolioTracker;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RightClickRow implements MouseListener {

    private JTable tableStocks;
    private String ticker;
    private IFolioTracker folioTrack;
    private String fName;


    RightClickRow(JTable tableStocks, String ticker, IFolioTracker folioTrack, String fName)
    {
        this.tableStocks = tableStocks;
        this.ticker = ticker;
        this.folioTrack = folioTrack;
        this.fName = fName;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int row = tableStocks.rowAtPoint(e.getPoint());
        if (row >= 0 && row < tableStocks.getRowCount())
        {
            tableStocks.setRowSelectionInterval(row,row);
        }
        else
        {
            tableStocks.clearSelection();
        }

        int rowindex = tableStocks.getSelectedRow();
        if (rowindex < 0)
        {
            return;
        }
        if (e.isPopupTrigger() && e.getComponent() instanceof JTable)
        {
            JPopupMenu popup = new JPopupMenu("Something");
            JMenuItem edit  = new JMenuItem("edit share");
            JMenuItem delete = new JMenuItem("delete share");
            JMenuItem buy = new JMenuItem("buy");
            JMenuItem sell = new JMenuItem("sell");
            edit.addActionListener(new EditShareListener(tableStocks, rowindex, folioTrack, (String)tableStocks.getValueAt(rowindex,0), fName));
            delete.addActionListener(new DeleteShareListener(folioTrack, (String)tableStocks.getValueAt(rowindex,0), fName));
            buy.addActionListener(new BuyListener(folioTrack, fName, (String)tableStocks.getValueAt(rowindex,0)));
            sell.addActionListener(new SellListener(folioTrack, fName, (String)tableStocks.getValueAt(rowindex,0)));
            popup.add(edit);
            popup.add(delete);
            popup.add(buy);
            popup.add(sell);
            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
