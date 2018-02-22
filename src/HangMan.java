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
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	int total;
	
	Stack<String> words = new Stack<String>();

	public static void main(String[] args) {
		HangMan hang = new HangMan();
		hang.runner();
	}

	ArrayList<Integer> randNums = new ArrayList<Integer>();

	void runner() {

		frame.add(panel);
		panel.add(label);
		frame.setVisible(true);
		frame.setSize(500, 50);
		frame.addKeyListener(this);
		String kik = JOptionPane.showInputDialog(null, "Gimme A Number");
		int total = Integer.parseInt(kik);
		JOptionPane.showMessageDialog(null, "Loading " + total + " Words, Good Luck");
		for (int i = 0; i < total; i++) {
			try {
				int counter = 0;
				int rand = new Random().nextInt(3000);
				BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
				String word = br.readLine();
				while (word != null) {
					if(counter == rand) {
						words.push(word);
					}
					counter++;
					word = br.readLine();
				}
				System.out.println(words);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

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
