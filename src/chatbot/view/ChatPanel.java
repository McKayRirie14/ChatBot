package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
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
	private JScrollPane textPane;
	private JButton tweetButton;
	private JButton saveButton;
	private JButton loadButton;
	
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,25);
		typingField = new JTextField(25);
		testButton = new JTextField(25);
		promptLabel = new JLabel("Chat with me");
		submitButton = new JButton("asda");
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		textPane = new JScrollPane(chatArea);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 20, SpringLayout.North, this);
		baseLayout.putConstraint(SpringLayout, c1, pad, e2, c2);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(testButton);
		this.add(textPane);
		//DO NOT HAVE the line this.add(chatArea)
		this.add (typingField);
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
