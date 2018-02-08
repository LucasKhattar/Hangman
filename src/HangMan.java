import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

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
		String idk = JOptionPane.showInputDialog(null, "Gimme A Number");
		int total = Integer.parseInt(idk);
		JOptionPane.showMessageDialog(null, "Loading "+total+" Words. Good Luck");
		for (int i = 0; i < total; i++) {
			int rand = new Random().nextInt(3000);
			if(randNums.contains(i)) {
				i--;
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
