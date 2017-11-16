package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteListener implements ActionListener {

    JTabbedPane jtp;

    DeleteListener()
    {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(areYouSure())
        {
            delete();
        }
    }

    private boolean areYouSure()
    {
        int dialogueButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this folio?","WARNING",dialogueButton);
        if(dialogueButton == JOptionPane.YES_OPTION)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void delete()
    {
        //do something
    }
}
