package ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JPanel;

public class PanelAboutUs extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	
	GameFrame gameFrame;
	int imageNumber;
	boolean jump;
	float ii = 0.0f;
//	Thread thread1;
//	Thread thread2;

	public PanelAboutUs(GameFrame gameFrame) {

		this.gameFrame = gameFrame;
		this.setLayout(null);
		this.setBounds(0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT);
		this.setVisible(true);
		// thread.start();
//		thread1 = new Thread(gameFrame.music9);
//		thread1.start();

		new Thread(this).start();

	}

	public void paintComponent(Graphics g) {

		//System.out.println(11);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Graphics2D g2 = (Graphics2D) g;

		if (ii > 1) {
			ii = 1;
		}

		if (ii < 0) {
			ii = 0;
		}

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ii));
		g2.drawImage(gameFrame.images.about.get(imageNumber), 0, 0,
				this.getWidth(), this.getHeight(), null);
		this.requestFocus();

	}

	@SuppressWarnings("deprecation")
	public void run() {

		for (int i = 0; i < 8; i++) {
			if (jump) {
				break;
			}
			boolean cut1 = false;

			for (int j = 0; j < 10; j++) {

				if (jump) {
					break;
				}

				if (cut1) {
					try {
						Thread.sleep(350);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}

				try {
					Thread.sleep(35);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ii += 0.1f;
				this.repaint();
			}

			if (jump) {
				break;
			}

			ii = 1.0f;
			this.repaint();

			try {
				Thread.sleep(1800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			boolean cut2 = false;

			for (int j = 0; j < 10; j++) {

				if (jump) {
					break;
				}

				if (cut2) {
					try {
						Thread.sleep(350);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}

				try {
					Thread.sleep(35);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ii -= 0.1f;
				this.repaint();
			}

			imageNumber++;
			ii = 0.0f;

		}
		PanelStart panelStart = new PanelStart(gameFrame);
		JPanel panel = (JPanel) gameFrame.getContentPane();
		gameFrame.remove(panel);
		gameFrame.setContentPane(panelStart);
		gameFrame.setVisible(true);
//		thread1.stop();
//		thread2=new Thread(gameFrame.music2);
//		thread2.start();
	}
}
