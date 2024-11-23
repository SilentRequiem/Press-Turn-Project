import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Game {

    public static void main(String[] args) {
        // Main Character Name
        String MC = JOptionPane.showInputDialog("Enter your name.", "Player");
        JOptionPane.showMessageDialog(null, MC + " is the main character of this game.", MC + "? Nice Name!", JOptionPane.PLAIN_MESSAGE);

        // Base stats
        int strength = 0;
        int intelligence = 0;
        int charisma = 0;
        int agility = 0;

        // Questionnaire for base stats
        String[][] questions = {
            {
                "What motivates your character?",
                "Power and control (Strength)", 
                "Knowledge and wisdom (Intelligence)", 
                "Charisma and influence (Charisma)", 
                "Agility and speed (Agility)"
            },
            {
                "How does your character prefer to solve problems?",
                "With brute force (Strength)", 
                "Through careful planning (Intelligence)", 
                "By persuading others (Charisma)", 
                "By acting quickly (Agility)"
            },
            {
                "In a dangerous situation, your character would:",
                "Charge in without hesitation (Strength)", 
                "Analyze the situation before acting (Intelligence)", 
                "Rally others to their side (Charisma)", 
                "Try to escape or maneuver (Agility)"
            }
        };

        // Loop through questions
        for (String[] question : questions) {
            int choice = JOptionPane.showOptionDialog(
                null, question[0], "Character Question",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[]{question[1], question[2], question[3], question[4]},
                question[1]
            );
            switch (choice) {
                case 0 -> strength++;
                case 1 -> intelligence++;
                case 2 -> charisma++;
                case 3 -> agility++;
            }
        }

        // Allocate remaining points
        int points = 10;
        while (points > 0) {
            points -= allocatePoints("Strength", strength, points);
            points -= allocatePoints("Intelligence", intelligence, points);
            points -= allocatePoints("Charisma", charisma, points);
            points -= allocatePoints("Agility", agility, points);
        }

        // Display Final Stats
        JOptionPane.showMessageDialog(null, "Your character's final stats are:\n" +
                "Strength: " + strength + "\n" +
                "Intelligence: " + intelligence + "\n" +
                "Charisma: " + charisma + "\n" +
                "Agility: " + agility);

        // Window setup
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X to close the window
        window.setResizable(false); // No stretching the window to make it look weird
        window.setTitle("Press Turn Project");

        // Set custom window icon using a relative path after moving the Pictures folder into src
        ImageIcon img = new ImageIcon(Game.class.getResource("/Pictures/IV.png")); // Use the relative path
        window.setIconImage(img.getImage()); // Set the window icon

        // Connect to GamePanel
        GamePanel gamePanel = new GamePanel(); // Create an instance of GamePanel
        window.add(gamePanel); // Add GamePanel to the window
        window.pack(); // Sets size & layout of subcomponents

        window.setLocationRelativeTo(null); // Set on the middle of the screen
        window.setVisible(true); // Show the window
    }

    // Method to allocate points for a stat
    private static int allocatePoints(String statName, int currentStat, int availablePoints) {
        while (true) {
            String input = JOptionPane.showInputDialog(null, 
                "You have " + availablePoints + " points to allocate.\n" +
                "Enter points for " + statName + " (Max for each stat is 5) (current: " + currentStat + "):");
            try {
                int allocatedPoints = Integer.parseInt(input);
                if (allocatedPoints <= Math.min(5 - currentStat, availablePoints) && allocatedPoints >= 0) {
                    return allocatedPoints; // Valid allocation
                }
            } catch (NumberFormatException e) {
                // Invalid input, fall through to error message
            }
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a value between 0 and " + Math.min(5 - currentStat, availablePoints));
        }
    }
}
