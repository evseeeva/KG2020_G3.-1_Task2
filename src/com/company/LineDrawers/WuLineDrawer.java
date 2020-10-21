package com.company.LineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class WuLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public WuLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int gradient = 255;
        if (Math.abs(dx) > Math.abs(dy)) {
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
            if (y2 > y1) {
                int d = 2 * dy - dx;
                for (int i = x1; i <= x2; i++) {
                    if (dx != 0) gradient = 255 * d / (2 * dx);
                    pd.drawPixel(x1, y1, new Color(255, 0, 0, 255 - Math.abs(gradient)));
                    if (d >= 0) {
                        pd.drawPixel(x1, y1 + 1, new Color(255, 0, 0, Math.abs(gradient)));
                        y1++;
                        x1++;
                        d += 2 * dy - 2 * dx;
                    } else {
                        pd.drawPixel(x1, y1 - 1, new Color(255, 0, 0, Math.abs(gradient)));
                        x1++;
                        d += 2 * dy;
                    }
                }
            } else if (y2 < y1) {
                int d = -2 * dy - dx;
                for (int i = x1; i <= x2; i++) {
                    if (dx != 0) gradient = 255 * d / (2 * dx);
                    pd.drawPixel(x1, y1, new Color(255, 0, 0, 255 - Math.abs(gradient)));
                    if (d >= 0) {
                        pd.drawPixel(x1, y1 - 1, new Color(255, 0, 0, Math.abs(gradient)));
                        y1--;
                        x1++;
                        d += -2 * dy - 2 * dx;
                    } else {
                        pd.drawPixel(x1, y1 + 1, new Color(255, 0, 0, Math.abs(gradient)));
                        x1++;
                        d -= 2 * dy;
                    }
                }
            } else if (y2 == y1) {
                for (int i = x1; i <= x2; i++) {
                    pd.drawPixel(x1, y1, Color.RED);
                    x1++;
                }
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
                if (x2 > x1) {
                    int d = 2 * dx - dy;
                    for (int i = y1; i <= y2; i++) {
                        if (dy != 0) gradient = 255 * d / (2 * dy);
                        pd.drawPixel(x1, y1, new Color(0, 0, 255, 255 - Math.abs(gradient)));
                        if (d >= 0) {
                            pd.drawPixel(x1 + 1, y1, new Color(0, 0, 255, Math.abs(gradient)));
                            y1++;
                            x1++;
                            d += 2 * dx - 2 * dy;
                        } else {
                            pd.drawPixel(x1 - 1, y1, new Color(0, 0, 255, Math.abs(gradient)));
                            y1++;
                            d += 2 * dx;
                        }

                    }
                } else if (x2 < x1) {
                    int d = -2 * dx - dy;
                    for (int i = y1; i <= y2; i++) {
                        if (dy != 0) gradient = 255 * d / (2 * dy);
                        pd.drawPixel(x1, y1, new Color(0, 0, 255, 255 - Math.abs(gradient)));
                        if (d >= 0) {
                            pd.drawPixel(x1 - 1, y1, new Color(0, 0, 255, Math.abs(gradient)));
                            y1++;
                            x1--;
                            d += -2 * dx - 2 * dy;
                        } else {
                            pd.drawPixel(x1 + 1, y1, new Color(0, 0, 255, Math.abs(gradient)));
                            y1++;
                            d -= 2 * dx;
                        }

                    }
                } else if (x2 == x1) {
                    for (int i = y1; i <= y2; i++) {
                        pd.drawPixel(x1, y1, Color.BLUE);
                        y1++;
                    }
                }
            }

        }

}

