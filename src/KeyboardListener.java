import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class KeyboardListener extends JFrame implements KeyListener{
	//Variables
	final private int WIDTH = 300;
	final private int HEIGHT = 300;
	final private int ROWS = 16;
	final private int COLS = 16;
	final private int GAP = 2;
	private Color tileColor = Color.WHITE;
	private Color paintedColor = Color.BLACK;
	private Color playerColor = Color.YELLOW;
	//Current position of player
	private int initialROW = 0;
	private int initialCOL = 0;
	
	//2d array for the grid
	private JPanel pane = new JPanel(new GridLayout(ROWS, COLS, GAP, GAP));
	private JPanel[][] panel = new JPanel[ROWS][COLS]; //makes a 2d array of 16x16
	private Color[][] colorArray = new Color[ROWS][COLS]; //color array
	//Constructor ===============================================================================
	public KeyboardListener() {
		super("Pixel Painter");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(pane);
		
		//Makes the background grid
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				panel[x][y] = new JPanel(); //Inits the panel
				colorArray[x][y] = Color.WHITE;
				pane.add(panel[x][y]);
				panel[x][y].setBackground(colorArray[x][y]);
			}
		}
		
		//Set where the player is 
		panel[initialROW][initialCOL].setBackground(playerColor);
		
		//Set keyboard listener
		addKeyListener(this);
		
	}
	
	//Keyboard Listener events ==================================================================
	@Override
	public void keyTyped(KeyEvent ke) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		int keyCode = ke.getKeyCode();
		int prevROW = 0;
		int prevCOL = 0;
		boolean change = false;
		//Controls the player
		if(keyCode == ke.VK_UP) {
			if(initialROW > 0) {
				panel[initialROW][initialCOL].setBackground(colorArray[initialROW][initialCOL]);
				initialROW -= 1;
				panel[initialROW][initialCOL].setBackground(playerColor);
			}
		}else if(keyCode == ke.VK_DOWN) {
			if(initialROW <15 && ROWS >= 0) {
				panel[initialROW][initialCOL].setBackground(colorArray[initialROW][initialCOL]);
				initialROW += 1;
				panel[initialROW][initialCOL].setBackground(playerColor);
			}
		}else if(keyCode == ke.VK_RIGHT) {
			if(initialCOL >= 0 && initialCOL < 15) {
				panel[initialROW][initialCOL].setBackground(colorArray[initialROW][initialCOL]);
				initialCOL += 1;
				panel[initialROW][initialCOL].setBackground(playerColor);
			}
		}else if(keyCode == ke.VK_LEFT) {
			if(initialCOL <= 15 && initialCOL > 0 ) {
				panel[initialROW][initialCOL].setBackground(colorArray[initialROW][initialCOL]);
				initialCOL -= 1;
				panel[initialROW][initialCOL].setBackground(playerColor);
			}
		}else if(keyCode == ke.VK_SPACE) {
			
			if(colorArray[initialROW][initialCOL] == Color.WHITE) {
				colorArray[initialROW][initialCOL] = Color.BLACK;
			}else {
				colorArray[initialROW][initialCOL] = Color.WHITE;
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
		
	}

}
