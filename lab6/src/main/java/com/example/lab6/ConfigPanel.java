package com.example.lab6;
import javax.swing.*;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    int rows, cols;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void setLabel(JLabel label) {

        this.label = label;
    }

    public void setSpinner(JSpinner spinner) {

        this.spinner = spinner;
    }

    public void setRows(int rows) {

        this.rows = rows;
    }

    public void setCols(int cols) {

        this.cols = cols;
    }

    public JLabel getLabel() {

        return label;
    }

    public JSpinner getSpinner() {

        return spinner;
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
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        //create spinners for rows and cols, and the button TODO



        add(label); //JPanel uses FlowLayout by default
        add(spinner);
    }
}
