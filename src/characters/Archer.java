package characters;

import addOns.Weapon;

public class Archer extends Fighter {
    public Archer(String name) {
        super(name, 80, 20);
        addWeapon(new Weapon("Longbow", 12));
        addWeapon(new Weapon("Short Sword", 7));
    }

    @Override
    public void attack(Fighter opponent, Weapon weapon) {
        int totalAttackPower = this.baseAttackPower + weapon.getAttackPower();
        System.out.println(this.name + " attacks " + opponent.getName() + " with " + weapon.getName());
        opponent.takeDamage(totalAttackPower);
    }
}