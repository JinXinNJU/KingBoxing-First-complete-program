package dialog;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.GameFrame;
import ui.PanelBegin;


public class Dialog1 extends JDialog implements MouseListener{
	GameFrame gameFrame;
	//Thread thread1;
	JTextField jName;
	JLabel lab1,lab2;
	BackImage bi;
	private boolean isDragged = false;
	private Point loc = null;
	private Point tmp = null;
	public Dialog1(GameFrame gameFrame){
		
		//this.thread1=thread1;
		this.gameFrame=gameFrame;
		bi=new BackImage();
		this.add(bi);
		bi.setBounds(0, 0, 360, 360);
		bi.setLayout(null);
		
		lab1=new JLabel(gameFrame.images.buttonEnter1);		//114.212.42.78212.42.78
		lab1.addMouseListener(this);
		lab1.setBounds(149, 262, 69,38 );
		bi.add(lab1);
		
		lab2=new JLabel(gameFrame.images.buttonExit1);		
		lab2.addMouseListener(this);
		lab2.setBounds(148,261,69,38);
		
		
		
		this.setUndecorated(true);
		Color color = new Color(0,0,0, 0f);
		this.setBackground(color);
		jName=new JTextField(20);
		jName.setHorizontalAlignment(JTextField.CENTER);
		jName.setFocusable(true);
		jName.setBounds(122,190, 120, 30);
		jName.setBorder(null);
		jName.setBorder(BorderFactory.createLoweredBevelBorder());
		jName.setBackground(getBackground());
		jName.setSelectedTextColor(color.white);
		//str是输入的姓名
		String str=jName.getText();
		
		
		bi.add(jName);		
		this.setAlwaysOnTop(true);
		this.setLayout(null);
		
		this.setSize(357,349);
		this.setLocation(530, 160);
		this.setVisible(true);
		this.setDragable();
	}
	class BackImage extends JPanel{
		Image im;
		
		public BackImage(){
			//this.setSize(357, 349);
			this.setOpaque(false);
			try {
				im=ImageIO.read(new File("DIALOG/2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g){
			g.drawImage(im,0,0,357,349,this);
			super.paintComponent(g);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lab2){
			int i=0;
			PanelBegin panelBegin=new PanelBegin(gameFrame,i);
			JPanel panel=(JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.setContentPane(panelBegin);
			gameFrame.panelBegin=panelBegin;
			this.dispose();
			gameFrame.setVisible(true);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lab1){
			bi.remove(lab1);
			bi.add(lab2);
			bi.repaint();
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lab2){
			bi.remove(lab2);
			lab1.setBounds(147, 260, 69,38 );
			bi.add(lab1);
			bi.repaint();
		}
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
