package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteShareListener implements ActionListener{

    DeleteShareListener()
    {
        //something
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        delDialogue();
    }

    private void delDialogue()
    {
        int dialogueButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this share?", "WARNING", dialogueButton);
        if(dialogueButton == JOptionPane.YES_OPTION)
        {
            //delete the row
        }
        else
        {
            //do not delete the row
        }
    }
}
