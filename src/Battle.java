import characters.Archer;
import characters.Elf;
import characters.Orc;
import characters.Character;

// Battle.java
import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Character selection for Player 1
        System.out.println("Player 1, choose your character (1: Elf, 2: Archer, 3: Orc):");
        int choice1 = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter name for Player 1's character:");
        String name1 = scanner.nextLine();
        Character player1 = createCharacter(choice1, name1);

        // Character selection for Player 2
        System.out.println("Player 2, choose your character (1: Elf, 2: Archer, 3: Orc):");
        int choice2 = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter name for Player 2's character:");
        String name2 = scanner.nextLine();
        Character player2 = createCharacter(choice2, name2);

        // Battle
        System.out.println("Battle Start!");
        System.out.println(player1.getName() + " vs " + player2.getName());

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            player1.attack(player2);
            System.out.println(player2.getName() + " has " + player2.getHealth() + " health left.");
            if (player2.getHealth() <= 0) {
                System.out.println(player2.getName() + " is defeated!");
                break;
            }

            player2.attack(player1);
            System.out.println(player1.getName() + " has " + player1.getHealth() + " health left.");
            if (player1.getHealth() <= 0) {
                System.out.println(player1.getName() + " is defeated!");
                break;
            }
        }

        scanner.close();
    }

    public static Character createCharacter(int choice, String name) {
        switch (choice) {
            case 1:
                return new Elf(name);
            case 2:
                return new Archer(name);
            case 3:
                return new Orc(name);
            default:
                throw new IllegalArgumentException("Not a valid character");
        }
    }
}
