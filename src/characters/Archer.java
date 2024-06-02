package characters;

public class Archer extends Character {
    public Archer(String name) {
        super(name, 80, 20);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " fires a shot at " + opponent.getName());
        opponent.takeDamage(this.attackPower);
    }
}