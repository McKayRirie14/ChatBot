package chat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	private void removeEmptyText()
	{
		for (int spot = 0; spot < wordList.size(); spot++)
		{
			if (wordList.get(spot).equals(""))
			{
				wordList.remove(spot);
				spot--;
			}
		}
	}
	
	private List removeCommonEnglishWords(List<String>wordList)
	{
		String[] boringWords = importWordsToArray();
		
		for (int count = 0; count < wordList.size(); count++)
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length; // Exit the inner loop.
				}
			}
		}
		//Comment this if you want to keep Twitter usernames in your word list.
		removeTwitterUsernamesFromList(wordList);
		
		return wordList;		
		
	}
	
	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile.reset();
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
		}
		catch (FileNotFoundExeption e)
		{
			return new String[0];
		}
		return boringWords;
	}
	
	/**
	 * Creates the statistics about the tweets.
	 * @param wordList The supplied list of words.
	 * @return A String containing the name of the user.
	 * 
	 */
}
