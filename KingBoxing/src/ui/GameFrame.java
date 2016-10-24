package ui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

//import music.Music;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public PanelBegin panelBegin;
	private Point loc = null;
	private Point tmp = null;
	public Images images = new Images();
	public PanelAnimation panelAnimation;
	public static final int JFRAME_WIDTH = 821;
	public static final int JFRAME_HEIGHT = 547;
	private boolean isDragged = false;
	//锟斤拷锟叫碉拷锟斤拷锟街讹拷锟脚碉拷锟斤拷锟斤拷伞锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	//public Music music = new Music("MUSIC/游戏音乐.mp3");
	

	public GameFrame() {

		this.setLayout(null);
		this.setLocation(290, 90);
		this.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		this.setUndecorated(true);
		this.setDragable();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	public void setDragable() {
		this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent e) {
				isDragged = false;
			}

			public void mousePressed(java.awt.event.MouseEvent e) {
				tmp = new Point(e.getX(), e.getY());
				isDragged = true;
			}

		});

		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseDragged(java.awt.event.MouseEvent e) {
				if (isDragged) {
					loc = new Point(getLocation().x + e.getX() - tmp.x,
							getLocation().y + e.getY() - tmp.y);
					setLocation(loc);
				}
			}
		});
	}

	
}
