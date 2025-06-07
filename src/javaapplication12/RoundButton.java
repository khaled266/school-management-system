package javaapplication12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;


public class RoundButton extends JButton {
    private static final Color DEFAULT_BACKGROUND = new Color(0xf7941d); 
    private static final Color HOVER_BACKGROUND = new Color(0xc16c07);   
    private boolean isHover = false;
    private int cornerRadius = 30; 
    private Icon icon = null; 
    public RoundButton(String label) {
        super(label);
        
        
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        
        
        setForeground(Color.WHITE);
        
       
        setOpaque(false);
        
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHover = true;
                repaint();
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                isHover = false;
                repaint();
            }
        });
    }

    /**
     * Set the icon to be displayed on the button
     */
    public void setButtonIcon(Icon icon) {
        this.icon = icon;
        repaint();
    }
    
    /**
     * Set the corner radius for the rounded rectangle
     * @param radius the corner radius in pixels
     */
    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        
        // Enable anti-aliasing for smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        
        // Set the color based on hover state
        if (isHover) {
            g2.setColor(HOVER_BACKGROUND);
        } else {
            g2.setColor(DEFAULT_BACKGROUND);
        }
        
        // Draw the rounded rectangle
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth() - 1, 
                                                                      getHeight() - 1, 
                                                                      cornerRadius, cornerRadius);
        g2.fill(roundedRectangle);
        
        // Draw the text (and icon if available) centered
        FontMetrics metrics = g2.getFontMetrics(getFont());
        String text = getText();
        int textWidth = metrics.stringWidth(text);
        int textHeight = metrics.getHeight();

        int iconWidth = 0;
        int iconHeight = 0;
        if (icon != null) {
            iconWidth = icon.getIconWidth();
            iconHeight = icon.getIconHeight();
        }

        int totalWidth = textWidth + (icon != null ? iconWidth + 5 : 0);
        int startX = (getWidth() - totalWidth) / 2;
        int textY = ((getHeight() - textHeight) / 2) + metrics.getAscent();

        g2.setColor(getForeground());

        if (icon != null) {
            int iconY = (getHeight() - iconHeight) / 2;
            icon.paintIcon(this, g2, startX, iconY);
            startX += iconWidth + 5;
        }

        g2.drawString(text, startX, textY);
        
        g2.dispose();
    }
    
    @Override
    public boolean contains(int x, int y) {
        // Make sure clicks only register within the rounded rectangle
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(0, 0, getWidth() - 1, 
                                                                      getHeight() - 1, 
                                                                      cornerRadius, cornerRadius);
        return roundedRectangle.contains(x, y);
    }
    
    @Override
    public Dimension getPreferredSize() {
        // Base the size on the text plus some padding
        FontMetrics metrics = getFontMetrics(getFont());
        int width = metrics.stringWidth(getText()) + 40;
        int height = metrics.getHeight() + 20;
        return new Dimension(width, height);
    }
    
    // Example usage
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rounded Button Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
            
            RoundButton loginButton = new RoundButton("تسجيل الدخول");
            loginButton.setFont(new Font("Arial", Font.BOLD, 14));
            loginButton.setButtonIcon(new ImageIcon("login.png")); // أضف صورة مناسبة هنا
            loginButton.addActionListener(e -> System.out.println("تم النقر على الزر!"));

            RoundButton registerButton = new RoundButton("إنشاء حساب");
            registerButton.setFont(new Font("Arial", Font.BOLD, 14));
            registerButton.setCornerRadius(10);
            registerButton.setButtonIcon(new ImageIcon("register.png")); // أضف صورة مناسبة هنا
            
            frame.add(loginButton);
            frame.add(registerButton);
            frame.setSize(350, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
