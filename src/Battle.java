import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for Elf:");
        String elfName = scanner.nextLine();
        Character elf = new Elf(elfName);

        System.out.println("Enter name for Orc:");
        String orcName = scanner.nextLine();
        Character orc = new Orc(orcName);

        System.out.println("Battle Start!");
        System.out.println(elf.getName() + " vs " + orc.getName());

        while (elf.getHealth() > 0 && orc.getHealth() > 0) {
            elf.attack(orc);
            System.out.println(orc.getName() + " has " + orc.getHealth() + " health left.");

            if (orc.getHealth() <= 0) {
                System.out.println(orc.getName() + " is defeated!");
                break;
            }

            orc.attack(elf);
            System.out.println(elf.getName() + " has " + elf.getHealth() + " health left.");

            if (elf.getHealth() <= 0) {
                System.out.println(elf.getName() + " is defeated!");
                break;
            }
        }

        scanner.close();
    }
}
