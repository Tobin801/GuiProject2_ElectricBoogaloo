package gui.view;

import javax.swing.JFrame;
import gui.controller.GuiAppController2;

public class GuiFrame2 extends JFrame
{
	private GuiAppController2 baseController;
	private GuiPanel2 basePanel;
	
	public GuiFrame2(GuiAppController2 baseController)
	{
		this.baseController = baseController;
		basePanel = new GuiPanel2(baseController);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setResizable(false);
		this.setTitle("My window app");
		this.setSize(1200, 750);
		this.setVisible(true);
	}
}
