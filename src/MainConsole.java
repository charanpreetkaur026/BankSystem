/**
 * from this class main method is start
 */
class MainConsole extends Utilities{
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		Utilities utilities=new Utilities();
		SessionData.I().init();
		utilities.mainMenu();

	}
}