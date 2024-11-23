import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel {
    final int originalSize = 24;
    int scale = 1; // Used to increase the size of "icon"
    final int tileSize = originalSize * scale; // Ex: 16 x 3 = tileSize

    final int maxScreenColumn = 24;
    final int maxScreenRow = 16;

    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight = tileSize * maxScreenRow;
    // 576 x 384

    // Constructor
    public GamePanel() {
        // Set screen dimensions and properties
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight)); // Aspect Ratio
        this.setBackground(Color.BLACK); // Background of the combat screen
        this.setDoubleBuffered(true); // Things of GamePanel() will be done offscreen, improves performance
        this.setLayout(new BorderLayout()); // Set layout for the panel

        // Add icons to the top
        setupTopIcons();
    }

    // Method to set up top-right icons
    private void setupTopIcons() {
        // Panel for icons
        JPanel topRightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topRightPanel.setOpaque(false); // Transparent panel to blend with the black background

        // Load and resize the icon
        ImageIcon wMoon = new ImageIcon(GamePanel.class.getResource("/Pictures/moon.png"));
        int iconWidth = 48; // Desired icon width
        int iconHeight = 48; // Desired icon height
        Image resizedImage = wMoon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Add four icons to the panel
        for (int i = 0; i < 4; i++) {
            JLabel moonLabel = new JLabel(resizedIcon);
            topRightPanel.add(moonLabel);
        }

        // Add the panel to the top of the GamePanel
        this.add(topRightPanel, BorderLayout.NORTH);
    }
}
