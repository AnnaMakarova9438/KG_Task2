package LineDrawers;

import KG.Task2.LineDrawer;
import KG.Task2.PixelDrawer;

import java.awt.*;

public class DDALineDrawer implements LineDrawer {

    private PixelDrawer pd;

    public DDALineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            double k = dy / dx;
            if (x1 > x2) {
                int tmp = x1;
                x1 = x2;
                x2 = tmp;
                y1 = y2;
            }
            for (int j = x1; j <= x2; j++) {
                double i = k * (j - x1) + y1;
                pd.drawPixel(j, (int) i, Color.RED);
            }
        } else {
            double kObr = dx / dy;
            if (y1 > y2) {
                int tmp = x1;
                x1 = x2;
                tmp = y1;
                y1 = y2;
                y2 = tmp;
            }
            for (int i = y1; i <= y2; i++) {
                double j = kObr * (i - y1) + x1;
                pd.drawPixel((int) j, i, Color.RED);
            }
        }
    }
}
