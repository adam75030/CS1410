package lab10;

import java.util.ArrayList;

/**
 * Simulate a battle between multiple spell casters, printing out
 * the results of the battle.
 * 
 * This class demonstrates how, with the power of interfaces, you
 * can have an interesting program that doesn't need to know
 * about the particulars of the classes implementing the interface.
 * 
 * @author Prof. Martin
 * @version Lab 10
 */
public class SpellCasterGame {
	/**
	 * Running this main method simulates the game. You can run different
	 * versions of the game by updating the contestants variable and
	 * then re-running the program.
	 */
	public static void main(String[] args) {
		ArrayList<SpellCaster> contestants = new ArrayList<SpellCaster>();
		// *** TODO: Students, edit this to add your / your partner's SpellCasters to the list ***
		// contestants.add(CONSTRUCT A NEW SPELL CASTER);
		// contestants.add(CONSTRUCT A NEW SPELL CASTER);
		// contestants.add(CONSTRUCT A NEW SPELL CASTER);
		// contestants.add(CONSTRUCT A NEW SPELL CASTER);
		// contestants.add(CONSTRUCT A NEW SPELL CASTER);
		// contestants.add(CONSTRUCT A NEW SPELL CASTER);
		
		// For TAs:
		contestants.add(new Warrior());
		contestants.add(new Healer());
		contestants.add(new Wizard());

		
		
		// *** NO NEED TO EDIT ANYTHING BELOW THIS LINE ***
		// Have the contestants battle until only one remains
		while(contestants.size() > 1) {
			System.out.println("***** NEW ROUND: " + contestants + " *****");
			ArrayList<SpellCaster> winners = new ArrayList<SpellCaster>();
			for(int contestantIndex = 0; contestantIndex < contestants.size(); contestantIndex += 2) {
				SpellCaster contestant = contestants.get(contestantIndex);
				
				// contestant should battle the next index in the ArrayList, if possible
				if (contestantIndex < contestants.size() - 1) {
					SpellCaster opponent = contestants.get(contestantIndex + 1);
					winners.add(determineWinner(contestant, opponent));
				}
				else {
					System.out.println("No opponents remaining, " + contestant + " continues to the next round");
					winners.add(contestant);
				}
			}
			System.out.println();
			contestants = winners; // Start the next round with only the winners
		}
		System.out.println("***** " + contestants.get(0) + " is the winner! *****");
	}
	
	/**
	 * Battles caster1 vs caster2 and returns the winner of their fight.
	 */
	private static SpellCaster determineWinner(SpellCaster caster1, SpellCaster caster2) {
		while(true) { // Run until there is a winner
			System.out.println("*** " + caster1 + " attacks " + caster2 + " ***");
			int damage = caster1.doDamage();
			System.out.println("* " + caster1 + " does " + damage + " damage *");
			if(caster2.takeAHit(damage)) {
				System.out.println("*** " + caster1 + " is victorious! ***");
				return caster1;
			}
			System.out.println("*** " + caster2 + " attacks " + caster1 + " ***");
			damage = caster2.doDamage();
			System.out.println("* " + caster2 + " does " + damage + " damage *");
			if(caster1.takeAHit(damage)) {
				System.out.println("*** " + caster2 + " is victorious! ***");
				return caster2;
			}
		}
	}
}
