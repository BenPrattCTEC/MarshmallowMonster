package marshmallowMonster.view;

import javax.swing.JOptionPane;

public class GuiController {
	
	public static void displayText(String text){
		JOptionPane.showMessageDialog(null, text);
	}
	
	public static String displayQuestion(String text){
		return JOptionPane.showInputDialog(null, text);
	}
	
}
