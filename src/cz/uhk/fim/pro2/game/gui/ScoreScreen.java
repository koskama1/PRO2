package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ScoreScreen extends Screen {

	public ScoreScreen(MainFrame mainFrame) {
		super(mainFrame);

		JButton jButtonBack = new JButton("BACK");
		
		
		jButtonBack.setBounds(100, 400, 280, 50);


		add(jButtonBack);
		
		jButtonBack.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
	}

}
