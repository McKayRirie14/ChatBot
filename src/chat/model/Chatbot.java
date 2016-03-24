package chatbot.model;

import java.util.ArrayList;

import chatbot.model.Chatbot;
import chatbot.view.ChatView;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part of the project.
 * 
 * @author Jared Kerr
 * @version 1.0 10/14/15
 */
public class Chatbot
{
	
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private ArrayList<String> mashList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.mashList = new ArrayList<String>();
		this.userName = userName;
		this.content = "Swoogetty";
		
		buildMemesList();
		buildPoliticalTopicsList();
		buildMashList();
	}
	
	private void buildMemesList()
	{
		
		this.memesList.add("doge");
		this.memesList.add("aliens");
		this.memesList.add("bad luck brian");
		this.memesList.add("spoderman");
		this.memesList.add("cute animals");
		this.memesList.add("me gusta");
		this.memesList.add("troll");
		this.memesList.add("rare pepe");
		this.memesList.add("what if I told you");
		this.memesList.add("unhelpful highschool teacher");
		this.memesList.add("john cena");
		
	}
	
	private void buildPoliticalTopicsList()
	{
		
		this.politicalTopicList.add("Income Tax");
		this.politicalTopicList.add("jobs");
		this.politicalTopicList.add("Women's Rights");
		this.politicalTopicList.add("Gay Rights");
		this.politicalTopicList.add("Defense of Marriage Act");
		this.politicalTopicList.add("Energy");
		this.politicalTopicList.add("Unemployment Benefits");
		this.politicalTopicList.add("Police Abuse");
		this.politicalTopicList.add("Tort Reform");
		this.politicalTopicList.add("Combat Drones");
		this.politicalTopicList.add("Hillary Clinton");
		this.politicalTopicList.add("Martin O'Malley");
		this.politicalTopicList.add("Bernie Sanders ");
		this.politicalTopicList.add("Jeb Bush");
		this.politicalTopicList.add("Ben Carson");
		this.politicalTopicList.add("Chris Christie");
		this.politicalTopicList.add("Ted Cruz");
		this.politicalTopicList.add("Carly Fiorina");
		this.politicalTopicList.add("Jim Gilmore");
		this.politicalTopicList.add("Lindsey Graham");
		this.politicalTopicList.add("Mike Huckabee");
		this.politicalTopicList.add("Bobby Jindal");
		this.politicalTopicList.add("john Kasich");
		this.politicalTopicList.add("George Pataki");
		this.politicalTopicList.add("Rand Paul");
		this.politicalTopicList.add("Marco Rubio");
		this.politicalTopicList.add("Rick Santorum");
		this.politicalTopicList.add("Donald Trump");
		this.politicalTopicList.add("Democrat");
		this.politicalTopicList.add("Republican");
		this.politicalTopicList.add("11/4/16");
		
		}
		
	private void buildMashList()
	{
		this.mashList.add("sdf");
		this.mashList.add("dfg");
		this.mashList.add("cvb");
		this.mashList.add(",./");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		
		boolean hasLength = false;
		if (currentInput != null && currentInput.length() > 0)
		{
			
			hasLength = true;
			
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		
		boolean hasContent = false;
		
		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasTopic = false;
		
		for (String currentTopic : politicalTopicList)
		{
			if (currentInput.toLowerCase().contains(currentTopic))
			{
				hasTopic = true;
			}
		}
		
		return hasTopic;
	}
	
	/**
	 * Checks to see that the supplied String value is in the current memesList
	 * variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for (String currentMeme : memesList)
		{
			if (currentInput.toLowerCase().contains(currentMeme))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
	}
	
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean hasMash = false;
		
		for (String currentMash : mashList)
		{
			if (currentInput.toLowerCase().contains(currentMash))
			{
				hasMash = true;
			}
		}
		
		return hasMash;
	}
	
	/**
	 * Processes Conversation by comparing to our lists and choosing what to say
	 * back.
	 */
	public String processConversation(String currentChat)
	{
		String returnChat = "";
		int randomTopic = (int) (Math.random() * 5); //Generates a random number between 0 and 4.
		
		switch (randomTopic)
		{
			case 0:
				if(memeChecker(currentChat))
				{
					returnChat = "That is a very popular meme this year. What else are you"
							+ " wanting to talk about?"; 
				}
				else if(politicalTopicChecker(currentChat))
				{
					returnChat = "WOW You have intrest in politics. Me TOO!!";
				}
				else
				{
					returnChat = "Thats Boring. Give me something interesting to talk about.";
				}
				break;
			case 1:
				if(politicalTopicChecker(currentChat))
				{
					returnChat = "Wow up to date are we. Well what other things are you"
							+ " intrested in?";
				}
				else if(memeChecker(currentChat))
				{
					returnChat = "MemeTASTIC HAhaHahaHahaHahaHahahahaa...";
				}
				else
				{
					returnChat = "BOOOOOOOOO!!!";
				}
				break;
			case 2:
				if(memeChecker(currentChat))
				{
					returnChat = "Tasty memes, Give me another.";
				}
				else if(politicalTopicChecker(currentChat))
				{
					returnChat = "Tasty Politics Topic, Give me another.";
				}
				else
				{
					returnChat = "Tasty NOTHIG, Give me SOMETHING TO WORK WITH!";
				}
				break;
			case 3:
				if(politicalTopicChecker(currentChat))
				{
					returnChat = "I HATE POLITICS!!!";
				}
				else if(memeChecker(currentChat))
				{
					returnChat = "I Thats Not a POLITICAL TOPIC!!!";
				}
				else
				{
					returnChat = "K";
				}
				break;
			case 4:
				returnChat = "UR FUNNY MATE";
				break;
			default:
				returnChat = "The Univers has collapsed. That sucks, lol.";
				break;
		}
		return returnChat;
	}
	
	public boolean quitChecker(String string)
	{
		boolean isQuit = false;
		
		if(string.equalsIgnoreCase("quit"))
		{
			isQuit = true;
		}
		
		return isQuit;
	}
	
	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	
}