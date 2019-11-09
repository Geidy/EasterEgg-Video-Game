package Eggs;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class EasterEggs extends JFrame{
	
	static MenuPanel mp = new MenuPanel();
	static HelpPanel hp = new HelpPanel();
	static GamePanel gp = new GamePanel();
 
	static CardLayout cl = new CardLayout();
	static JPanel cards = new JPanel(); // to contain the panels as cards
 
	EasterEggs(){
 
		cards.setLayout(cl);// setting the layout to cardlayout
		cards.add(mp, "MenuPanel");
		cards.add(hp, "HelpPanel");
		cards.add(gp, "GamePanel");
		cl.show(cards, "MenuPanel");
		add(cards); //adding the panel with cardlayout in JFrame
 
		setTitle("Easter Eggs");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 700); //frame size
		setVisible(true);   //frame visibility	
	}//end constructor

}
