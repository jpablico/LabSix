/**
 * Character class constructs a character object with a name, strength, and speed. It also has methods to attack, heal, and take damage. Used in BattleSimulator.java
 * Josh Pablico
 * COSC-1437.200
 * Created on Mar. 28th, 2024
 */

package LabSix;

public class Character {

	private final String name;
	private int currentHealth;
	private final int strength;
	private final int speed;
	public static final int BASE_ATTACK = 10;
	private static final int BASE_HEAL = 5;

	public Character(String name, int strength, int speed) {
		this.name = name;
		this.strength = strength;
		this.speed = speed;
		this.currentHealth = 50;
	}

	public int attack(Character opponent) {
		int damage = BASE_ATTACK + strength;
		if (Math.random() < 0.1) {
			damage += 5;
		}
		opponent.takeDamage(damage);
		return damage;
	}

	public int healSpell() {
		int healthRestored = BASE_HEAL + (2 * speed);
		currentHealth += healthRestored;
		return healthRestored;
	}

	public void takeDamage(int damage) {
		currentHealth -= damage;
	}

	public String getName() {
		return name;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getStrength() {
		return strength;
	}

	public int getSpeed() {
		return speed;
	}
}