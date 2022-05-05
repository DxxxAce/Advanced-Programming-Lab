package com.lab8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    Integer canvasWidth = 720, canvasHeight = 720;
    Integer stoneSize= 5;
    BufferedImage image;
    Graphics2D offscreen;

    public DrawingPanel(MainFrame frame) throws SQLException {

        this.frame = frame;
        createOffScreenImage();
        init();
    }

    void createOffScreenImage ()
    {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();

        try {

            offscreen.drawImage(ImageIO.read(new File("src/main/resources/map.jpg")),
                    0,0,canvasWidth,canvasHeight,frame);
        }
        catch (IOException e) {

            e.printStackTrace();
        }
    }

    void init() throws SQLException {

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        var cities= new CityDAO();

        for (City city : cities.findAll()) {

            float latitude = city.getLatitude();
            float longitude = city.getLongitude();

            double lat = Distance.toRadians(latitude);
            double mercator = Math.log(Math.tan((Math.PI / 4) + (lat / 2)));

            double x = (longitude+180)*(((double) canvasWidth)/360);
            double y = (((double)canvasHeight) / 2) - (canvasWidth * mercator / ( 2 * Math.PI));

            offscreen.setColor(Color.RED);
            offscreen.drawOval((int)(x - stoneSize), (int)(y - stoneSize), 5, 5);
            offscreen.setColor(Color.DARK_GRAY);
            offscreen.setFont(new Font(Font.SANS_SERIF, Font.BOLD,10));
            offscreen.drawString(city.getName(),(int)(x - stoneSize) + 10, (int)(y - stoneSize));
        }
    }

    @Override
    protected void paintComponent (Graphics graphics)
    {
        graphics.drawImage(image, 0, 0, this);
    }
}
