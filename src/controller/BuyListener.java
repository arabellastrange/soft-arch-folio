package controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String buyShares = JOptionPane.showInputDialog("Enter the amount you would like to buy");
    }
}
