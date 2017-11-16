package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditShareListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        editing();
    }

    public void editing(){
        JFrame editing = new JFrame("Edit");
        JPanel edit = new JPanel();
        JButton done = new JButton("Ok");
        edit.add(done);
        editing.add(edit);
        editing.setLayout(new BoxLayout(editing, BoxLayout.PAGE_AXIS));
        editing.setMinimumSize(new Dimension(300,200));
        editing.setVisible(true);
        editing.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }
}
