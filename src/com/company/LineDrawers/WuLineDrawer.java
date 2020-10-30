package com.company.LineDrawers;

import com.company.PixelDrawers.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        double gradient;
        if (Math.abs(dx) >= Math.abs(dy)) {
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
                dx = -dx;
                dy = -dy;
            }
            double y = y1;
            gradient = dy / dx;
            for (int x = x1; x <= x2; x++) {
                    pd.drawPixel(x, (int) y, new Color(color.getRed(), color.getGreen(), color.getBlue(), (float) (1 - (y - (int) y))));
                    pd.drawPixel(x, (int) y + 1, new Color(color.getRed(), color.getGreen(), color.getBlue(), (float) (y - (int) y)));
                    y += gradient;
            }

        } else if (Math.abs(dx) < Math.abs(dy)) {
            if (y1 > y2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
                dx = -dx;
                dy = -dy;
            }
            double x = x1;
            gradient = dx / dy;
            for (int y = y1; y <= y2; y++) {
                    pd.drawPixel((int) x, y, new Color(color.getRed(), color.getGreen(), color.getBlue(), (float) (1 - (x - (int) x))));
                    pd.drawPixel((int) x + 1, y, new Color(color.getRed(), color.getGreen(), color.getBlue(), (float) (x - (int) x)));
                    x += gradient;
            }
        }


    }

}

