import java.util.*;

/**
 * The dungeon game Ive been working on.
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
 * </pre>
 * @author EJC
 */
public class Begin.ALLgamestats {
	private static Random random = new Random();
	private static Scanner in = new Scanner(System.in);
	
	class ALLgamestats implements Comparable { 
		
		//player stats
		private int playerHealth = hp;
		private int playerAttackDamage = ad;
		private int numBrews = p;
		private int monsterCount = mc;
		// player weapons LOW
		private int sword = w1;
		private int bowAndArrow = w2;
		private int rifle = w3;
		// player weapons high
		private int kantana = bw1;
		private int grenadeLauncher = bw2;
		private int olReliable = bw3;
		// player currency
		private int playerCoins = c;
		// brews stats
		private int brewsHealAmount = pa;
		private int brewsDropChance = pc;
		private int dingoJuggle = dj;
		// experience stats
		private int xpAmountChance = xpc;
		private int playerXP = xp;
		// monster stats
		private int maxEnemyHealth = ehp;
		private int enemyAttackDamage = ead;
		private int possibleXP = pxp;
		private float enemyStats;
	}
	//Adapted online reference to be more object oriented to import into a future gui
	public gamestats(int hp, int ad, int p, int mc, int w1, int w2, int w3, int bw1, int bw2, int bw3, int c, int pa, int pc, int dj, int xpc, int xp, int ehp, int ead, int pxp) {
		playerHealth = hp;
		playerAttackDamage = ad;
		numBrews = p;
		monsterCount = mc;
		// player weapons CLOSE
		sword = w1;
		bowAndArrow = w2;
		kantana = w1;
		// player weapons RANGED
		rifle = pw3;
		grenadeLauncher = pw2;
		olReliable = pw3;
		// player currency
		playerCoins = c;
		// brews stats
		brewsHealAmount = pa;
		brewsDropChance = pc;
		dingoJuggle = dj;
		// experience stats
		xpAmountChance = xpc;
		playerXP = xp;
		// monster stats
		maxEnemyHealth = ehp;
		enemyAttackDamage = ead;
		possibleXP = pxp;
		enemyStats = random.nextFloat(); //using to randomize enemy attributes
		}
	

	public void play(String[] args) {

		String[] enemies = { "Theif", "Common Bandit", "Zombie", "Armored Titan", "Skeleton King" };
		// player stats
		

		boolean running = true;
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

			while (enemyHealth > 0 && playerHealth >= 1) {
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
}
}
