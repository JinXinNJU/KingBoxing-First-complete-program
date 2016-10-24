package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ChessBoard.ChessBoard;
import ChessBoard.Player;

public class ChooseSth1 extends JPanel implements MouseListener,Runnable{
	GameFrame gameFrame;
	JLabel lab;
	//Thread thread1;
	
	public ChooseSth1(GameFrame gameFrame){
		this.gameFrame=gameFrame;
		//this.thread1=thread1;
		this.setSize(GameFrame.WIDTH, GameFrame.HEIGHT);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setVisible(true);
		this.addMouseListener(this);
		this.labelInitionalization();
	}
	
    public void labelInitionalization(){
    	//����Ҫ�Ĵ�С��λ��
    	lab=new JLabel(gameFrame.images.objects1);
    	lab.setBounds(210, 293, 570, 254);
		lab.addMouseListener(this);
	}
    
    public void paintComponent(Graphics g){
		g.drawImage(gameFrame.images.choose1, 0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT,this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this){
			this.add(lab);
			this.repaint();
		}
		if(e.getSource()==lab){
//			thread1.stop();
//			thread1=new Thread(gameFrame.music8);
//			thread1.start();
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.remove(lab);
			gameFrame.repaint();
			ChessBoard chessBoard=new ChessBoard(gameFrame,new Player("����"),4,1,true);
			chessBoard.setboard();
			
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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
