package com.company.LineDrawers;

import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;
    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
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
                    pd.drawPixel(x1, y1, Color.RED);
                    if (d >= 0) {
                        y1++;
                        x1++;
                        d += 2 * dy - 2 * dx;
                    } else {
                        x1++;
                        d += 2 * dy;
                    }
                }
            } else if (y2 < y1) {
                int d = -2 * dy - dx;
                for (int i = x1; i <= x2; i++) {
                    pd.drawPixel(x1, y1, Color.RED);
                    if (d >= 0) {
                        y1--;
                        x1++;
                        d += -2 * dy - 2 * dx;
                    } else {
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
                    pd.drawPixel(x1, y1, Color.BLUE);
                    if (d >= 0) {
                        y1++;
                        x1++;
                        d += 2 * dx - 2 * dy;
                    } else {
                        y1++;
                        d += 2 * dx;
                    }

                }
            } else if (x2 < x1) {
                int d = -2 * dx - dy;
                for (int i = y1; i <= y2; i++) {
                    pd.drawPixel(x1, y1, Color.BLUE);
                    if (d >= 0) {
                        y1++;
                        x1--;
                        d += -2 * dx - 2 * dy;
                    } else {
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
