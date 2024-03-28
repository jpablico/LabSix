/**
 * BattleSimulator class that simulates a battle when given two Characters
 * Muhammad Noor
 * COSC-1437.200
 * Created on Mar. 28th, 2024
 */

public class BattleSimulator {

    private String attackOrHeal() {
        int rand = (int) (Math.random() * 10) + 1;
        if (rand > 7) {
            return "heal";
        } else {
            return "attack";
        }
    }

    private String displayStats(Character character) {
        return character.getName() + " health remaining: "  + character.getCurrentHealth();
    }

    public void battle(Character c1, Character c2) {
        System.out.println("It's a dual to the death. Let's welcome our opponents:\n" + c1.getName() + "\n" + c2.getName());
        System.out.println("Let the battle commence!");
        System.out.println("***************************************");

        while(c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {

            if (attackOrHeal().equalsIgnoreCase("attack")) {

                int damage = c1.attack(c2);
                if (damage > (Character.BASE_ATTACK + c1.getStrength())) {
                    System.out.println("**Critical Hit!** " + c1.getName()+ " chooses to attack and inflicts " + damage + " damage");
                } else {
                    System.out.println(c1.getName()+ " chooses to attack and inflicts " + damage + " damage");
                }

            } else {
                System.out.println(c1.getName() + " chooses to heal. They gained " + c1.healSpell() + " health");
            }

            if (attackOrHeal().equalsIgnoreCase("attack")) {

                int damage = c2.attack(c1);
                if (damage > (Character.BASE_ATTACK + c2.getStrength())) {
                    System.out.println("**Critical Hit!** " + c2.getName()+ " chooses to attack and inflicts " + damage + " damage");
                } else {
                    System.out.println(c2.getName()+ " chooses to attack and inflicts " + damage + " damage");
                }

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

        if (c1.getCurrentHealth() > c2.getCurrentHealth() && c1.getCurrentHealth() > 0) {
            System.out.println(c1.getName() + " is your WINNER!");
        } else if (c2.getCurrentHealth() > c1.getCurrentHealth() && c2.getCurrentHealth() > 0) {
            System.out.println(c2.getName() + " is your WINNER!");
        } else {
            System.out.println("Sadly, the dual has left them both dead.");
        }

    }

}
