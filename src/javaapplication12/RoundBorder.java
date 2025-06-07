
package javaapplication12;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundBorder extends AbstractBorder {
    private final Color color;
    private final int thickness;
    private final int radius;
    private final Insets insets;

    public RoundBorder(Color color, int thickness, int radius) {
        this.color = color;
        this.thickness = thickness;
        this.radius = radius;
        this.insets = new Insets(thickness, thickness, thickness, thickness);
    }

    public RoundBorder(int radius) {
        this(Color.GRAY, 1, radius);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        RoundRectangle2D roundRect = new RoundRectangle2D.Float(x, y, width-1, height-1, radius, radius);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(roundRect);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return insets;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return this.insets;
    }
}
