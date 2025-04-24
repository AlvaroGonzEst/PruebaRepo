package scenario;

import java.util.Random;

public class Scenario_Template {
    
	//Generates the map
	/**
	 * Generates the initial map
	 */
	static {
		number_scenario = 3;
		r = new Random();
    	Map = generateMap();
    }
	//Static final parameters
	
	private final static int number_scenario;
	private static Random r;
	// Attributes
    protected String portrait, description, tittle,icon;
    protected static int height;
	protected static int width;
    protected static Scenario_Template[][] Map;
    // Constructor
    public Scenario_Template() {
    }

    // Methods
    // Show the Scenario Map
    /**
     * Sets the initial Matrix Map 
     */
    private static void setMap() {
        int cont;
        for (int h = 0; h < height; h++) {
            cont = 0;
            for (int w = 0; w < width; w++) {
            	//Sets a random cells
            	Map[h][w] = setCell(r.nextInt(number_scenario)+1);
                cont++;
            }
        }
    }
    /**
     * Sets an cell depending of the number specified by Integer type parameter:
     * 
     * 0 = Valley
     * 1 = Forest
     * 2 = River
     * 
     * @param int
     */
    private static Scenario_Template setCell(int type) {
    	Scenario_Template temp = null;
    	switch(type) {
    	case 1:
    		temp = new Scenario_Valley();
    		break;
    	case 2:
    		temp = new Scenario_Forest();
    		break;
    	case 3:
    		temp = new Scenario_River();
    		break;
    	}
    	return temp;
    }
    //Show Methods
    /**
     * Shows all the Scenario method
     */
    public void showAllScenario() {
    	showUI();
    	showMap();
    }
    // Show the generated map
    /**
     * Shows the Matrix Map
     */
    public static void showMap() {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                System.out.print(Map[h][w].getIcon() + " ");
            }
            System.out.println();
        }
    }
    // Show the Scenario UI
    /**
     * Shows the UI of the Scenario
     */
    public void showUI() {
        System.out.println(tittle + "\n" + portrait + "\n" + description);
    }





    // Getters for specific parameters
    /**
     * Gets the String Type Portrait
     * @return String
     */
    public String getPortrait() {
        return portrait;
    }
    /**
     * Gets the String Type Description
     * @return String
     */
    public String getDescription() {
        return description;
    }
    /**
     * Gets the String Type Tittle
     * @return String
     */
    public String getTittle() {
        return tittle;
    }
    public String getIcon() {
    	return icon;
    }
    public static Scenario_Template[][] getMap() {
		return Map;
	}

	// Random Map Generator
    /**
     * Generates the Matrix Object Type Map
     * @return Object[][]
     */
    private static Scenario_Template[][] generateMap() {
        Random r = new Random();
        // Set random height and width
        height = r.nextInt(8)+4;
        width = r.nextInt(8)+4;
        Map = new Scenario_Template[height][width];
        setMap();
        return Map;
    }
}
