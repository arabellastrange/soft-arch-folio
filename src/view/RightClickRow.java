package view;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RightClickRow implements MouseListener {

    JTable tableStocks;

    RightClickRow(JTable tableStocks)
    {
        this.tableStocks = tableStocks;
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
            popup.add(new JMenuItem("something"));
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
