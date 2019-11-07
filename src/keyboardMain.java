/*
 * Michael Lam
 * 11/7/19
 * Lab 17
 * Creates a gridlayout that allows the user to move a "player" tile and paint its current tile 
 * black if space was pressed
 */
public class keyboardMain {

	public static void main(String[] args) {
		KeyboardListener painter = new KeyboardListener();
		painter.setVisible(true);

	}

}
