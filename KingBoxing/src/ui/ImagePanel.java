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
//		URL bgUrl = getClass().getResource("SPECIAL/1.jpg"); // 获取背景图片URL
//		URL rotateUrl = getClass().getResource("SPECIAL/1.png");// 获取转盘图片URL
//		image = tk.createImage(bgUrl);// 加载背景图片
//		rotateIcon = tk.createImage(rotateUrl);// 加载转盘图片
		
		image=new ImageIcon("SPECIAL/1.jpg").getImage();
		rotateIcon=new ImageIcon("SPECIAL/1.png").getImage();
		setOpaque(false);// 使面板透明
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
		int width = getWidth();// 获取面板宽度
		int height = getHeight();// 获取高度
		if (image != null) {// 如果背景图片对象不为空
			g.drawImage(image, 0, 0, width, height, this);// 根据面板大小绘制图片
		}
		Graphics2D g1 = (Graphics2D) g.create();// 获取绘图上下文的副本
		// 设置绘图上下文以质量为主，绘制图片，这样可以避免图片旋转是的锯齿
		g1.setRenderingHint(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
		if (rotateIcon != null) {// 如果转盘图片对象不为null
			int iconWidth = rotateIcon.getWidth(this);// 获取转盘图片宽度
			int iconHeight = rotateIcon.getHeight(this);// 获取转盘图片高度
			g1.rotate(Math.toRadians(angle), width / 2-160, height / 2+25);// 设置旋转角度
			g1.drawImage(rotateIcon, width / 2 - iconWidth / 2-160, height / 2
					- iconHeight / 2+25, this);// 在面板中间绘制转盘图片
		}
	}

	int count = 0;
	int temp = 0;
	int randNum = 0;

	@Override
	public void run() {
		double stAngle = Math.random() * 360;
		
		angle = stAngle;
		
		
		
		while (angle < stAngle + 1200) {// 角度小于1000
			angle += 6;// 累加角度值
			repaint();// 重写绘制界面
			try {
				Thread.sleep(10);// 线程休眠
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		double sleepTime = 10;// 定义休眠变量
		
		while (sleepTime < 90) {// 角度小于120
			angle += 6;// 累加角度值
			repaint();// 重写绘制界面
			try {
				Thread.sleep((int) (sleepTime += 0.5));// 休眠并累加休眠变量值
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
