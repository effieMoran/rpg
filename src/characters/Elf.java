package characters;

import addOns.Weapon;

public class Elf extends Fighter {
    public Elf(String name) {
        super(name, 100, 15);
        addWeapon(new Weapon("Magic Bow", 10));
        addWeapon(new Weapon("Elven Dagger", 5));
    }

    @Override
    public void attack(Fighter opponent, Weapon weapon) {
        int totalAttackPower = this.baseAttackPower + weapon.getAttackPower();
        System.out.println(this.name + " attacks " + opponent.getName() + " with " + weapon.getName());
        opponent.takeDamage(totalAttackPower);
    }
}