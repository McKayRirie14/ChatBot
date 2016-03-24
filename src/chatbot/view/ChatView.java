package chatbot.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * popup display class for GUI interatcion in the chatbot project
 * @author jker3169
 *@version 1.3 11/5/15 Added Icons to popup windows!
 */
public class ChatView 
{
	
	private String windMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windMessage = "Hello from your friendly chatbot :D";
		chatIcon = new ImageIcon(getClass().getResource("images/AppIcon.png"));
	}
	
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message,windMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}
	
	public String getResponce(String message, String textDefault)
	{
		String output = "";
		
		output = JOptionPane.showInputDialog(null, message, windMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, textDefault) + " ";
		
		return output;
	}
	
}
