package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddListener implements ActionListener {
    private JPanel inputPanel;

    public AddListener(JPanel input) {
        inputPanel = input;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addRow();
    }

    public void addRow(){

    }
}
