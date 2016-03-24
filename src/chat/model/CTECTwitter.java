package chatbot.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chatbot.controller.ChatbotController;
import twitter4j.*;

/**
 * @author jker3169
 * @version 0.5
 * 
 * this is the twitter interaction class
 * in this class I use what i've learned about api's to
 * 
 */
public class CTECTwitter
{
	private ChatbotController baseController;	
	private Twitter chatbotTwitter;
	
	private ArrayList<Status> statuses;
	private ArrayList<String> wordList;
	
	public CTECTwitter(ChatbotController baseController)
	{		
		this.baseController = baseController;
		chatbotTwitter = TwitterFactory.getSingleton();
		
		statuses = new ArrayList<Status>();
		wordList = new ArrayList<String>();
		
		
		
	}
	
	public void sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus("I, Jared, just tweeted from my Java Chatbot program!"
					+ " #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch (TwitterException error)
		{
			baseController.handleError(error.getErrorMessage());
		}
		
	}
	
	public void loadTweets(String twitterHandle) throws TwitterException
	{
		wordList.clear();
		statuses.clear();
		
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while(page <= 10)
		{
			statusPage.setPage(page);
			statuses.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for(Status currentStatus: statuses)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for(String word: tweetText)
			{
				wordList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordList);
		removeEmptyText();
		
	}

	private void removeEmptyText()
	{
		for(int spot = 0; spot < wordList.size(); spot++)
		{
			if(wordList.get(spot).equals(""))
			{
				wordList.remove(spot);
				spot--;
			}
		}
	}

	private List removeCommonEnglishWords(ArrayList<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		int count = 0;
		while(count < wordList.size())
		{
			for(int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if(wordList.get(count).equals(boringWords[removeSpot]))
				{
					wordList.remove(count);
					removeSpot = 0;
				}
				
			}
			count++;
		}
//		removewitterUsernamesFromList(wordList);
		return wordList;
	}

	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		
		Scanner wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		while(wordFile.hasNext())
		{
			wordCount++;
			wordFile.next();
		}
		wordFile = new Scanner(getClass().getResourceAsStream("commonWords.txt"));
		boringWords = new String[wordCount];
		int boringWordCount = 0;
		while(wordFile.hasNext())
		{
			boringWords[boringWordCount] = wordFile.next();
			boringWordCount++;
		}
		wordFile.close();
		
		return boringWords;
		
	}
	
	public String topResults()
	{
		String tweetResults = "";
		
		int topWordLocation = 0;
		int topCount = 0;
		
		for(int index = 0; index < wordList.size(); index++)
		{
			int wordUseCount = 1;
			
			for(int spot = index+1; spot < wordList.size(); spot++)
			{
				if(wordList.get(index).equals(wordList.get(spot)))
				{
					wordUseCount++;
				}
				if(wordUseCount > topCount)
				{
					topCount = wordUseCount;
					topWordLocation = index;
				}
			}
		}
		
		tweetResults = "The top word in the tweets was " + wordList.get(topWordLocation) + " and it was used " + topCount + " times!";
		return tweetResults;
	}

	private String removePunctuation(String word)
	{
		//Declare what to remove from the words
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		
		//Create the scrubbed word and begin the loop
		String scrubbedString = "";
		for(int i = 0; i < word.length(); i++)//For every char in word
		{
			if(punctuation.indexOf(word.charAt(i)) == -1)//If the char is not in the list of chars to be removed
			{
				scrubbedString += word.charAt(i);//Add any good characters
			}
			
		}
		return scrubbedString;//Return the scrubbed word
	}
	
}