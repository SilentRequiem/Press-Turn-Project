//package main; //Used to make runnable files? 
import java.awt.Color;

//Screen settings
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel {
    final int originalSize = 24;
    int scale = 1; //Used to increase the size of "icon"
    final int tileSize = originalSize * scale; //Ex: 16 x 3 = tileSize

    final int maxScreenColumn = 24;
    final int maxScreenRow = 16;
    
    final int screenWidth = tileSize * maxScreenColumn;
    final int screenHeight = tileSize * maxScreenRow;
    //576 x 384
    
    //Constructor
    public GamePanel() {
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight)); //Aspect Ratio
        this.setBackground(Color.BLACK); // Background of the combat screen
        this.setDoubleBuffered(true); //things of GamePanel() will be done offscreen, improves performace

    }


}
