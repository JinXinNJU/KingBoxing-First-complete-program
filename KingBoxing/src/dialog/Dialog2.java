package dialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ui.GameFrame;
import ChessBoard.ChessBoard;
import ChessBoard.Player;


public class Dialog2 extends JDialog implements MouseListener{
	int x=0;
	String ip;
	String otherip;
	
	
	GameFrame gameFrame;
	JLabel lab1,lab2,lab3,lab4,lab5,lab6;
	JTextField jName;
	BackImage bi;
	public Dialog2(GameFrame gameFrame) {
		this.gameFrame=gameFrame;
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();	
			this.ip=addr.getHostAddress().toString();//获得本机IP
			//System.out.println(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		this.gameFrame=gameFrame;
		bi=new BackImage();
		this.add(bi);
		bi.setBounds(0, 0, 360, 360);
		bi.setLayout(null);
		
		lab1=new JLabel(gameFrame.images.buttonEnter1);		
		lab1.addMouseListener(this);
		lab1.setBounds(147, 260, 69,38 );
		bi.add(lab1);
		
		
		lab2=new JLabel(gameFrame.images.buttonExit1);		
		lab2.addMouseListener(this);
		lab2.setBounds(149,262,69,38);
		
		lab3=new JLabel(gameFrame.images.buttonFound);
		lab3.addMouseListener(this);
		lab3.setBounds(70,120,88,34);
		bi.add(lab3);
		
		lab4=new JLabel(gameFrame.images.buttonFound2);
		lab4.addMouseListener(this);
		lab4.setBounds(31,107,163,61);
		
		lab5=new JLabel(gameFrame.images.buttonJoin);
		lab5.addMouseListener(this);
		lab5.setBounds(235,120,61,40);
		bi.add(lab5);
		
		lab6=new JLabel(gameFrame.images.buttonJoin2);
		lab6.addMouseListener(this);
		lab6.setBounds(183,111,159,59);
		
		this.setUndecorated(true);
		Color color = new Color(0,0,0, 0f);
		this.setBackground(color);
		jName=new JTextField(20);
		jName.setHorizontalAlignment(JTextField.CENTER);
		jName.setFocusable(true);
		jName.setBounds(122,195, 120, 30);
		jName.setBorder(null);
		jName.setBorder(BorderFactory.createLoweredBevelBorder());
		jName.setBackground(getBackground());
		jName.setSelectedTextColor(color.white);
		
		this.add(jName);	
		
		this.setAlwaysOnTop(true);
		this.setLayout(null);
		
		this.setSize(357,349);
		this.setLocation(530, 160);
		this.setVisible(true);
	}
	class BackImage extends JPanel{
		Image im;
		
		public BackImage(){
			//this.setSize(357, 349);
			this.setOpaque(false);
			try {
				im=ImageIO.read(new File("DIALOG2/2.png"));
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
		JLabel but=(JLabel) e.getSource();
		if(but==lab2){
	//		JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(gameFrame.panelBegin);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.lab1);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.lab2);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.lab);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.label3);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.label1);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.label2);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.label5);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.label6);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.button7);
			gameFrame.panelBegin.remove(gameFrame.panelBegin.button8);
			
			
			this.setVisible(false);
			this.repaint();
			gameFrame.repaint();
			if(x==1){//172.26.117.180
		         ChessBoard che=new ChessBoard(gameFrame,new Player(),3,4,true);
		         che.setboard();
			}else if(x==2){
				otherip=jName.getText();
				ChessBoard che=new ChessBoard(gameFrame,new Player(),3,4,false);
				che.setboard(otherip);
			}
		}else if(but==lab4){
			x=1;
			bi.remove(lab6);
			bi.add(lab5);
			bi.repaint();
			JLabel tem=new JLabel(ip);
            Font font=new Font("宋体",Font.PLAIN,24);
            tem.setForeground(Color.WHITE);
            tem.setFont(font);
            tem.setBounds(102,195, 200, 30);
            tem.setVisible(true);
            bi.add(tem);
            tem.repaint();
		}else if(but==lab6){
			x=2;
			bi.remove(lab4);
			bi.add(lab3);
			bi.repaint();
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
		if(e.getSource()==lab3){
			if(x!=1){
			bi.remove(lab3);
			bi.add(lab4);
			bi.repaint();
			}
			
		}
		if(e.getSource()==lab5){
			if(x!=2){
			bi.remove(lab5);
			bi.add(lab6);
			bi.repaint();
			}
			
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lab2){
			bi.remove(lab2);
			bi.add(lab1);
			bi.repaint();
		}
		if(e.getSource()==lab4){
			if(x!=1){
			bi.remove(lab4);
			bi.add(lab3);
			bi.repaint();
			}
			
		}
		if(e.getSource()==lab6){
			if(x!=2){
			bi.remove(lab6);
			bi.add(lab5);
			bi.repaint();
			}
			
		}
	}

}
