import javax.swing.JOptionPane;

public class Game {

    public static void main(String[] args) {
        // MC Name
        String MC = JOptionPane.showInputDialog("Enter your name.", "Player");
        JOptionPane.showMessageDialog(null, MC + " is the main character of this game.", MC + "? Nice Name!" , JOptionPane.PLAIN_MESSAGE);
                                                          
        // Stat choosing questionnaire
        int strength = 0;
        int intelligence = 0;
        int charisma = 0;
        int agility = 0;

        // Question 1
        String[] options1 = {"Power and control (Strength)", "Knowledge and wisdom (Intelligence)", "Charisma and influence (Charisma)", "Agility and speed (Agility)"};
        int choice1 = JOptionPane.showOptionDialog(null, "What motivates your character?", "Character Motivation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
        /*Basically default option is custom buttons, question_message is just the icon, 
        option1 near icon is the choices on the buttons, and option1[0] is the default selection (why it starts at power)*/
        
        switch (choice1)  //If clicked, add 1 to the base stat
        {
            case 0 -> strength++; //-> means break;! used for a faster way of breaking :)
            case 1 -> intelligence++;
            case 2 -> charisma++;
            case 3 -> agility++;
        }

        // Question 2
        String[] options2 = {"With brute force (Strength)", "Through careful planning (Intelligence)", "By persuading others (Charisma)", "By acting quickly (Agility)"};
        int choice2 = JOptionPane.showOptionDialog(null, "How does your character prefer to solve problems?", "Problem Solving",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        switch (choice2) 
        {
            case 0 -> strength++;
            case 1 -> intelligence++;
            case 2 -> charisma++;
            case 3 -> agility++;
        }

        // Question 3
        String[] options3 = {"Charge in without hesitation (Strength)", "Analyze the situation before acting (Intelligence)", "Rally others to their side (Charisma)", "Try to escape or maneuver (Agility)"};
        int choice3 = JOptionPane.showOptionDialog(null, "In a dangerous situation, your character would:", "Dangerous Situation",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);
        switch (choice3) 
        {
            case 0 -> strength++;
            case 1 -> intelligence++;
            case 2 -> charisma++;
            case 3 -> agility++;
        }

        // Allocate Points
        int points = 10;
        while (points > 0) {
            String input = JOptionPane.showInputDialog(null, "You have " + points + " points to allocate.\n" +
                    "Enter points for Strength (current: " + strength + "):");
            int allocatedPoints = Integer.parseInt(input);
            if (allocatedPoints <= Math.min(5 - strength, points)) {
                strength += allocatedPoints;
                points -= allocatedPoints;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a value between 0 and " + Math.min(5 - strength, points));
                continue;
            }

            input = JOptionPane.showInputDialog(null, "You have " + points + " points to allocate.\n" +
                    "Enter points for Intelligence (current: " + intelligence + "):");
            allocatedPoints = Integer.parseInt(input);
            if (allocatedPoints <= Math.min(5 - intelligence, points)) {
                intelligence += allocatedPoints;
                points -= allocatedPoints;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a value between 0 and " + Math.min(5 - intelligence, points));
                continue;
            }

            input = JOptionPane.showInputDialog(null, "You have " + points + " points to allocate.\n" +
                    "Enter points for Charisma (current: " + charisma + "):");
            allocatedPoints = Integer.parseInt(input);
            if (allocatedPoints <= Math.min(5 - charisma, points)) {
                charisma += allocatedPoints;
                points -= allocatedPoints;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a value between 0 and " + Math.min(5 - charisma, points));
                continue;
            }

            input = JOptionPane.showInputDialog(null, "You have " + points + " points to allocate.\n" +
                    "Enter points for Agility (current: " + agility + "):");
            allocatedPoints = Integer.parseInt(input);
            if (allocatedPoints <= Math.min(5 - agility, points)) {
                agility += allocatedPoints;
                points -= allocatedPoints;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a value between 0 and " + Math.min(5 - agility, points));
            }
        }

        // Display Final Stats
        JOptionPane.showMessageDialog(null, "Your character's final stats are:\n" +
                "Strength: " + strength + "\n" +
                "Intelligence: " + intelligence + "\n" +
                "Charisma: " + charisma + "\n" +
                "Agility: " + agility);
    }
}
