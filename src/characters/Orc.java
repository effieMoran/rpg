package characters;

public class Orc extends Character {
    public Orc(String name) {
        super(name, 120, 10);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " slashes at " + opponent.getName());
        opponent.takeDamage(this.attackPower);
    }
}