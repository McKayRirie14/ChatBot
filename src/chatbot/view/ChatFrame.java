package chatbot.view;

import javax.swing.JFrame;
import chatbot.controller.ChatbotController;
import chatbot.view.ChatPanel;

public class ChatFrame extends JFrame
{
	private ChatbotController baseController;
	private ChatPanel basePanel;
	
	private ChatFrame(){}
	
	public ChatFrame(ChatbotController baseController)
	{
		this.baseController = baseController;
		this.basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(600, 530);
		this.setTitle("ChatBot");
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public ChatbotController getBaseController()
	{
		return baseController;
	}
	
}
