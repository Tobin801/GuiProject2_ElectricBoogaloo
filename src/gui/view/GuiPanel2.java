package gui.view;

import javax.swing.*;
import java.awt.event.*;
import gui.controller.GuiAppController2;
import java.awt.Color;


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
		
		this.addMouseListener(new MouseListener()
		{
			public void mouseClicked(MouseEvent clicked)
			{
//				changeRandomColor();
				if(SwingUtilities.isLeftMouseButton(clicked))
				{
					firstTextField.setText("you left clicked");
				}
				else if(SwingUtilities.isRightMouseButton(clicked))
				{
					firstTextField.setText("you right clicked");
				}
			}
			
			public void mouseReleased(MouseEvent released)
			{
				changeRandomColor();
			}
			
			public void mousePressed(MouseEvent pressed)
			{
				
			}
			
			public void mouseEntered(MouseEvent entered)
			{
//				changeRandomColor();
			}
			
			public void mouseExited(MouseEvent exited)
			{
//				changeRandomColor();
			}
		});
		
		this.addMouseMotionListener(new MouseMotionListener()
		{
			public void mouseMoved(MouseEvent moved)
			{
				firstButton.setText("Mouse X: " + moved.getX() + " Mouse Y: " + moved.getY());
				if((moved.getX() > 25 && moved.getX() < 40) && (moved.getY() > 50 && moved.getY() < 70))
				{
					changeRandomColor();
				}
			}
			
			public void mouseDragged(MouseEvent dragged)
			{
				if(dragged.isAltDown())
				{
					firstTextField.setText("you held alt and dragged!");
				}
			}
		});
	}
	
	private void changeRandomColor()
	{
		int red, green, blue;
		
		red = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		blue = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, green, blue));
	}
}
