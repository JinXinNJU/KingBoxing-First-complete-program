package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dialog.Dialog1;

public class PanelStart extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	
	GameFrame gameFrame;
	private JLabel button1;
	private JLabel button2;
	private JLabel button3;
	//Thread thread1;
	


	public PanelStart(GameFrame gameFrame){
		this.gameFrame=gameFrame;
		//this.thread1=thread1;
		this.setSize(GameFrame.WIDTH, GameFrame.HEIGHT);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setVisible(true);
		this.buttonInitialization();
	}
	
	public void buttonInitialization(){
		this.button1=new JLabel(gameFrame.images.buttonAbout);
		this.button2=new JLabel(gameFrame.images.buttonStart);
		this.button3=new JLabel(gameFrame.images.buttonQuit);
		this.add(button1);
		this.add(button2);
		this.add(button3);
		button1.setBounds(680, 452, 115, 42);		
		button1.addMouseListener(this);
		button2.setBounds(345,400,139,65);		
		button2.addMouseListener(this);
		button3.setBounds(50,450,64,41);		
		button3.addMouseListener(this);
	}
	public void paintComponent(Graphics g){
		g.drawImage(gameFrame.images.start, 0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT,this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1){
			PanelAboutUs panelAboutUs=new PanelAboutUs(gameFrame);
			gameFrame.setContentPane(panelAboutUs);
		}
		if(e.getSource()==button2){
//			int i=0;
//			PanelBegin panelBegin=new PanelBegin(gameFrame,i);
//			JPanel panel=(JPanel) gameFrame.getContentPane();
//			gameFrame.remove(panel);
//			gameFrame.setContentPane(panelBegin);
//			gameFrame.setVisible(true);
//			gameFrame.panelAnimation.thread2.stop();
			Dialog1 dia=new Dialog1(gameFrame);
			
			
		}
		if(e.getSource()==button3){
			System.exit(0);
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
	
}
