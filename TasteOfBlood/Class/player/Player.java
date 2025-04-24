package player;

import generate.Generate;
import opc.Opc;
import read.Read;
import scenario.*;

public class Player {
	private String name,soul;
	//For new Players
	public Player() {
		setName();
		setSoul();
	}
	//For old Players
	public Player(String name, String soul) {
		this.name = name;
		this.soul = soul;
	}
	//Getters
	public String getName() {
		return name;
	}
	public String getSoul() {
		return soul;
	}
	//Setters
	/**
	 * Initial Name Selector
	 */
	private void setName() {
		name = Read.readString("¿Cuál será el nombre de su personaje?");
	}
	/**
	 * Initial Soul Selector
	 */
	private void setSoul() {
		String Hex = Generate.generateHex();
		System.out.println("Un haz de luz se abre paso frente a ti, el entorno es devorado por aquello que creías sostener.\n"
				+ "No hay miedo que valga cuando el vacío se abre paso. A través del ruido diferencias códigos y patrones.\n"
				+"'"+Hex+"' es tu respuesta, o la llave.\n");
		String[] Souls = {"Valor","Perseverancia","Liderazgo"};
		soul = Souls[selectSoul(Hex)];
		
	}
	
	
	//Private Methods
	/**
	 * Returns an Integer type parameter exclusive for the Soul selector calculating the main color on the Hex code
	 * @param Hex
	 * @return Integer
	 */
	private int selectSoul(String Hex) {
		int red,green,blue;
		
		red = Integer.parseInt(Hex.substring(1,3),16);
		green = Integer.parseInt(Hex.substring(3,5),16);
		blue = Integer.parseInt(Hex.substring(5,7),16);
		
		if(red>green&&red>blue) {
			return 0;
		}
		else if(green>red&&green>blue) {
			return 1;
		}
		else {
			return 2;
		}
		
	}
}
