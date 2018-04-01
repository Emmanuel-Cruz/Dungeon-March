package Gamesetv3;

import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 * The dungeon game Ive been working on.
 * 
 * <pre>
 * FIXME: The shopkeeper dynamic breaks when I try to leave that loop and re-enter the fighting loop.
 * I was recommended to consider starting a whole new array there and making it its own 
 * public class static void thing.
 * 
 * TODO: I need to add the % chance of getting a 'brew' (potion) when you kill an enemy
 * TODO: When shopkeeping I need to subtract the player coins better...
 * 
 * TODO: When getting experience, I would loove to have it have a level system (which I can do) 
 * but what I may need help with is having your level ups increase your stats every time. 
 * 
 * TODO: Will be making program more object-oriented for importing into a GUI system
 * 
 * TODO: Need to fix run option and health 
 * </pre>
 * 
 * @author EJC
 */
public class Gamesetv3 {


	/*
	 * if easy, ad= 100, nb = 4, ect... if normal, ad=50, nb=2, if hard, ad=30, nb=0
	 * but, more coins and more xp?
	 */
	private int playerHealth = 0;
	private int playerAttackDamage = 0;
	private int numBrews = 0;
	private int monsterCount = 0;
	// player weapons CLOSE
	private int sword = 0;
	private int bowAndArrow = 0;
	private int kantana = 0;
	// player weapons RANGED
	private int rifle = 0;
	private int grenadeLauncher = 0;
	private int olReliable = 0;
	// player currency
	private int playerCoins = 0;
	// brews stats
	private int brewsHealAmount = 30;
	private int brewsDropChance = 0;
	private int dingoJuggle = 15;
	// experience stats
	private int playerXPAmountChance = 100;
	private int playerXP = 0;
	private int playerLevel = 0;
	// monster stats
	private int maxEnemyHealth = 300;
	private int enemyAttackDamage = 0;
	private int possibleXP = 100;
	private float enemyStats = 0; // using to randomize enemy attributes
	//

	public Gamesetv3(int hp, int ad, int p, int w1, int w2, int w3, int rw1, int rw2, int rw3, int c, int pc, int xpa, int xp, int l, 
			int ead) {
		//***the following stats VARY based on difficulty***
		//playerHealth = hp;
		setPlayerHealth (hp);
		//playerAttackDamage = ad;
		setPlayerAttackDamage (ad);
		setNumBrews (p);
		//numBrews = p;
		// ***UND player weapons CLOSE
		setSword (w1);
		//sword = w1;
		setBowAndArrow (w2);
		//bowAndArrow = w2;
		setKantana (w3);
		//kantana = w3;
		// ***UND player weapons RANGED
		setRifle (rw1);
		//rifle = rw1;
		setGrenadeLauncher (rw2);
		//grenadeLauncher = rw2;
		setOlReliable (rw3);
		//olReliable = rw3;
		// ***UND player currency
		setPlayerCoins (c);
		//playerCoins = c;
		// ***UND brews stats
		setBrewsDropChance (pc);
		//brewsDropChance = pc;
		// ***UND experience stats
		setPlayerXPAmountChance (xpa);
		//amount of XP possible per fight
		setPlayerXP (xp);
		//playerXP = xp;
		setPlayerLevel (l);
		// UND monster stats
		setEnemyAttackDamage (ead);
		//enemyAttackDamage = ead;
		// UND enemyStats = random.nextFloat(); //using to randomize enemy attributes
	}
	public int getPlayerXP() {
		return playerXP;
	}
	public void setPlayerXP(int playerXP) {
		this.playerXP = playerXP;
	}
	public void play(int difficulty) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		String[] enemies = { "Theif", "Bandit", "Zombie", "Armored Titan", "Skeleton King" };
		
		boolean running = true;
		if (difficulty == 1) {
			setPlayerHealth(getPlayerHealth() + 100);
			setPlayerAttackDamage(getPlayerAttackDamage() +50);
			setBrewsDropChance(getBrewsDropChance()+33);
			setNumBrews(getNumBrews()+2);
			setPlayerCoins(getPlayerCoins() + 100);
			setPlayerXPAmountChance(getPlayerXPAmountChance()-50);
			System.out.println("Prepare for a casual adventure!");
		}
		else if (difficulty == 2) {
			setPlayerHealth(getPlayerHealth());
			setPlayerAttackDamage(getPlayerAttackDamage());
			setBrewsDropChance(getBrewsDropChance());
			setNumBrews(getNumBrews());
			setPlayerCoins(getPlayerCoins());
			setPlayerXPAmountChance(getPlayerXPAmountChance());
			System.out.println("Prepare for an interesting challenge!");
		}
		else if (difficulty == 3) {
			setPlayerHealth(getPlayerHealth() -35);
			setPlayerAttackDamage(getPlayerAttackDamage()-25);
			setBrewsDropChance(getBrewsDropChance()-13);
			setNumBrews(getNumBrews()-1);
			setPlayerCoins(getPlayerCoins());
			setPlayerXPAmountChance(getPlayerXPAmountChance()+50);
			System.out.println("Prepare to use your best strategy!");
		}
		
		
		System.out.println("Welcome to the Dunegeon, Good Friend!");
		// Now to introduce gameplay!
		GAME: while (running) {
			System.out.println("-------------------------------------------------------");
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			int enemyXP = rand.nextInt(possibleXP);
			int damageDealt = rand.nextInt(playerAttackDamage);
			int damageTaken = rand.nextInt(enemyAttackDamage);

			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("# A " + enemy + " has appeared...#");

			if (enemyHealth < 25) {
				System.out.println("This enemy is... WEAK!");
			} else if (enemyHealth >= 25 && enemyHealth < 100) {
				System.out.println("This enemy is... Challenging!");
			} else if (enemyHealth >= 100 && enemyHealth < 200) {
				System.out.println("This enemy is... STRONG!");
			} else if (enemyHealth >= 200) {
				System.out.println("This enemy is... A BOSS!");
			}
//do this for all member variables!! Do not forget ()\|/
			while (enemyHealth > 0 && getPlayerHealth() >= 1) {
				System.out.println(" Your HP: " + playerHealth);
				System.out.println(" Enemy HP:" + enemyHealth);
				// System.out.println(" Enemy Type:" + );
				System.out.println("\n \t What should we do?");
				System.out.println(" 1, Attack");
				System.out.println(" 2, Heal with brew?");
				System.out.println(" 3, Run!");

				String input = in.nextLine();
				if (input.equals("1")) {
					enemyHealth -= damageDealt;
					playerHealth -= damageTaken;

					System.out.println("\t You have stricken the " + enemy + " for " + damageDealt + " damage.");
					System.out.println("\t The enemy, in turn, has stricken you with " + damageTaken + " damage!");
				} else if (input.equals("2")) {
					if (numBrews > 0) {
						playerHealth += brewsHealAmount;
						numBrews--;

						System.out.println("You are invigorated " + brewsHealAmount + " health points from the Brew!"
								+ "\n You now have " + playerHealth + " HP" + "\n Also " + numBrews
								+ " Brews left in your inventory.");
					}

					else {
						System.out.println("but you have none left!");
					}
				}

				else if (input.equals("3")) {
					System.out.println("\t You run away from the" + enemy + "!");
					continue GAME;
				} else if (input.equals("4")) {
					playerHealth += dingoJuggle;
					System.out.println(
							"You begin juggling with the dingos! Your health " + "is now " + playerHealth + "!");

				}

				else {
					System.out.println("Please try another command!");
				}
				System.out.println("------------------------------------------------------");
				// while enemy health > 0 line
			}
			if (playerHealth < 1) {
				System.out.println("You have died, you are now one with the Dunegeon.");
				break;
			}
			monsterCount++;
			int monsterXP = rand.nextInt(100);
			int monsterCoins = rand.nextInt(100);
			playerXP += monsterXP;
			playerCoins += monsterCoins;

			System.out.println("-----------------------------------------------------------");
			System.out.println("Total XP Points Earned:" + playerXP);
			System.out.println("Monster Death Count: " + monsterCount);
			System.out.println("Total Coins: " + playerCoins);
			System.out.println("Congratulations, what would you like to do?");
			System.out.println("1. Continue your Journey?");
			System.out.println("2. Exit Dungeon.");
			System.out.println("3. Juggle with the dingos.");
			System.out.println("4. Head to the Shopkeeper.");
			// ----------------------------------------------------------------------------------------
			String input = in.nextLine();
			while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
				System.out.println("Invalid Command, Sir.");
				input = in.nextLine();
			}
			if (input.equals("1")) {
				System.out.println("Continue on your journey, young one!");
			}
			if (input.equals("2")) {
				System.out.println("You leave the tunnel to recover...");
				break;
			}
			if (input.equals("3")) {
				System.out.println("The juggling invigorates your soul 5 HP!");
				playerHealth += dingoJuggle;
				continue GAME;
			}
			if (input.equals("4")) {
				System.out.println(
						"The Shopkeeper gives you a smile, he must not get a lot of business. 'What will ya have?' ");
				// continue
				// SHOP------------------------------------------------------------------------------------------------------------;
				boolean running2 = true;
				SHOP: while (running2) {
					System.out.println(
							" A. Bow - 100 coins  \n B. Sword- 150 coins \n C. Rifle- 300 coins \n D. The Rare goods will cost you to look at. - 50 coins \n E. Nothing, just passing through...");
					System.out.println("Your Coins:" + playerCoins);

					String inputStay = in.nextLine();

					System.out.println("Alright then, you done here then?");
					System.out.println(" 1. Continue Shopping");
					System.out.println("\n 2. Yes. (Head back into the abyss)");
					System.out.println("\n 3. Ask about the dingos.");
					System.out.println("\n 4. What's your story, salesman?");

					if (inputStay.equals(1)) {
						continue SHOP;
					} else if (inputStay.equals(2)) {
						continue GAME;
					} else if (inputStay.equals(3)) {
						while (playerXP < 1000)
							System.out.println("Sorry lad, thats a story for another time...");
						if (playerXP > 1000)
							System.out.println("Looks like you have seen enough to know... \n");
						System.out.println(
								"The dingo juggle is a deep ritual where you spill the blood of an animal. \n When you are this deep in the planet's core, the magnetic pulls of the iron in the blood invigorate you.");
						System.out.println("And now that you know, do not abuse this ritual.");
						continue GAME;
					}
					while (playerCoins > 0) {

						String input2 = in.nextLine();

						if (input2.equals("A")) {
							System.out.println("Good Choice my friend.");
							playerCoins -= 100;
							playerAttackDamage += 40;
						} else if (input2.equals("B")) {
							System.out.println("Another favorite...");
							playerCoins -= 150;
						} else if (input2.equals("C")) {
							System.out.println("Good One.");
							playerCoins -= 300;
						} else if (input2.equals("D")) {
							System.out.println("Here are our 'black market' goods." + "\n 1. Kantana");

						} else if (input2.equals("E")) {
							System.out.println("Ok, be safe traveller.");
							break;
						} else if (playerCoins < 1) {
							System.out.println("Sorry traveller, you do not have the funds.");
						}
					}
				}
			}
		}
		// maybe i can label the parantesses
		System.out.println("###################" + "\n Thanks for playing" + "\n ####################");

	}
	public int getPlayerHealth() {
		return playerHealth;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}

	public int getPlayerAttackDamage() {
		return playerAttackDamage;
	}

	public void setPlayerAttackDamage(int playerAttackDamage) {
		this.playerAttackDamage = playerAttackDamage;
	}

	public int getNumBrews() {
		return numBrews;
	}

	public void setNumBrews(int numBrews) {
		this.numBrews = numBrews;
	}

	public int getMonsterCount() {
		return monsterCount;
	}

	public void setMonsterCount(int monsterCount) {
		this.monsterCount = monsterCount;
	}

	public int getSword() {
		return sword;
	}

	public void setSword(int sword) {
		this.sword = sword;
	}

	public int getBowAndArrow() {
		return bowAndArrow;
	}

	public void setBowAndArrow(int bowAndArrow) {
		this.bowAndArrow = bowAndArrow;
	}

	public int getKantana() {
		return kantana;
	}

	public void setKantana(int kantana) {
		this.kantana = kantana;
	}

	public int getRifle() {
		return rifle;
	}

	public void setRifle(int rifle) {
		this.rifle = rifle;
	}

	public int getGrenadeLauncher() {
		return grenadeLauncher;
	}

	public void setGrenadeLauncher(int grenadeLauncher) {
		this.grenadeLauncher = grenadeLauncher;
	}

	public int getOlReliable() {
		return olReliable;
	}

	public void setOlReliable(int olReliable) {
		this.olReliable = olReliable;
	}

	public int getPlayerCoins() {
		return playerCoins;
	}

	public void setPlayerCoins(int playerCoins) {
		this.playerCoins = playerCoins;
	}

	public int getBrewsHealAmount() {
		return brewsHealAmount;
	}

	public void setBrewsHealAmount(int brewsHealAmount) {
		this.brewsHealAmount = brewsHealAmount;
	}

	public int getBrewsDropChance() {
		return brewsDropChance;
	}

	public void setBrewsDropChance(int brewsDropChance) {
		this.brewsDropChance = brewsDropChance;
	}

	public int getDingoJuggle() {
		return dingoJuggle;
	}

	public void setDingoJuggle(int dingoJuggle) {
		this.dingoJuggle = dingoJuggle;
	}

	public int getplayerXP() {
		return playerXP;
	}

	public void setplayerXP(int playerXP) {
		this.playerXP = playerXP;
	}

	public int getPlayerXPAmountChance() {
		return playerXPAmountChance;
	}

	public void setPlayerXPAmountChance(int playerXPAmountChance) {
		this.playerXPAmountChance = playerXPAmountChance;
	}
	public int getPlayerLevel() {
		return playerLevel;
	}

	public void setPlayerLevel(int playerLevel) {
		this.playerLevel = playerLevel;
	}
	public int getMaxEnemyHealth() {
		return maxEnemyHealth;
	}

	public void setMaxEnemyHealth(int maxEnemyHealth) {
		this.maxEnemyHealth = maxEnemyHealth;
	}

	public int getEnemyAttackDamage() {
		return enemyAttackDamage;
	}

	public void setEnemyAttackDamage(int enemyAttackDamage) {
		this.enemyAttackDamage = enemyAttackDamage;
	}

	public int getPossibleXP() {
		return possibleXP;
	}

	public void setPossibleXP(int possibleXP) {
		this.possibleXP = possibleXP;
	}

	public float getEnemyStats() {
		return enemyStats;
	}

	public void setEnemyStats(float enemyStats) {
		this.enemyStats = enemyStats;
	}
	public static void main(String[] args) {
		
		Gamesetv3 mystat = new Gamesetv3(400, 50, 4, 50, 100, 150, 75, 125, 175, 50, 0, 0, 100, 100, 100);		
		
		String test1= JOptionPane.showInputDialog("What would you like your difficulty to be? \n Easy? \n Normal? \n Hard?");
        //need if statements to say if difficulty=easy , set int =1
		int int1 = Integer.parseInt(test1);
		
		mystat.play(int1);
	}
}