package javaapplication12;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class ModernTextField extends JTextField {
    private int cornerRadius = 20;

    public ModernTextField(int columns) {
        super(columns);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10)); // padding
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        setForeground(new Color(50, 50, 50));
        setBackground(new Color(240, 240, 240));
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        // Border (optional)
        g2.setColor(new Color(200, 200, 200));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2.dispose();
        super.paintComponent(g);
        

    }

    @Override
    public void setBorder(Border border) {
        // ignore border changes to keep it clean
    }
}
