package gui.view;

import javax.swing.*;

import gui.controller.GuiAppController2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiPanel2 extends JPanel
{
	private GuiAppController2 baseController;
	private JButton firstButton;
	private JTextField firstTextField;private SpringLayout baseLayout;
	
	public GuiPanel2(GuiAppController2 baseController)
	{
		this.baseController = baseController;
		firstButton = new JButton("Don't click this button");
		firstTextField = new JTextField("You can type here");
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, firstButton, 134, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, firstButton, -70, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 79, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 159, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				firstTextField.setText("Don't click it");
			}
		});
	}
}
