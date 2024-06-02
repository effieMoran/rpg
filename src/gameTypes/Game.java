package gameTypes;

import addOns.Weapon;
import characters.Archer;
import characters.Elf;
import characters.Fighter;
import characters.Orc;

import java.util.Scanner;
import java.util.List;

public class Game {
    private Scanner scanner;
    private Fighter player1;
    private Fighter player2;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public void setupGame() {
        // Fighter selection for Player 1
        System.out.println("Player 1, choose your fighter (1: Elf, 2: Archer, 3: Orc):");
        int choice1 = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter name for Player 1's fighter:");
        String name1 = scanner.nextLine();
        player1 = createFighter(choice1, name1);

        // Fighter selection for Player 2
        System.out.println("Player 2, choose your fighter (1: Elf, 2: Archer, 3: Orc):");
        int choice2 = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter name for Player 2's fighter:");
        String name2 = scanner.nextLine();
        player2 = createFighter(choice2, name2);
    }

    public void startBattle() {
        System.out.println("Battle Start!");
        System.out.println(player1.getName() + " vs " + player2.getName());

        while (player1.getHealth() > 0 && player2.getHealth() > 0) {
            // Player 1's turn to attack
            System.out.println(player1.getName() + ", choose your weapon:");
            Weapon weapon1 = chooseWeapon(player1);
            player1.attack(player2, weapon1);
            System.out.println(player2.getName() + " has " + player2.getHealth() + " health left.");
            if (player2.getHealth() <= 0) {
                System.out.println(player2.getName() + " is defeated!");
                break;
            }

            // Player 2's turn to attack
            System.out.println(player2.getName() + ", choose your weapon:");
            Weapon weapon2 = chooseWeapon(player2);
            player2.attack(player1, weapon2);
            System.out.println(player1.getName() + " has " + player1.getHealth() + " health left.");
            if (player1.getHealth() <= 0) {
                System.out.println(player1.getName() + " is defeated!");
                break;
            }
        }
    }

    private Fighter createFighter(int choice, String name) {
        switch (choice) {
            case 1:
                return new Elf(name);
            case 2:
                return new Archer(name);
            case 3:
                return new Orc(name);
            default:
                throw new IllegalArgumentException("This fighter choice is not available.");
        }
    }

    private Weapon chooseWeapon(Fighter fighter) {
        List<Weapon> weapons = fighter.getWeapons();
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println((i + 1) + ": " + weapons.get(i).getName() + " (Attack Power: " + weapons.get(i).getAttackPower() + ")");
        }
        int weaponChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        return weapons.get(weaponChoice - 1);
    }
}
