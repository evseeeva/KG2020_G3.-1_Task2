package com.company;

import com.company.CircleDrawers.BrezenhamCircleDrawer;
import com.company.CircleDrawers.CircleDrawer;
import com.company.CircleDrawers.WuCircleDrawer;
import com.company.LineDrawers.*;
import com.company.PixelDrawers.GraphicsPixelDrawer;
import com.company.PixelDrawers.PixelDrawer;
import utils.DrawUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;


public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point position = new Point(0,0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi= new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0,0,getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);
        PixelDrawer pd = new GraphicsPixelDrawer(bi_g);
        LineDrawer ld= new DDALineDrawer(pd);
        drawAll(ld);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
    }
    private void drawAll(LineDrawer ld){
        DrawUtils.drawSnowflake(ld, getWidth()/2-200, getHeight()/2-50, 100, 32, Color.black);
        ld.drawLine(getWidth()/2, getHeight()/2, position.x, position.y, Color.black);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
     public void mouseMoved(MouseEvent e) {
     position = new Point(e.getX(), e.getY());
     repaint();
    }
}
