package com.lab6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;

    BufferedImage image; //the offscreen image
    Graphics2D offscreen; //the offscreen graphics

    public DrawingPanel(MainFrame frame) {

        this.frame = frame;
        createOffscreenImage();

        frame.configPanel.setRows();
        frame.configPanel.setCols();

        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        paintGrid();

        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void createOffscreenImage() {

        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    private void paintGrid() {

        offscreen.setColor(Color.DARK_GRAY);

        //horizontal lines
        for (int row = 0; row < rows; row++) {

            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        //vertical lines
        for (int col = 0; col < cols; col++) {

            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            offscreen.drawLine(x1, y1, x2, y2);
        }

        //intersections
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }

        drawSticks();
    }

    private void drawSticks() {

        Stroke stroke = new BasicStroke(5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND);
        offscreen.setStroke(stroke);
        offscreen.setColor(Color.BLACK);

        Random rand = new Random();

        for (int row = 0; row < rows - 1; row++) {

            int random = rand.nextInt(cols - 1);
            int x1 = padX + random * cellWidth;
            int y1 = padY + row * cellHeight;
            int x2 = x1 + cellWidth;
            int y2 = y1;

            offscreen.drawLine(x1, y1, x2, y2);
        }

        for (int col = 0; col < cols - 1; col++) {

            int random = rand.nextInt(rows - 1);
            int x1 = padX + col * cellWidth;
            int y1 = padY + random * cellHeight;
            int x2 = x1;
            int y2 = padY + cellHeight;

            offscreen.drawLine(x1, y1, x2, y2);
        }
    }

    private void drawStone(int x, int y) {

        //Draw a filled oval in the offscreen image TODO
        offscreen.setColor(Color.LIGHT_GRAY);
        offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
        offscreen.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
    }

    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {

        graphics.drawImage(image, 0, 0, this);
    }
}