package marshmallowMonster.view;

import javax.swing.JOptionPane;

public class GuiController {
	
	public void displayText(String text){
		JOptionPane.showMessageDialog(null, text);
	}
	
	public String displayQuestion(String text){
		return JOptionPane.showInputDialog(null, text);
	}
	
}
