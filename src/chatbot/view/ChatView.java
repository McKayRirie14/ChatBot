package chatbot.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Popup display class for GUI interaction in the Chatbot project
 * @author mrir2917
 * @version 1.3 11/5/15 Added Icons to popup windows!
 */
public class ChatView
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "Hello from your friendly chatbot :D";
		chatIcon = new ImageIcon(getClass().getResource("images/LOL.jpg"));
	}
	
	
	/**
	 * Displays a GUi poopup for collecting user text with the supplied String.
	 * Usually in the form of a question to collect or further use in the program.
	 * @param displayText The Text to show in the popup window. Should be a question
	 * @return The text supplied by the user.
	 */
	
	public String collectUserText(String displayText) 
	{
		String userInput = "";
		
		userInput = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon, null, "Answer here :)").toString();
		
		return userInput;	
	}
	
	/**
	 * Displays a String to the user with a standard popup.
	 * @param displayText(String displayText The supplied text to be displayed.
	 */
	public void displayText (String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, JOptionPane.INFORMATION_MESSAGE, chatIcon);
	}
}
