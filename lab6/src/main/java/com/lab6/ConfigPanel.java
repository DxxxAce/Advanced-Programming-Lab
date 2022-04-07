package com.lab6;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JSpinner rowSpinner, colSpinner;
    JButton createBtn;
    int rows, cols;

    public ConfigPanel(MainFrame frame) {

        this.frame = frame;
        init();
    }

    public void setRows() {

        this.rows = (Integer)rowSpinner.getValue();
    }

    public void setCols() {

        this.cols = (Integer)colSpinner.getValue();;
    }

    public int getRows() {

        return rows;
    }

    public int getCols() {

        return cols;
    }

    private void init() {

        //create the label and the spinner
        label = new JLabel("Grid size:");
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 15, 1));
        colSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 15, 1));
        createBtn = new JButton("Create");

        createBtn.addActionListener(this::createGame);

        //create spinners for rows and cols, and the button
        add(label); //JPanel uses FlowLayout by default
        add(rowSpinner);
        add(colSpinner);
        add(createBtn);
    }

    private void createGame(ActionEvent e) {

        setRows();
        setCols();

        frame.remove(frame.canvas);
        frame.canvas = new DrawingPanel(frame);
        frame.add(frame.canvas);
        frame.revalidate();
        frame.canvas.repaint();
    }
}
