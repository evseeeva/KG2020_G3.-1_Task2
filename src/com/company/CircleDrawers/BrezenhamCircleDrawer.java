package com.company.CircleDrawers;

import com.company.PixelDrawers.PixelDrawer;

import java.awt.*;

public class BrezenhamCircleDrawer implements CircleDrawer {

    private PixelDrawer pd;
    public BrezenhamCircleDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
    @Override
    public void drawCircle(int x0, int y0, int r) {
        int x = 0;
        int y = r;
        int d = 3 - 2 * r;
        while (x <= y) {
            pd.drawPixel(x0 + x, y0 + y, Color.BLACK);
            pd.drawPixel(x0 + x, y0 - y, Color.BLACK);
            pd.drawPixel(x0 - x, y0 + y, Color.BLACK);
            pd.drawPixel(x0 - x, y0 - y, Color.BLACK);
            pd.drawPixel(x0 + y, y0 + x, Color.BLACK);
            pd.drawPixel(x0 + y, y0 - x, Color.BLACK);
            pd.drawPixel(x0 - y, y0 + x, Color.BLACK);
            pd.drawPixel(x0 - y, y0 - x, Color.BLACK);

            if(d<0) d+= 4*x+6;
             else{
                d+= 4*(x-y)+10;
                y--;
            }
            x++;
        }
    }
}
