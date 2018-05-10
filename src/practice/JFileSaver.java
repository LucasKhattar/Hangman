package practice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFileSaver implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton save = new JButton();
	JButton load = new JButton();
	String fileFinder;
	String fileName;
	BufferedReader br;
	FileWriter fw;
	JTextArea text = new JTextArea(50, 50);
	String fileText;
	String textFile;

	public static void main(String[] args) {
		JFileSaver jfs = new JFileSaver();
		jfs.runner();
	}

	void runner() {
		frame.add(panel);
		panel.add(save);
		panel.add(load);
		panel.add(text);
		frame.setVisible(true);
		save.setText("Save");
		load.setText("Load");
		text.setEditable(true);
		text.setLocation(50, 50);
		text.setVisible(true);
		frame.pack();
		save.addActionListener(this);
		load.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(load)) {
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileFinder = jfc.getSelectedFile().getAbsolutePath();
			}
			try {
				br = new BufferedReader(new FileReader(fileFinder));

				String line = br.readLine();
				while (line != null) {
					System.out.println(line);
					fileText += line;
					line = br.readLine();
				}
				br.close();
				text.setText(fileText);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(save)) {
			fileName = JOptionPane.showInputDialog("Enter File Name");
			fileText = text.getText();
			try {
				fw = new FileWriter("src/practice/" + fileName);
				fw.write(fileText);
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
