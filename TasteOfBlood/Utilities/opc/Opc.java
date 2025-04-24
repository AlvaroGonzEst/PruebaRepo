package opc;

import java.util.ArrayList;

import read.Read;

public class Opc {
	/**
	 * Displays all the numeric options in the Array<String>
	 * @param options
	 */
	public static String displayNumericOpc(String[] options) {
		String content = "";
		int cont = 1;
		for(int i=0;i<options.length;i++) {
			content+=cont+++"."+options[i]+"\n";
		}
		return content;
	}
	/**
	 * Displays all the numeric options in the Array<String> and returns a selected option
	 * @param options String[]
	 * @param min and max are inclusive
	 * @return Integer
	 */
	public static int displayReadNumericOpc(String[] options,int min,int max) {
		int opc = min-1;
		opc = Read.readInteger(displayNumericOpc(options));
		if(opc < min || opc > max) {
			System.out.println("Opción no válida");
			displayReadNumericOpc(options,min,max);
		}
		return opc;
	}
}
