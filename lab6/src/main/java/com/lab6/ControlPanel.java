package com.lab6;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {

    final MainFrame frame;

    JButton loadBtn;
    JButton saveBtn;
    JButton exitBtn;

    int saveRows, saveCols;

    public ControlPanel(MainFrame frame) {

        this.frame = frame;
        init();
    }
    private void init() {

        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));

        loadBtn = new JButton("Load");
        saveBtn = new JButton("Save");
        exitBtn = new JButton("Exit");

        //add all buttons
        add(loadBtn);
        add(saveBtn);
        add(exitBtn);

        //configure listeners for all buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        exitBtn.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent e) {

        try {

            BufferedImage image = ImageIO.read(new File("game_save.png"));

            frame.configPanel.setRows(saveRows);
            frame.configPanel.setCols(saveCols);

            frame.remove(frame.canvas);
            frame.canvas = new DrawingPanel(frame);
            frame.add(frame.canvas);
            frame.canvas.image = image;
            frame.revalidate();
            frame.canvas.repaint();
        }
        catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    private void saveGame(ActionEvent e) {

        BufferedImage image = new BufferedImage(frame.canvas.getWidth(), frame.canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        frame.canvas.printAll(g);
        g.dispose();

        try {

            ImageIO.write(image, "png", new File("game_save.png"));

            saveRows = frame.configPanel.getRows();
            saveCols = frame.configPanel.getCols();
        }
        catch (IOException ex) {

            ex.printStackTrace();
        }
    }

    private void exitGame(ActionEvent e) {

        frame.dispose();
    }
}
