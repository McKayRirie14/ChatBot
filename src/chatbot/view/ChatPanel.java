package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chatbot.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		typingField = new JTextField(30);
		promptLabel = new JLabel("Chat with me");
		submitButton = new JButton("asda");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.MAGENTA);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here for the chatbot");
		chatArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//Need to do this
				//Grab user typed answer
				//display typed answer
				//send the text to chatbot
				//chatbot will process
				//display the response
				String userText = typingField.getText(); //Grab user typed answer
				chatArea.append("/nUser: " + userText); //display typed answer
				typingField.setText("");
				String response = baseController.userToChatbot(userText); //send the text to chatbot //chatbot will play
				chatArea.append("/nChatbot: " + response);			//display the response
			
			}
			
		});
	}
	
	public JTextField getTextField()
	{
		
		return typingField;
	}
}
