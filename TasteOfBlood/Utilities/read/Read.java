package read;

import java.util.Scanner;
/**
 * Read class to read Parameters
 */
public class Read {
	static Scanner sc = new Scanner(System.in);
	
	//Only read and return
	/**
	 * Reads and returns a String type parameter
	 * @param content
	 * @return String
	 */
	public static String readString(String content) {
		System.out.println(content);
		return sc.nextLine();
	}
	/**
	 * Reads and returns a Integer type parameter
	 * @param content
	 * @return String
	 */
	@SuppressWarnings("finally")
	public static int readInteger(String content) {
		int opc = 0;
		try {
			opc = Integer.parseInt(readString(content));
		}catch(NumberFormatException e) {
			System.out.println("Opción no válida");
			readInteger(content);
		} finally {
			return opc;
		}
	}
}
