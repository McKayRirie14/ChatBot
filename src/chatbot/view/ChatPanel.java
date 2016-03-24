
package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import chatbot.controller.ChatbotController;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ChatPanel extends JPanel
{
	private ChatbotController baseController;
	private SpringLayout baseLayout;
	private SpringLayout buttonLayout;
	private JTextField typingField;
	private JTextArea chatArea;
	private JButton enterButton;
	private JButton quitButton;
	private JButton analyzeTwitterButton;
	private JButton twitterButton;
	private JScrollPane scrollPane;
	private String userName;
	private JPanel buttonPanel;
	
	public ChatPanel(ChatbotController baseController)
	{
		this.baseController = baseController;
		
		this.userName = baseController.getUserName();
		
		this.baseLayout = new SpringLayout();
		this.buttonLayout = new SpringLayout();
		this.typingField = new JTextField();
		this.typingField.setColumns(10);
		this.typingField.setToolTipText("Type Here"); 
		this.enterButton = new JButton("Enter");
		this.buttonPanel = new JPanel();
		this.quitButton = new JButton("Quit");
		this.twitterButton = new JButton("Tweet");
		this.analyzeTwitterButton = new JButton("Analyze Tweet");

		
		
		setupChatPane();		
		setupPanel();
		setupLayout();
		setupListeners();
		changeRandomColor();
		
	}
	
	private void setupChatPane()
	{
		chatArea = new JTextArea();
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
		chatArea.append("  Chatbot: Hello " + userName);
		scrollPane = new JScrollPane(chatArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(typingField);
		this.add(enterButton);
		this.add(scrollPane);
		this.add(buttonPanel);
		
		this.buttonPanel.setLayout(buttonLayout);
		this.buttonPanel.add(quitButton);
		this.buttonPanel.add(twitterButton);
		this.buttonPanel.add(analyzeTwitterButton);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -30, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, scrollPane, -50, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, buttonPanel, -10, SpringLayout.NORTH, typingField);
		baseLayout.putConstraint(SpringLayout.NORTH, buttonPanel, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, buttonPanel, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, buttonPanel, -6, SpringLayout.WEST, scrollPane);
		baseLayout.putConstraint(SpringLayout.SOUTH, enterButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 6, SpringLayout.EAST, enterButton);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 10, SpringLayout.SOUTH, scrollPane);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, 0, SpringLayout.EAST, scrollPane);
		baseLayout.putConstraint(SpringLayout.WEST, scrollPane, 150, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, enterButton, 20, SpringLayout.WEST, this);
		
		buttonLayout.putConstraint(SpringLayout.NORTH, quitButton, 10, SpringLayout.NORTH, buttonPanel);
		buttonLayout.putConstraint(SpringLayout.WEST, quitButton, 5, SpringLayout.WEST, buttonPanel);
		buttonLayout.putConstraint(SpringLayout.NORTH, twitterButton, 10, SpringLayout.SOUTH, quitButton);
		buttonLayout.putConstraint(SpringLayout.WEST, twitterButton, 5, SpringLayout.WEST, buttonPanel);
		buttonLayout.putConstraint(SpringLayout.NORTH, analyzeTwitterButton, 10, SpringLayout.SOUTH, twitterButton);
		buttonLayout.putConstraint(SpringLayout.WEST, analyzeTwitterButton, 5, SpringLayout.WEST, buttonPanel);
	}
	
	private void setupListeners()
	{
		enterButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent acion)
			{
				enterPressed();

			}
			
		});
		
		quitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				baseController.shutDown();
			}
		});
		
		twitterButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent action)
			{
				//ToDo Add Controllers Twitter call
				baseController.sendTweet("no text to send");
			}
		});
		
		analyzeTwitterButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				String user = typingField.getText();
				String results = baseController.analyze(user);
				chatArea.append("\n  Chatbot: " + results);
			}
			
		});
		
		typingField.addKeyListener(new KeyListener()
		{

			@Override
			public void keyTyped(KeyEvent key)
			{
				
				
			}

			@Override
			public void keyPressed(KeyEvent key)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent key)
			{
				int keyCode = key.getKeyCode();
				int KeyCompare = KeyEvent.VK_ENTER;
				if(keyCode == KeyCompare)
				{
					enterPressed();
				}
				
			}
			
		});
		
	}
	
	private void changeRandomColor()
	{
		int red, blue, green;
		red = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}

	private void enterPressed()
	{
		String userText = typingField.getText(); //Grab user typed answer
		if(userText.equals("") == false)
		{
			chatArea.append("\n"+ userName + ": " + userText); //display typed answer
			typingField.setText(""); 
			String responce = baseController.userToChatbot(userText); //send the text to chatbot
			//chatbot will process
			chatArea.append("\n  Chatbot: " + responce); //display the response
		}
	}
	
	public JComponent getTextField()
	{
		return typingField;
	}
}
