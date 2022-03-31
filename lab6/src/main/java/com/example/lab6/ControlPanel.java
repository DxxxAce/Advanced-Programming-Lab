package com.example.lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {

    final MainFrame frame;

    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {

        this.frame = frame;
        init();
    }
    private void init() {

        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        //add all buttons TODO

        //configure listeners for all buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        exitBtn.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent e) {

        //TODO
    }

    private void saveGame(ActionEvent e) {

        //TODO
    }

    private void exitGame(ActionEvent e) {

        frame.dispose();
    }
}
