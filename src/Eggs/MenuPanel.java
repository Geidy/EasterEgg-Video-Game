package Eggs;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {
	
	JButton play = new JButton("");
	JButton help = new JButton("");
	JButton exit = new JButton("");
	
	Image bkgEaster = new ImageIcon("Assets\\bkg-easter3.png").getImage();  //menu background
	 
	/* Setting icons on buttons */
	ImageIcon playbtn = new ImageIcon("buttons\\play.png"); 
	ImageIcon helpbtn = new ImageIcon("buttons\\help.png");
	ImageIcon exitbtn = new ImageIcon("buttons\\exit.png");
 
	JPanel center = new JPanel();
	



MenuPanel(){
	 
	center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); //setting box layout 
	add(center); //adding the panel to another JPanel

	/* setting icons on buttons */
	play.setIcon(playbtn); 
	help.setIcon(helpbtn);
	exit.setIcon(exitbtn);

	/* adding the buttons in the panel */
	center.add(play);
	center.add(help);
	center.add(exit);

	/* adding mouseListeners on buttons */
	play.addMouseListener(new Click());
	help.addMouseListener(new Click());
	exit.addMouseListener(new Click());

}//end constructor

class Click extends MouseAdapter{ //internal friendly class
	 
	public void mouseClicked(MouseEvent me){
		if(me.getSource()== play){
			EasterEggs.cl.show(EasterEggs.cards, "GamePanel"); //show gamePanel when play is clicked
		}
		if(me.getSource()== help){
			EasterEggs.cl.show(EasterEggs.cards, "HelpPanel"); //show helpPanel when help is clicked
		}	
		if(me.getSource()== exit){
			System.exit(0);  //exit application when exit is clicked
		}
	}//end mouseClick
}//end mouseAdapter

public void paintComponent(Graphics g){
	super.paintComponent(g); //calling the super class functions
	Graphics2D g2d = (Graphics2D)g; //casting to graphcis2D
	setFocusable(true);		 //setting the focus on the panel
 
	g2d.drawImage(bkgEaster, 0, 0, null); //draw menu image
	repaint();
   }//end paintComponent
}//end GamePanel