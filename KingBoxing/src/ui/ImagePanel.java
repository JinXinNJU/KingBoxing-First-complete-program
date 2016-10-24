package ui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import ChessBoard.ChessBoard;
import ChessBoard.Player;



/**
 * 
 */
public class ImagePanel extends JPanel implements Runnable {
	private static Image image;
	final JButton button = new JButton();
	private static Image rotateIcon;
	private double angle = 0;
	private static Toolkit tk = Toolkit.getDefaultToolkit();
	GameFrame gameFrame;

	private final class ButtonActionListener implements ActionListener {
		private final ImagePanel imagePanel;
		private Thread imageThread;

		private ButtonActionListener(ImagePanel imagePanel) {
			this.imagePanel = imagePanel;
		}

		public void actionPerformed(final ActionEvent e) {

			if (imageThread == null || !imageThread.isAlive()) {
				imageThread = new Thread(imagePanel);
				imageThread.start();
			} else if (!imageThread.isAlive()) {
				imageThread.start();
			}
		}
	}

	public ImagePanel(GameFrame gameFrame) {
		this.gameFrame=gameFrame;
//		System.out.println(111);
//		URL bgUrl = getClass().getResource("SPECIAL/1.jpg"); // ��ȡ����ͼƬURL
//		URL rotateUrl = getClass().getResource("SPECIAL/1.png");// ��ȡת��ͼƬURL
//		image = tk.createImage(bgUrl);// ���ر���ͼƬ
//		rotateIcon = tk.createImage(rotateUrl);// ����ת��ͼƬ
		
		image=new ImageIcon("SPECIAL/1.jpg").getImage();
		rotateIcon=new ImageIcon("SPECIAL/1.png").getImage();
		setOpaque(false);// ʹ���͸��
		setLayout(null);
	//System.out.println(111);
		
	}

	public void buttonInit() {
		
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       // button.setPressedIcon(new ImageIcon(getClass().getResource("SPECIAL/2.png")));
		button.setPressedIcon(new ImageIcon(("SPECIAL/2.png")));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.addActionListener(new ButtonActionListener(this));

        //button.setIcon(new ImageIcon(getClass().getResource("SPECIAL/2.png")));
		button.setIcon(new ImageIcon(("SPECIAL/2.png")));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorder(null);
		button.setBounds(520, 250, 198, 96);
		this.add(button);
		
	}

	public void paintComponent(Graphics g) {
		int width = getWidth();// ��ȡ�����
		int height = getHeight();// ��ȡ�߶�
		if (image != null) {// �������ͼƬ����Ϊ��
			g.drawImage(image, 0, 0, width, height, this);// ��������С����ͼƬ
		}
		Graphics2D g1 = (Graphics2D) g.create();// ��ȡ��ͼ�����ĵĸ���
		// ���û�ͼ������������Ϊ��������ͼƬ���������Ա���ͼƬ��ת�ǵľ��
		g1.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		if (rotateIcon != null) {// ���ת��ͼƬ����Ϊnull
			int iconWidth = rotateIcon.getWidth(this);// ��ȡת��ͼƬ���
			int iconHeight = rotateIcon.getHeight(this);// ��ȡת��ͼƬ�߶�
			g1.rotate(Math.toRadians(angle), width / 2-160, height / 2+25);// ������ת�Ƕ�
			g1.drawImage(rotateIcon, width / 2 - iconWidth / 2-160, height / 2
					- iconHeight / 2+25, this);// ������м����ת��ͼƬ
		}
	}

	int count = 0;
	int temp = 0;
	int randNum = 0;

	@Override
	public void run() {
		double stAngle = Math.random() * 360;
		
		angle = stAngle;
		
		
		
		while (angle < stAngle + 1200) {// �Ƕ�С��1000
			angle += 6;// �ۼӽǶ�ֵ
			repaint();// ��д���ƽ���
			try {
				Thread.sleep(10);// �߳�����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		double sleepTime = 10;// �������߱���
		
		while (sleepTime < 90) {// �Ƕ�С��120
			angle += 6;// �ۼӽǶ�ֵ
			repaint();// ��д���ƽ���
			try {
				Thread.sleep((int) (sleepTime += 0.5));// ���߲��ۼ����߱���ֵ
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		angle=angle%360;
		
			
			
		

		
		if(angle<=45){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,1,true);
			chessBoard.setboard();
		}
		if((angle>45)&(angle<=90)){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,2,true);
			chessBoard.setboard();
		}
		if((angle>90)&(angle<=135)){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,3,true);
			chessBoard.setboard();
		}
		if((angle>135)&(angle<=180)){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,4,true);
			chessBoard.setboard();
		}
		if((angle>180)&(angle<=225)){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,5,true);
			chessBoard.setboard();
		}
		if((angle>225)&(angle<=270)){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,6,true);
			chessBoard.setboard();
		}
		if((angle>270)&(angle<=315)){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,7,true);
			chessBoard.setboard();
		}
		if((angle>315)&(angle<=360)){
			this.remove(button);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("123"),5,8,true);
			chessBoard.setboard();
		}
	}
}
