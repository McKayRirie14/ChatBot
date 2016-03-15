package chat.model;

import java.util.ArrayList;
import java.util.List;

import twitter4j.*; //Add the core_XXX.jar to the buildpath

import java.io.*;

import chatbot.controller.ChatController;

/**@author mrir2917
 * @version 0.2
 * 
 * this is the twitter interaction class
 * in this class I use what i've learned about opi's to
 *  
 */
public class CTECTwitter
{
	private Twitter chatbotTwitter;
	private List<Status> statuses;
	private List<String> tweetTexts;
	
	public CTECTwitter()
	{
		chatbotTwitter = TwitterFactory.getSingleton();
		statuses = new ArrayList<Status>();
		tweetTexts = new ArrayList<String>();
		
	}
	
	 /**
	  * Send the supplied message as a tweet.
	  * @param tweet The supplied String.
	  */
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("");
		}
		catch(TwitterExeption error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
	}
	
	public void loadTweets(String twitterHane) throws TwitterExeption
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus : statuses)
		{
			String[] tweetText = currentStatus.getText().split("");
			for (String word : tweetText)
			{
				tweetTexts.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(tweetTexts);
		removeEmptyText();
	}
	
	private String removePunctuation(String currenString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>"; //think about adding
													// hashtag and @
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++) 
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
			
		}
		return scrubbedString;
	}
	
	/**
	 * Creates the statistics about the tweets.
	 * @param wordList The supplied list of words.
	 * @return A String containing the name of the user.
	 * 
	 */
}
