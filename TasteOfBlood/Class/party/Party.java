package party;

import opc.Opc;
import player.*;
import read.Read;
import scenario.*;

/**
 * Class to group the other classes that implements the program (The current save slot)
 */
public class Party {
	//Class
	private Player player;
	//Player,Current Scenario,Save path
	//For new Party
	public Party() {
		player = new Player();
	}
	//For old Party
	public Party(Player p) {
		player = p;
	}
	//Getters and Setters
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player p) {
		player = p;
	}
	
	//Private Methods
	private static void chooseScenario() {
		
	}
}
