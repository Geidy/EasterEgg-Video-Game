package Eggs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{
	

	Image helpbkg = new ImageIcon("Images\\helpbkg.png").getImage(); //help image background
	JButton back = new JButton("Back"); //back button
 
	HelpPanel(){
	setFocusable(true); //setting the focus
	add(back);	     	  //adding back button in the panel
 
	back.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent me){
		    EasterEggs.cl.show(EasterEggs.cards, "MenuPanel"); // show menuPanel when back button is clicked
			}	
	      });
	}//end constructor
 
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(helpbkg, 0,0, null); // draw help background
		repaint();
	}//end paintComponent
}//end class

