package chat.model;

import java.util.ArrayList;
import twitter4j.*; //Add the core_XXX.jar to the buildpath
import java.io.*;
import chat.controller.ChatController;

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
	
	 // Send the supplied message as a tweet.
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
	
}
