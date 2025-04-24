package main;

import bbdd.*;
import menus.*;
import party.Party;
import scenario.*;

public class TasteOfBlood {
	//Attributes
	private static BD_Taste BBDD = new BD_Taste("Taste");
	private static Party party;
	/**
	 * Program main node
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuPrincipal("Seleccione una opción");
		
		
		//new Scenario00();
	}
	
	
	//Getters And Setters
	public static Party getParty() {
		return party;
	}
	public static void setParty(Party p) {
		party = p;
	}
	
	public static BD_Taste getBBDD() {
		return BBDD;
	}

}
