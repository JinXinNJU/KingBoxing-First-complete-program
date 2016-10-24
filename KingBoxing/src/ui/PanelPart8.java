package ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelPart8 extends JPanel implements Runnable{
	GameFrame gameFrame;
	int imageNumber;
	boolean jump;
	float ii = 0.0f;
	Thread thread;
	//Thread thread1;
	public PanelPart8(GameFrame gameFrame) {
		//this.thread1=thread1;
		this.gameFrame = gameFrame;
		this.setLayout(null);
		this.setBounds(0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT);
		this.setVisible(true);
		new Thread(this).start();
		

	}
	public void paintComponent(Graphics g) {

		System.out.println(ii);
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
		g2.drawImage(gameFrame.images.ending.get(imageNumber), 0, 0,
				this.getWidth(), this.getHeight(), null);
		this.requestFocus();

	}

	@SuppressWarnings("deprecation")
	public void run() {

		for (int i = 0; i < 13; i++) {
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
		PanelBegin panelBegin = new PanelBegin(gameFrame,5201314);
		JPanel panel = (JPanel) gameFrame.getContentPane();
		gameFrame.remove(panel);
		gameFrame.setContentPane(panelBegin);
		gameFrame.setVisible(true);
	}
}
