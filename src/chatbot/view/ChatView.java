package chatbot.view;

import javax.swing.JOptionPane;
public class ChatView

{
	public String collectUserInput(String message) 
	{
		String output;
		output = JOptionPane.showInputDialog(null, message);
		
		
		return output;
		
	}
	public void showText (String message)
	{
		JOptionPane.showMessageDialog(null,message);
	}
}
