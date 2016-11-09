package cz.uhk.fim.pro2.game.gui;

import java.awt.event.ActionEvent;

import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;


import cz.uhk.fim.pro2.game.model.Bird;
import cz.uhk.fim.pro2.game.model.Heart;
import cz.uhk.fim.pro2.game.model.Tube;
import cz.uhk.fim.pro2.game.model.World;

public class GameScreen extends Screen {
	
	private long lastTime;
	private Timer timer;

	public GameScreen(MainFrame mainFrame) {
		super(mainFrame);

		JButton jButtonBack = new JButton("Back");
		JButton jButtonPause = new JButton("||");

		jButtonBack.setBounds(20, 20, 60, 60);
		jButtonPause.setBounds(400, 20, 60, 60);

		jButtonBack.setFont(new Font("Arial", Font.PLAIN, 15));
		jButtonPause.setFont(new Font("Arial", Font.PLAIN, 30));
		// jButtonBack.setForeground(background);

		add(jButtonBack);
		add(jButtonPause);

		jButtonBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setScreen(new HomeScreen(mainFrame));
			}
		});
		
		jButtonPause.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (timer.isRunning())
				timer.stop();
				else{
					lastTime = System.currentTimeMillis();
					timer.start();
					}
			}
		});

		Bird bird = new Bird("Petr", 240, 400);
		World world = new World(bird);

		world.addTube(new Tube(400, 400, Color.GREEN));
		world.addTube(new Tube(600, 300, Color.GREEN));
		world.addTube(new Tube(800, 500, Color.GREEN));

		world.addHeart(new Heart(500, 400));
		world.addHeart(new Heart(700, 600));

		GameCanvas gameCanvas = new GameCanvas(world);

		add(gameCanvas);

		gameCanvas.setBounds(0, 0, MainFrame.WIDTH, MainFrame.HEIGHT);
		
		timer = new Timer(20,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				long currentMills = System.currentTimeMillis();
				float delta = (currentMills - lastTime) / 1000f;
				world.update(delta);
				gameCanvas.repaint();
				
				lastTime = currentMills;
			}			
		});
			
		lastTime = System.currentTimeMillis();
		timer.start();
			
			
		System.out.println(world);

	}

}
