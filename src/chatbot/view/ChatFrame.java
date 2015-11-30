package chatbot.view;

import javax.swing.JFrame;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel basePanel;
	
	public ChatFrame(ChatController baseController)
	{
		this.baseController = baseController;
		basePanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(400,400);
		this.setTitle("Mr. Henrichsen's Chatbot");
		this.setVisible(true);
	}
	
	public ChatController getBaseCOntroller()
	{
		return baseController;
	}
}
