package chatbot.controller;

import chat.model.Chatbot;
import chatbot.view.ChatView;
import chatbot.view.ChatFrame;

public class ChatController
{
	/**
	 * Controller for the Chatbot project.
	 * @author Mckay Ririe
	 * @version 1.2 10/23/15 Displays the Chatbot's userName variable.
	 */
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;
	
	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserText("What is your name?"); 
		simpleBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
	}
	
	public void start ()
	{
		display.displayText("Hello " + simpleBot.getUserName());
		chat();
		
	}
	
	private void chat()
	{
		String conversation = display.collectUserText("What would you like to talk about today?");
		//while(simpleBot.lengthChecker(conversation))
		//{
		//	conversation = simpleBot.processConversation(conversation);
		//	conversation = display.collectUserText(conversation);
		//}
	}
	
	public String userToChatbot(String userText)
	{
		String response = "";
		
		if(simpleBot.quitChecker(userText))
		{
			shutDown();
		}
		response = simpleBot.processConversation(userText);
		
		return response;
	}
	
	private void shutDown()
	{
		display.displayText("Goodbye, " + simpleBot.getUserName() + " it has been my pleasure to tallk with you today! ;) ");
		System.exit(0);
	}
	
	public Chatbot getChatbot()
	{
		return simpleBot;
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	public ChatFrame getbaseFrame()
	{
		return baseFrame;
	}
	
	
}



