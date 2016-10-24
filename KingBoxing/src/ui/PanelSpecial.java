package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelSpecial extends JPanel {
	GameFrame gameFrame;
	public PanelSpecial(GameFrame gameFrame){
		this.gameFrame=gameFrame;
		this.setSize(821,547);
		this.setLocation(0,0);
		this.setLayout(null);
		this.setVisible(true);
		ImagePanel imagePanel = new ImagePanel(gameFrame);
		this.add(imagePanel);
		imagePanel.setLocation(0, 0);
		imagePanel.setSize(821, 547);
		imagePanel.setVisible(true);
		imagePanel.buttonInit();
		gameFrame.repaint();
	}
//	public void paintComponent(Graphics g){
//		g.drawImage(gameFrame.images.specialBg, 0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT,this);
//	}
}
