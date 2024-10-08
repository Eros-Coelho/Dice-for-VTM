import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your character's name: ");
        String characterName = scanner.nextLine();

        System.out.print("Please enter the Attribute: ");
        String attribute = scanner.nextLine().toLowerCase();

        System.out.print("Please enter the Ability: ");
        String ability = scanner.nextLine().toLowerCase();

        System.out.print("Please enter any bonuses (if none, type 0): ");
        int bonus = scanner.nextInt();
        scanner.nextLine();
        // consume the remaining newline

        int die1 = 0;

        die1 = switch (attribute) {
            case "strength", "dexterity", "stamina" -> 2;
            case "charisma", "manipulation", "perception", "wits" -> 3;
            case "appearance", "intelligence" -> 4;
            default -> 0;
        };

        int die2 = 0;

        die2 = switch (ability) {
            case "alertness", "leadership", "etiquette" -> 2;
            case "empathy", "intimidation", "subterfuge", "body crafts", "academics", "hearth wisdom", "occult" -> 3;
            default -> 0;
        };

        int critical = 0;

        if (die1 > 3 || die2 > 3) {
            System.out.print("Specialty applies? (yes or no): ");
            String specialty = scanner.nextLine().toLowerCase();

            switch (specialty) {
                case "yes" -> critical = 1;
                case "no" -> critical = 0;
            }
        }

        int dicePool = die1 + die2 + bonus;

        int results = 0;
        int ones = 0;

        System.out.println(characterName + " rolls " + attribute + " + " + ability + ":");

        if (die2 != 0) {

            for (int i = 0; i < dicePool; i++) {
                int value = (int) (Math.random() * 10) + 1;
                System.out.print(value + "\t");

                if (value > 5) {
                    results++;
                } else if (value == 1) {
                    ones++;
                }
            }
        } else {
            for (int i = 0; i < dicePool; i++) {
                int value = (int) (Math.random() * 10) + 1;
                System.out.print(value + "\t");

                if (value > 6) {
                    results++;
                } else if (value == 1) {
                    ones++;
                }
            }
        }
        int count10s = 0;
        if (critical == 1) {
            count10s++;
        }
        int totalSuccesses = results - ones + count10s;

        System.out.println("\n" + "= " + totalSuccesses + " Successes");
    }
}