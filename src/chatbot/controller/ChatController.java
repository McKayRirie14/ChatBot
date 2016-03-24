package chatbot.controller;

import twitter4j.TwitterException;
import chatbot.model.*;
import chatbot.view.*;

public class ChatbotController 
{
	private Chatbot myBot;
	private CTECTwitter chatbotTwitter;
	
	private ChatView chatView;
	private ChatFrame baseFrame;
	private ChatPanel basePanel;
	private String userName;
	
	public ChatbotController()
	{
		
		chatView = new ChatView();
		userName = chatView.getResponce("Whats your name?", "User");
		
		myBot = new Chatbot(userName);
		chatbotTwitter = new CTECTwitter(this);
		
		baseFrame = new ChatFrame(this);
		
	}
	
//	private void chat()
//	{
//		String conversation = chatView.getResponce("What would you like to talk about today?", "Somthing");
//		myBot.contentChecker(conversation);
//		while(myBot.lengthChecker(conversation))
//		{
//			conversation = myBot.processConversation(conversation);
//			conversation = chatView.getResponce(conversation, "Something");
//		}
//	}
	
	public String userToChatbot(String userText)
	{
		String responce = "ERROR=NoResponceFromChatBot";
		
		if(myBot.quitChecker(userText))
		{
			shutDown();
		}
		
		responce = myBot.processConversation(userText);
		
		return responce;
	}
	
	public void shutDown()
	{
		chatView.displayMessage("Goodbye, " + myBot.getUserName() + " it has been my pleasure to talk to you.");
		System.exit(0);
	}
	
	public void sendTweet(String tweetText)
	{
		chatbotTwitter.sendTweet(tweetText);
	}
	
	public String analyze(String userName)
	{
		try
		{
			chatbotTwitter.loadTweets(userName);
		}
		catch (TwitterException e)
		{
			return "Error - twitter load failed";
		}
		
		String userAnalysis = "The Twitter user " + userName + " has " + chatbotTwitter.topResults() + " Tweets.";
		userAnalysis = chatbotTwitter.topResults();
		return userAnalysis;
	}
	
	public void handleError(String errorMessage)
	{
		chatView.displayMessage(errorMessage);
	}
	
	public Chatbot getMyBot()
	{
		return myBot;
	}

	public void setMyBot(Chatbot myBot)
	{
		this.myBot = myBot;
	}

	public ChatView getChatView()
	{
		return chatView;
	}

	public void setChatView(ChatView chatView)
	{
		this.chatView = chatView;
	}

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}

	public ChatPanel getBasePanel()
	{
		return basePanel;
	}

	public void setBasePanel(ChatPanel basePanel)
	{
		this.basePanel = basePanel;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
}