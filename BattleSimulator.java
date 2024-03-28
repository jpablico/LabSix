import java.util.Random;

public class BattleSimulator {

    public String attackOrHeal() {
        Random random = new Random();
        int rand = random.nextInt(10) + 1;
        if (rand > 7) {
            return "heal";
        } else {
            return "attack";
        }
    }

    public String displayStats(Character character) {
        return character.getName() + " health remaining: "  + character.getCurrentHealth();
    }

    public void battle(Character c1, Character c2) {
        System.out.println("It's a dual to the death. Let's welcome our opponents:\n" + c1.getName() + "\n" + c2.getName());
        System.out.println("Let the battle commence!");
        System.out.println("***************************************");

        while(c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {

            if (attackOrHeal().equalsIgnoreCase("attack")) {
                System.out.println(c1.getName()+ " chooses to attack and inflicts " + c1.attack(c2) + " damage");
            } else {
                System.out.println(c1.getName() + " chooses to heal. They gained " + c1.healSpell() + " health");
            }

            if (attackOrHeal().equalsIgnoreCase("attack")) {
                System.out.println(c2.getName() + " chooses to attack and inflicts " + c2.attack(c1) + " damage");
            } else {
                System.out.println(c2.getName() + " chooses to heal. They gained " + c2.healSpell() + " health");
            }

            System.out.println("-------------------");
            System.out.println("Current Status:");
            System.out.println(displayStats(c1));
            System.out.println(displayStats(c2));
            System.out.println("-------------------");
        }

        System.out.println("********************************");
        System.out.println("This battle has ended!");
        if (c1.getCurrentHealth() > c2.getCurrentHealth()) {
            System.out.println(c1.getName() + " is your WINNER!");
        } else if (c2.getCurrentHealth() > c1.getCurrentHealth()) {
            System.out.println(c2.getName() + " is your WINNER!");
        } else {
            System.out.println("Sadly, the dual has left them both dead.");
        }

    }

}
