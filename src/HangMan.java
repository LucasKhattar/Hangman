import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel(new GridLayout(4, 1));
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	int total;
	int lives = 9;
	int wordsRight = 0;
	String blank = "";
	String current;

	Stack<String> words = new Stack<String>();

	public static void main(String[] args) {
		HangMan hang = new HangMan();
		hang.setUp();
		hang.getWords();
		hang.showBlanks();
		hang.getNewWord();
	}

	ArrayList<Integer> randNums = new ArrayList<Integer>();

	void setUp() {

		frame.add(panel);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		frame.setVisible(true);
		label1.setText("Guess A Letter");
		label3.setText("You Have " + lives + " Lives Left!");
		label4.setText("You Have Guessed " + wordsRight + " Words");
		frame.addKeyListener(this);
		frame.pack();

	}

	void getWords() {

		String kik = JOptionPane.showInputDialog(null, "Gimme A Number");
		int total = Integer.parseInt(kik);
		if(total==1) {
			JOptionPane.showMessageDialog(null, "Loading " + total + " Word, Good Luck");
		}
		else {
			JOptionPane.showMessageDialog(null, "Loading " + total + " Words, Good Luck");
		}
		for (int i = 0; i < total; i++) {
			try {
				int counter = 0;
				int rand = new Random().nextInt(3000);
				BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
				String word = br.readLine();
				while (word != null) {
					if (counter == rand) {
						words.push(word);
					}
					counter++;
					word = br.readLine();
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		//System.out.println(words);

	}

	void showBlanks() {
		current = words.pop();
		int lenght = current.length();
		blank = "";
		for (int i = 0; i < lenght; i++) {
			blank += "_";
		}
		label2.setText(blank);
	}

	void getNewWord() {
		if (blank.equals(current)) {
			wordsRight++;
			if (wordsRight == 1) {
				label4.setText("You Have Guessed " + wordsRight + " Word");
			} else {
				label4.setText("You Have Guessed " + wordsRight + " Words");
			}
			if (words.isEmpty()) {
				if (wordsRight == 1) {
					JOptionPane.showMessageDialog(null, "You Win! You Guessed " + wordsRight + " Word!");
					frame.dispose();
				} 
				else {
					JOptionPane.showMessageDialog(null, "You Win! You Guessed " + wordsRight + " Words!");
					frame.dispose();
				}
			} else {
				showBlanks();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		String newString = "";
		for (int i = 0; i < current.length(); i++) {
			if (e.getKeyChar() == current.charAt(i)) {
				newString += current.charAt(i);
			} else {
				newString += blank.charAt(i);
			}
		}
		blank = newString;
		label2.setText(blank);
		getNewWord();
		if(current.contains(e.getKeyChar()+"")){
		} else {
			lives--;
			if(lives==1) {
				label3.setText("You Have " + lives + " Live Left!");
			}
			else{
				label3.setText("You Have " + lives + " Lives Left!");
			}
			if(lives==0) {
				if(wordsRight==1) {
					JOptionPane.showMessageDialog(null, "You Lost! You Guessed "+ wordsRight +" Word");
					JOptionPane.showMessageDialog(null, "The Word Was "+current);
					frame.dispose();
				}
				else {		
					JOptionPane.showMessageDialog(null, "You Lost! You Guessed "+ wordsRight +" Words");
					JOptionPane.showMessageDialog(null, "The Word Was "+current);
					frame.dispose();
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
