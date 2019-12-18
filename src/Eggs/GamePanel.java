package Eggs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	Image gamebkg = new ImageIcon("Assets\\bkg-easter3.png").getImage();
	Image basket = new ImageIcon("Images\\basket.png").getImage();
	Image egg = new ImageIcon("Images\\mango_egg.png").getImage();
	Image gameOverbkg = new ImageIcon("Assets\\bkg-easter1.jpg").getImage();
	Image tempbkg; // temporary background
	Image enemyEgg1 = new ImageIcon("Assets\\ton_face.png").getImage();
	Image enemyEgg2 = new ImageIcon("Assets\\wow_face.png").getImage();
	Image enemyEgg3 = new ImageIcon("Assets\\surprise_face.png").getImage();
	Image enemyEgg4 = new ImageIcon("Assets\\embar_face.png").getImage();
	
	//Image [] img = new ImageIcon("Assets\\ton_face.png", "Assets\\wow_face.png").getImage();

	int x_basket, y_basket; // basket x and y coordinates
	int x_egg, y_egg; // x and y coord of egg
	Random rand = new Random(); // for randomizing xcoord of eggs

	JLabel time;
	JLabel points;

	int pointsCount = 0; // for counting points
	int timeleft = 45; // to show remaining time
	int counter = 0; // to decrement time slowly

	boolean gameOver = false; // to check if the game is over

	GamePanel() {

		setLayout(null);
		setFocusable(true);
		tempbkg = gamebkg;

		x_basket = 450;
		y_basket = 600;
		x_egg = (int) rand.nextInt(1000);
		y_egg = 0;


		time = new JLabel("Time: 30");
		time.setBounds(450, 5, 50, 20); // setting the time label on screen

		points = new JLabel("Points: 0");
		points.setBounds(510, 5, 100, 20);

		/* adding both components in jpanel */
		add(time);
		add(points);

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {

				if (ke.getKeyCode() == ke.VK_LEFT & x_basket > 10) {
					x_basket -= 10;
					repaint(); // redraw at new position in the left side
				}
				if (ke.getKeyCode() == ke.VK_RIGHT & x_basket < 1000) {
					x_basket += 10; // redraw at new position to the right
					repaint();
				}
			}// end keypressed
		});
	}// end constructor

	void fallEgg() {
		if (y_egg >= 550) { // when one egg has completely fallen
			y_egg = 0; // set the y cord of next egg to 0
			x_egg = rand.nextInt(1000); // randomize next eggs x coord

		} else
			y_egg++; // otherwise fall the egg down

//		if (pointsCount >= 10) {
//			String[] images = new String[] { "embar_face.png", "ton_face.png", "wow_face.png", "Surprice_face.png" };
//			int index = (int) (Math.random() * (images.length - 1));
//			JLabel MyImage = new JLabel(new ImageIcon(images[index]));
//			repaint();
			
//			OR
//			int randomImg = rand.nextInt((max - min) + 1) + min;
//			JLabel MyImage = new JLabel(new ImageIcon("image" + randomImg + ".png"));
		}

	


	void updateTime() {
		counter++;
		if (counter == 100) // we count to 60 and then dec timeleft by 1 for slowing speed
		{
			timeleft--; // dec time left after 60 counts
			counter = 0; // reset counter
		}
		time.setText("Time:" + timeleft);
	}// end updateTime

	void detectCollision() {
		Rectangle basketRect = new Rectangle(x_basket, y_basket, 100, 65); // making a rectangle on the basket
		Rectangle eggRect = new Rectangle(x_egg, y_egg, 40, 60); // making a rectangle on egg

		if (eggRect.intersects(basketRect)) {
			pointsCount += 5; // give 5 points on each catch
			points.setText("Points:" + pointsCount); // set the count
			y_egg = 0; // for next egg
			x_egg = rand.nextInt(500); // again randomizing x axis of egg

			x_egg = rand.nextInt(500);
			x_egg = rand.nextInt(500);

		}
	}// end collision detection

	// Fix the Game Over condition
	void checkGameOver() {
		if (timeleft <= 0) {
			JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
			tempbkg = gameOverbkg;
			yourScore.setBounds(100, 100, 200, 100);
			gameOver = true;
			yourScore.setForeground(Color.WHITE);
			add(yourScore);
		}
	}// end gameOver

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(tempbkg, 0, 0, null); // game background

		checkGameOver();

		if (gameOver == false) {
			setFocusable(true);
			grabFocus();
			updateTime();

			fallEgg();
			detectCollision();
			
			g2d.drawImage(egg, x_egg, y_egg, null);
			g2d.drawImage(egg, x_egg, y_egg, null);

			g2d.drawImage(egg, x_egg, y_egg, null); // drawing egg at new position
			g2d.drawImage(basket, x_basket, y_basket, null); // drawing basket
		}
		repaint();
	}// end paintComponent

	public static void main(String args[]) {
		new EasterEggs();// making an object
	}// end main
}// end class
