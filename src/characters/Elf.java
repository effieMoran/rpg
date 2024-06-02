package characters;

public class Elf extends Character {
    public Elf(String name) {
        super(name, 100, 15);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(this.name + " shoots an arrow at " + opponent.getName());
        opponent.takeDamage(this.attackPower);
    }
}