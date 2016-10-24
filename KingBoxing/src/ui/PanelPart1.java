package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPart1 extends JPanel implements MouseListener{
	GameFrame gameFrame;
	JLabel[] lab=new JLabel[31];
	//Thread thread1;
	
	
	
    public PanelPart1(GameFrame gameFrame){
    	//this.thread1=thread1;
    	this.gameFrame=gameFrame;
		this.setSize(GameFrame.WIDTH, GameFrame.HEIGHT);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setVisible(true);
		this.addMouseListener(this);
		this.labelInitionalization();
    }
    
    public void labelInitionalization(){
    	for(int i=0;i<=30;i++){
			this.lab[i]=new JLabel(gameFrame.images.story1Label[i]);
		}
		for(int j=0;j<=30;j++){
			lab[j].setBounds(0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT);
			lab[j].addMouseListener(this);
		}
    }
   
    public void paintComponent(Graphics g){
		g.drawImage(gameFrame.images.part1_1, 0, 0, GameFrame.JFRAME_WIDTH, GameFrame.JFRAME_HEIGHT,this);
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
			this.add(lab[4]);
			this.repaint();
		}
		if(e.getSource()==lab[4]){
			this.remove(lab[4]);
			this.add(lab[5]);
			this.repaint();
		}
		if(e.getSource()==lab[5]){
			this.remove(lab[5]);
			this.add(lab[6]);
			this.repaint();
		}
		if(e.getSource()==lab[6]){
			this.remove(lab[6]);
			this.add(lab[7]);
			this.repaint();
		}
		if(e.getSource()==lab[7]){
			this.remove(lab[7]);
			this.add(lab[8]);
			this.repaint();
		}
		if(e.getSource()==lab[8]){
			this.remove(lab[8]);
			this.add(lab[9]);
			this.repaint();
		}
		if(e.getSource()==lab[9]){
			this.remove(lab[9]);
			this.add(lab[10]);
			this.repaint();
		}
		if(e.getSource()==lab[10]){
			this.remove(lab[10]);
			this.add(lab[11]);
			this.repaint();
		}
		if(e.getSource()==lab[11]){
			this.remove(lab[11]);
			this.add(lab[12]);
			this.repaint();
		}
		if(e.getSource()==lab[12]){
			this.remove(lab[12]);
			this.add(lab[13]);
			this.repaint();
		}
		if(e.getSource()==lab[13]){
			this.remove(lab[13]);
			this.add(lab[14]);
			this.repaint();
		}
		if(e.getSource()==lab[14]){
			this.remove(lab[14]);
			this.add(lab[15]);
			this.repaint();
		}
		if(e.getSource()==lab[15]){
			this.remove(lab[15]);
			this.add(lab[16]);
			this.repaint();
		}
		if(e.getSource()==lab[16]){
			this.remove(lab[16]);
			this.add(lab[17]);
			this.repaint();
		}
		if(e.getSource()==lab[17]){
			this.remove(lab[17]);
			this.add(lab[18]);
			this.repaint();
		}
		if(e.getSource()==lab[18]){
			this.remove(lab[18]);
			this.add(lab[19]);
			this.repaint();
		}
		if(e.getSource()==lab[19]){
			this.remove(lab[19]);
			this.add(lab[20]);
			this.repaint();
		}
		if(e.getSource()==lab[20]){
			this.remove(lab[20]);
			this.add(lab[21]);
			this.repaint();
		}
		if(e.getSource()==lab[21]){
			this.remove(lab[21]);
			this.add(lab[22]);
			this.repaint();
		}
		if(e.getSource()==lab[22]){
			this.remove(lab[22]);
			this.add(lab[23]);
			this.repaint();
		}
		if(e.getSource()==lab[23]){
			this.remove(lab[23]);
			this.add(lab[24]);
			this.repaint();
		}
		if(e.getSource()==lab[24]){
			this.remove(lab[24]);
			this.add(lab[25]);
			this.repaint();
		}
		if(e.getSource()==lab[25]){
			this.remove(lab[25]);
			this.add(lab[26]);
			this.repaint();
		}
		if(e.getSource()==lab[26]){
			this.remove(lab[26]);
			this.add(lab[27]);
			this.repaint();
		}
		if(e.getSource()==lab[27]){
			this.remove(lab[27]);
			this.add(lab[28]);
			this.repaint();
		}
		if(e.getSource()==lab[28]){
			this.remove(lab[28]);
			this.add(lab[29]);
			this.repaint();
		}
		if(e.getSource()==lab[29]){
			this.remove(lab[29]);
			this.add(lab[30]);
			this.repaint();
		}
		if(e.getSource()==lab[30]){
			this.remove(lab[30]);
			ChooseSth1 chooseSth1=new ChooseSth1(gameFrame);
			JPanel panel=(JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.setContentPane(chooseSth1);
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
