package ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dialog.Dialog2;
import ChessBoard.ChessBoard;
import ChessBoard.Player;



public class PanelBegin extends JPanel implements MouseListener,Runnable{

	GameFrame gameFrame;
	Thread thread1;
	public JLabel label1, label2, label3,label5, label6;
	public JButton button7, button8;
	public JLabel lab,lab1,lab2,lab3;
	

	public PanelBegin(GameFrame gameFrame, int i) {
		this.gameFrame = gameFrame;
		//this.thread1=thread1;
		this.setSize(GameFrame.WIDTH, GameFrame.HEIGHT);
		this.setLocation(0, 0);
		this.setLayout(null);
		this.setVisible(true);
		this.labelInitionalization();
		if (i == 5201314) {
			this.extraComponent();

		}
	}

	public void labelInitionalization() {
		this.label1 = new JLabel(gameFrame.images.buttonDouble);
		this.label2 = new JLabel(gameFrame.images.buttonHelp);
		this.label3 = new JLabel(gameFrame.images.buttonInternet);
		this.label5 = new JLabel(gameFrame.images.buttonSingle);
		this.label6 = new JLabel(gameFrame.images.buttonStory);
		this.button7 = new JButton(gameFrame.images.buttonClose1);
		this.button8 = new JButton(gameFrame.images.buttonClose2);
		this.lab=new JLabel(gameFrame.images.buttonSpecial);
		this.lab1=new JLabel(gameFrame.images.buttonSpecial1);
		this.lab2=new JLabel(gameFrame.images.helping);
		this.lab3=new JLabel(gameFrame.images.helpingExit);
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label5);
		this.add(label6);
		this.add(button7);
		label1.setBounds(110, 280, 132, 48);
		label1.addMouseListener(this);
		label2.setBounds(730, 460, 61, 68);
		label2.addMouseListener(this);
		label3.setBounds(87, 215, 120, 65);
		label3.addMouseListener(this);
		label5.setBounds(80, 125, 114, 51);
		label5.addMouseListener(this);
		label6.setBounds(130, 180, 110, 52);
		label6.addMouseListener(this);
		button7.setBounds(780, 5, 35,25);
		button7.setBorderPainted(false);
		button7.setContentAreaFilled(false);
		button7.addMouseListener(this);
		lab.setBounds(55,410,188,180);
		lab.addMouseListener(this);
		lab1.setBounds(55,410,102,127);
		lab1.addMouseListener(this);
		lab2.setBounds(0,0,821,547);
		lab2.addMouseListener(this);
		lab3.setBounds(0,0,821,547);
	}

	public void extraComponent() {
		this.add(lab);		
	}

	

	public void paintComponent(Graphics g) {
		g.drawImage(gameFrame.images.begin, 0, 0, GameFrame.JFRAME_WIDTH,
				GameFrame.JFRAME_HEIGHT, this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == label1) {
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.remove(label1);
			gameFrame.remove(label2);
			gameFrame.remove(label3);
			gameFrame.remove(label5);
			gameFrame.remove(label6);
			gameFrame.remove(button7);
			gameFrame.remove(button8);
			gameFrame.repaint();
			
			//thread1.stop();
			//thread1=new Thread(gameFrame.music8);
			//thread1.start();
			ChessBoard chessBoard = new ChessBoard(gameFrame, new Player("����"),
					2, 7,true);
			chessBoard.setboard();
			
		}
		if (e.getSource() == label2) {
			this.remove(label1);
			this.remove(label3);
			this.remove(label5);
			this.remove(label6);
			gameFrame.add(lab2);
			this.repaint();
			gameFrame.repaint();
		}
		if (e.getSource() == label3) {
//			JPanel panel = (JPanel) gameFrame.getContentPane();
//			gameFrame.remove(panel);
//			gameFrame.remove(label1);
//			gameFrame.remove(label2);
//			gameFrame.remove(label3);
//			gameFrame.remove(label5);
//			gameFrame.remove(label6);
//			gameFrame.remove(button7);
//			gameFrame.remove(button8);
//			gameFrame.repaint();
//
//			ChessBoard chessBoard = new ChessBoard(gameFrame, new Player("����"),
//					3, 7,true);
//			chessBoard.setboard();
			Dialog2 dialog2=new Dialog2(gameFrame);
		}
		if (e.getSource() == label5) {
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.remove(label1);
			gameFrame.remove(label2);
			gameFrame.remove(label3);
			gameFrame.remove(label5);
			gameFrame.remove(label6);
			gameFrame.remove(button7);
			gameFrame.remove(button8);
			gameFrame.repaint();

			//thread1.stop();
			//thread1=new Thread(gameFrame.music8);
			//thread1.start();
			ChessBoard chessBoard = new ChessBoard(gameFrame, new Player("����"),
					1, 7,true);
			chessBoard.setboard();

		}
		if (e.getSource() == label6) {
			//thread1.stop();
			//thread1=new Thread(gameFrame.music1);
			//thread1.start();
			PanelPart1 panelPart1 = new PanelPart1(gameFrame);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.setContentPane(panelPart1);
			gameFrame.setVisible(true);
			
			
		}
		if (e.getSource() == button7) {

		}
		if (e.getSource() == button8) {
			System.exit(0);
		}
		if(e.getSource()==lab1){
			PanelSpecial panelSpecial = new PanelSpecial(gameFrame);
			JPanel panel = (JPanel) gameFrame.getContentPane();
			gameFrame.remove(panel);
			gameFrame.setContentPane(panelSpecial);
			gameFrame.setVisible(true);
		}
		if(e.getSource()==lab2){
			gameFrame.remove(lab2);
            gameFrame.add(lab3);

			thread1=new Thread(this);
			thread1.start();
//			gameFrame.remove(label1);
//			gameFrame.remove(label2);
//			gameFrame.remove(label3);
//			gameFrame.remove(label5);
//			gameFrame.remove(label6);
//			gameFrame.remove(button7);
//			JPanel panel = (JPanel) gameFrame.getContentPane();
//			gameFrame.remove(panel);
//
//			PanelBegin panelBegin=new PanelBegin(gameFrame,0);

//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			this.repaint();
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
		if (e.getSource() == button7) {
			this.remove(button7);
			this.add(button8);
			button8.setBounds(782, 5, 35, 25);
			button8.setBorderPainted(false);
			button8.setContentAreaFilled(false);
			button8.addMouseListener(this);
			this.repaint();
		}
		if(e.getSource()==lab){
			this.remove(lab);
			this.add(lab1);
			this.repaint();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button8) {
			this.remove(button8);
			this.add(button7);
			button7.setBounds(780, 5,35,25);
			button7.setBorderPainted(false);
			button7.setContentAreaFilled(false);
			button7.addMouseListener(this);
			this.repaint();
		}
		if(e.getSource()==lab1){
			this.remove(lab1);
			this.add(lab);
			this.repaint();
		}
	}
	
	public void run(){

		try {
			thread1.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		gameFrame.remove(lab3);
        gameFrame.add(label1);
        gameFrame.add(label2);
        gameFrame.add(label3);
        gameFrame.add(label5);
        gameFrame.add(label6);
        gameFrame.add(button7);
        gameFrame.add(button8);
		gameFrame.repaint();
		System.out.println("132");
	}
}
