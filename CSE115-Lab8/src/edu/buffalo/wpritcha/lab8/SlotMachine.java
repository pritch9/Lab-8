package edu.buffalo.wpritcha.lab8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotMachine extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3361873277689426863L;
	
	/***************/
	/** VARIABLES **/
	/***************/
	private JPanel _panel;
	private JLabel _label1;
	private JLabel _label2;
	private JLabel _label3;
	private String _imgPath = "Images/";
	private JButton _spin;
	
	
	
	
	/*******************/
	/** END VARIABLES **/
	/*******************/

	public SlotMachine(){
		super("Lab 8 ~ wpritcha");
		loadContentShit();
		init();
	}
	
	/**
	 * used to initialize and configure all the gui components
	 */
	private void loadContentShit(){
		
		/*
		 * Starting configuration: | G | R | P |
		 */
		_label1 = new JLabel(new ImageIcon(_imgPath + "Green.png"));
		_label2 = new JLabel(new ImageIcon(_imgPath + "Red.png"));
		_label3 = new JLabel(new ImageIcon(_imgPath + "Purple.png"));
		
		// Configuring the spin button
		_spin = new JButton("SPIN");
		_spin.setPreferredSize(new Dimension(100, 25));
		_spin.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				spin();
			}
			
		});
		
		// configure JPanel along with component placement
		_panel = new JPanel();
		_panel.setBackground(Color.WHITE);
		
		// Grid Bag Layout to organize into grid
		_panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		/****************************************************
		 * ______________________________________________	*
		 * |											|	*
		 * |	____    	    ____    	    ____	|	*			
		 * |	|  |			|  |			|  |	|	*
		 * |	|__|			|__|			|__|	|	*
		 * |				____________				|	*
		 * |				|          |				|	*
		 * |				|   SPIN   |				|	*
		 * |				|__________|				|	*
		 * |____________________________________________|	*
		 * 													*
		 *****************************************************/
		
		c.ipadx = 10;
		c.ipady = 10;
		c.insets = new Insets(10,10,10,10);
		
		c.gridx = 0;
		c.gridy = 0;
		_panel.add(_label1, c);
		
		c.gridx = 1;
		_panel.add(_label2, c);
		
		c.gridx = 2;
		_panel.add(_label3, c);
		
		c.gridx = 1;
		c.gridy = 1;
		_panel.add(_spin, c);
		
		// Set up JFrame
		this.add(_panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	private void init(){
		this.setVisible(true);
	}
	
	private void spin(){
		// Generate random int values [0, 3)
		int f = (int) (Math.random() * 3);
		int g = (int) (Math.random() * 3);
		int h = (int) (Math.random() * 3);
		
		// get random image icons
		ImageIcon i1 = getImageIcon(f);
		ImageIcon i2 = getImageIcon(g);
		ImageIcon i3 = getImageIcon(h);
		
		// flush images
		i1.getImage().flush();
		i2.getImage().flush();
		i3.getImage().flush();
		
		// set labels to new icons
		_label1.setIcon(i1);
		_label2.setIcon(i2);
		_label3.setIcon(i3);
		
		// Method checks winner and also performs winning actions
		checkWinner(f, g, h);
	}
	
	private ImageIcon getImageIcon(int x){
		// returns based on random number
		switch(x){
		case 0:
			return new ImageIcon(_imgPath + "Green.png");
		case 1:
			return new ImageIcon(_imgPath + "Red.png");
		case 2:
			return new ImageIcon(_imgPath + "Purple.png");
		default: 
			return null;
		}
	}
	
	private void checkWinner(int f, int g, int h){
		// f == g == h
		if(f == g && g == h){
			// Change text and disable spin button :)
			_spin.setText("You Won!");
			_spin.setEnabled(false);
		}
	}

}
