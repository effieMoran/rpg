package characters;

import addOns.Weapon;

import java.util.ArrayList;

import java.util.List;

public abstract class Fighter {
    protected String name;
    protected int health;
    protected int baseAttackPower;
    protected List<Weapon> weapons;

    public Fighter(String name, int health, int baseAttackPower) {
        this.name = name;
        this.health = health;
        this.baseAttackPower = baseAttackPower;
        this.weapons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
    }

    public void addWeapon(Weapon weapon) {
        this.weapons.add(weapon);
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public abstract void attack(Fighter opponent, Weapon weapon);
}
