package com.lab9;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class MainFrame extends JFrame {

    DrawingPanel canvas;

    public MainFrame() throws IOException, SQLException {

        super("World Map");
        this.setIconImage(ImageIO.read(new File("src/main/resources/map.jpg")));
        init();
    }

    private void init() throws SQLException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        add(canvas, SwingConstants.CENTER);

        pack();
    }
}
