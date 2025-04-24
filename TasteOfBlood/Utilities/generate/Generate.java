package generate;

import java.util.Random;

public class Generate {
	static Random r = new Random();
	/**
	 * Generates an unique hex number
	 * @return
	 */
	public static String generateHex() {
		//Hexadecimal 000000 Puede ser números o Letras
		final int length = 6;
		String hexadecimal = "#";
		
		for(int i=0;i<length;i++) {
			switch(r.nextInt(1,3)) {
			//Number
			case 1:
				hexadecimal+=generateInt();
				break;
			//Character
			case 2:
				hexadecimal+=generateChar();
				break;
			}
		}
		return hexadecimal;
	}
	
	/**
	 * Generates a random Upper Char between A-Z
	 * @return
	 */
	public static char generateChar() {
		return (char)r.nextInt(65,71);
	}
	
	/**
	 * Generates a random Int between 0 and 9
	 * @return
	 */
	public static int generateInt() {
		return r.nextInt(0,10);
	}
}
