package practice;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFileSaver {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton save = new JButton();
	JButton load = new JButton();
	JTextArea text = new JTextArea();
public static void main(String[] args) {
	JFileSaver jfs = new JFileSaver();
	jfs.runner();
}

void runner() {
	frame.add(panel);
	panel.add(save);
	panel.add(load);
	panel.add(text);
	frame.setSize(500, 500);
	frame.setVisible(true);
	save.setText("Save");
	load.setText("Load");
	text.setEditable(true);
	text.setLocation(50, 50);
	text.setSize(400,400);
	text.setVisible(true);
}
}
