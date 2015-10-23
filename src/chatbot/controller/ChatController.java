package chatbot.controller;

import chat.model.Chatbot;
import chatbot.view.ChatView;

public class ChatController
{
	
	private Chatbot simpleBot;
	private ChatView display;
	
	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserInput("What is your name?"); 
		simpleBot = new Chatbot(userName);
	}
	
	public void start ()
	{
		display.showText("Hello " + simpleBot.getUserName());
	}
}


