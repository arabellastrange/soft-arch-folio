package view;

import controller.BuyListener;
//import controller.EditShareListener;
import controller.SellListener;
import model.IFolio;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RightClickRow implements MouseListener {

    private JTable tableStocks;
    private IFolio folio;
    private final FolioView folioView;

    public RightClickRow(FolioView folioView, JTable tableStocks, IFolio folio) {
        this.folioView = folioView;
        this.tableStocks = tableStocks;
        this.folio = folio;
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
        if (row >= 0 && row < tableStocks.getRowCount()) {
            tableStocks.setRowSelectionInterval(row, row);
        } else {
            tableStocks.clearSelection();
        }

        int rowindex = tableStocks.getSelectedRow();
        if (rowindex < 0) {
            return;
        }
        if (e.getComponent() instanceof JTable) {
            JPopupMenu popup = new JPopupMenu("Something"); //fixme
            JMenuItem edit = new JMenuItem("Edit share");
            JMenuItem buy = new JMenuItem("Buy");
            JMenuItem sell = new JMenuItem("Sell");
//            edit.addActionListener(new EditShareListener(tableStocks, rowindex, folioTrack, (String) tableStocks.getValueAt(rowindex, 0), fName));
            buy.addActionListener(new BuyListener(folioView, folio, (String) tableStocks.getValueAt(rowindex, 0)));
            sell.addActionListener(new SellListener(folioView, folio, (String) tableStocks.getValueAt(rowindex, 0)));
            popup.add(edit);
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
