package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPart2 extends JPanel implements MouseListener{

	GameFrame gameFrame;
	JLabel[] lab=new JLabel[4];
	//Thread thread1;
	public PanelPart2(GameFrame gameFrame){
		   // this.thread1=thread1;
	    	this.gameFrame=gameFrame;
			this.setSize(GameFrame.WIDTH, GameFrame.HEIGHT);
			this.setLocation(0, 0);
			this.setLayout(null);
			this.setVisible(true);
			this.addMouseListener(this);
			this.labelInitionalization();
	}
	public void labelInitionalization(){
		for(int i=0;i<=3;i++){
			this.lab[i]=new JLabel(gameFrame.images.story2Label[i]);
		}
		for(int j=0;j<=3;j++){
			lab[j].setBounds(0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT);
			lab[j].addMouseListener(this);
		}
	}
	public void paintComponent(Graphics g){
		g.drawImage(gameFrame.images.part2_1, 0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT,this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this){
			this.add(lab[0]);
			this.repaint();
		}
		if(e.getSource()==lab[0]){
			this.remove(lab[0]);
			this.add(lab[1]);
			this.repaint();
		}
		if(e.getSource()==lab[1]){
			this.remove(lab[1]);
			this.add(lab[2]);
			this.repaint();
		}
		if(e.getSource()==lab[2]){
			this.remove(lab[2]);
			this.add(lab[3]);
			this.repaint();
		}
		if(e.getSource()==lab[3]){
			
			this.remove(lab[3]);
			ChooseSth2 chooseSth2=new ChooseSth2(gameFrame);
			JPanel panel=(JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.setContentPane(chooseSth2);
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
