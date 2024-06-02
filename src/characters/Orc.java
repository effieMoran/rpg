package characters;

import addOns.Weapon;

public class Orc extends Fighter {
    public Orc(String name) {
        super(name, 120, 10);
        addWeapon(new Weapon("Axe", 15));
        addWeapon(new Weapon("Club", 8));
    }

    @Override
    public void attack(Fighter opponent, Weapon weapon) {
        int totalAttackPower = this.baseAttackPower + weapon.getAttackPower();
        System.out.println(this.name + " attacks " + opponent.getName() + " with " + weapon.getName());
        opponent.takeDamage(totalAttackPower);
    }
}