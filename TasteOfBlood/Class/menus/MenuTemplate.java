package menus;

import java.util.ArrayList;
import java.util.Iterator;

import read.Read;

public abstract class MenuTemplate {
	//Attributes
	protected ArrayList<String> opc = new ArrayList<String>();
	protected String tittle;
	//Constructor
	public MenuTemplate(String tittle) {
		this.tittle = tittle;
	}
	//Methods
	public void showMenu() {
		showMenuCore();
	}
	private void showMenuCore() {
		Iterator<String> iterator = opc.iterator();
		System.out.println(tittle);
		int pos = 1;
		while(iterator.hasNext()) {
			System.out.println(pos+++"."+iterator.next());
		}
		//Ask Integer
		try {
			redirectTo(Read.readInteger(""));
		}catch(NumberFormatException n) {
			System.out.println("Opción invalida");
			showMenuCore();
		}
		
	}
	protected abstract void redirectTo(int opc);
}
