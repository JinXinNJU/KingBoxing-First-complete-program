package ChessBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.GameFrame;
import ui.PanelBegin;

/**
 * Created by DELL on 14-5-18.
 */
// 缃戠粶娓告垙绫伙紝鐩存帴new涓�釜Online瀵硅薄锛屼紶鍏rame鍜孭layer鍜宮ap瀹屾垚鏋勯�锛岃繍琛宱nlinerun鏂规硶寮�娓告垙
public class Online implements Runnable {
	JFrame myframe;
	Map map;
	Boolean turn;
	Player player;
	int nandu;
	Thread thread = new Thread(this);
	Boolean time = false;
	Boolean isclient;
	Server sv = new Server();
	Client cl = new Client();
	Thread thread1;

	public void run() {
		int i = 180;
		// System.out.println("hahaha");
		map.lab = null;
		map.lab1 = new JLabel("0:0");
		while (i > 0) {
			if (time) {
				i = 180;
				map.lab1 = new JLabel(String.valueOf(map.array.getRed()) + ":"
						+ map.array.getBlue());
				time = false;
			}
			// System.out.println(i);
			map.lab = new JLabel(String.valueOf(i));
			// lab1=new JLabel()
			Font font = new Font("宋体", Font.PLAIN, 40);
			map.lab.setForeground(Color.BLACK);
			map.lab.setFont(font);
			map.lab.setBounds(152, 145, 60, 60);
			map.lab.setVisible(true);
			map.lab1.setForeground(Color.black);
			map.lab1.setFont(font);
			map.lab1.setBounds(136, 45, 140, 80);
			map.lab1.setVisible(true);
			map.mypanel.add(map.lab);
			map.mypanel.add(map.lab1);
			map.lab.repaint();
			map.lab1.repaint();

			
				for (int j = 0; j < 100; j++) {
					try {
						thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (time) {
						break;
					}
				}
				map.mypanel.remove(map.lab);
				map.mypanel.remove(map.lab1);
			
//			 catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			i--;
		}

		if (turn) {
			map.normalBluewin.setVisible(true);
			map.small[5].setVisible(true);
			map.small[6].setVisible(true);
			map.small[6].repaint();
			map.small[5].repaint();
			map.normalBluewin.repaint();
		} else {
			map.normalRedwin.setVisible(true);
			map.normalRedwin.repaint();
			map.small[5].setVisible(true);
			map.small[6].setVisible(true);
			map.small[6].repaint();
			map.small[5].repaint();
		}

	}

	public Online(JFrame myframe1, Player player1, Map map1, Boolean a1) {
		this.player = player1;
		myframe = myframe1;
		map = map1;
		turn = true; // turn琛ㄧず娓告垙鑰呰疆鎹㈤『搴�
		isclient = a1;
		nandu = ((int) (Math.random() * 7)) + 1;

		// 濡傛灉a1=1鐨勮瘽锛屽垯鍋氭湇鍔″櫒锛�
		// if(a1==1){
		// sv.startServer();
		// onlinerun(true);
		//
		// }
		//
		// if(a1==2){
		// cl.startConnect();
		// onlinerun(false);
		// }
		//
	}

	public void button(String ip) {
		if (nandu == 1) {
			map.mypanel.icon = Picture.panel;
		} else if (nandu == 2) {
			map.mypanel.icon = Picture.panel2;
		} else if (nandu == 3) {
			map.mypanel.icon = Picture.panel3;
		} else if (nandu == 4) {
			map.mypanel.icon = Picture.panel4;
		} else if (nandu == 5) {
			map.mypanel.icon = Picture.panel5;
		} else if (nandu == 6) {
			map.mypanel.icon = Picture.panel6;
		} else if (nandu == 7) {
			map.mypanel.icon = Picture.panel7;
		}

		map.mypanel.repaint();
		
		for (OtherButton oth : map.button) {
			oth.addMouseListener(new ButtonSettingListener());
		}
		for (OtherButton oth : map.button) {
			oth.addMouseListener(new ButtonSettingListener());
		}
		for (JLabel lab : map.array.label) { // 娣诲姞line鐨勭洃鍚�
			lab.addMouseListener(new LineLabelListener());
		}

		cl.startConnect(ip);

		start1();

	}

	public void button() {
		if (nandu == 1) {
			map.mypanel.icon = Picture.panel;
		} else if (nandu == 2) {
			map.mypanel.icon = Picture.panel2;
		} else if (nandu == 3) {
			map.mypanel.icon = Picture.panel3;
		} else if (nandu == 4) {
			map.mypanel.icon = Picture.panel4;
		} else if (nandu == 5) {
			map.mypanel.icon = Picture.panel5;
		} else if (nandu == 6) {
			map.mypanel.icon = Picture.panel6;
		} else if (nandu == 7) {
			map.mypanel.icon = Picture.panel7;
		}

		map.mypanel.repaint();
		myframe.update(myframe.getGraphics());
		for (OtherButton oth : map.button) {
			oth.addMouseListener(new ButtonSettingListener());
		}
		for (OtherButton oth : map.button) {
			oth.addMouseListener(new ButtonSettingListener());
		}
		for (JLabel lab : map.array.label) { // 娣诲姞line鐨勭洃鍚�
			lab.addMouseListener(new LineLabelListener());
		}

		sv.startServer();

		start1();

	}

	public void start1() {

		for (LineLabel lin : map.array.label) {
			lin.condition = false;
			lin.icon = null;
			lin.setIcon(lin.icon);
			lin.repaint();
		}
		for (Boxx lin : map.array.box) {
			lin.icon = null;
			lin.number = 0;
			lin.setIcon(lin.icon);
			lin.repaint();
		}

		if (isclient) {
			onlinerun(true);
		} else {
			onlinerun(false);
		}
	}

	public void onlinerun(Boolean turn1) { // 娓告垙寮�杩愯锛岃嚜宸卞厛鎵媡urn=true锛岃嚜宸卞悗鎵媡urn=false

		turn = turn1;

		thread = new Thread(this);
		thread.start();

		int i = -1; // 寮�嚎绋�
		if (!isclient) { // 鍏堟墜鏂逛笉杩愯if鍐呴儴锛岀洿鎺ュ湪鐩戝惉澶勭瓑寰呮帴鍙楃洃鍚�
			LineLabel but = null; // 姝ゅ鍚庢墜鏂归�杩囩綉缁滆幏寰楀鏂圭殑鐩戝惉锛岃祴鍊肩粰but

			if (isclient) {
				i = sv.getDataGame();
			} else if (!isclient) {
				i = cl.getDataGame();
			}
			but = map.array.searchlabel(i);

			for (LineLabel lab : map.array.label) { // 鍒ゆ柇妫嬪瓙骞惰惤瀛�
				if ((but == lab) && (!lab.condition)) {
						turn=map.luozi(but, !turn, false);
                        turn=!turn;
						myframe.update(myframe.getGraphics());


					time = true;
					turn = !turn;

					break;
				}
			}
		}

	}

	class LineLabelListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int i = -1;
			
			LineLabel but = (LineLabel) e.getSource();

            if(isclient){
                if (turn) {
                    for (LineLabel lab : map.array.label) { // 鑾峰緱榧犳爣鐩戝惉锛岃嚜宸辫惤瀛�
                        if ((but == lab) && (!lab.condition)) {

                            turn=map.luozi(but, turn, false); // 钀藉瓙
 //                           turn=!turn;
                                myframe.update(myframe.getGraphics());


                                sv.setDataGame(but.note);


                            time = true;
                            turn = !turn;
                            break;
                        }
                    }
            }
                if (map.isend()) {
                    System.out.println(map.win());
                    turn = true;

                    if (map.win().equals("RedWin!")) {
                        map.normalRedwin.setVisible(true);
                        map.normalRedwin.repaint();
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                    } else {
                        map.normalBluewin.setVisible(true);
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                        map.normalBluewin.repaint();
                    }
                }

                while (!turn) { // 褰搕urn杞笉鍒拌嚜宸辨椂锛岀瓑寰呰幏寰楃綉缁滀紶杈�
                    // System.out.println("while涓�);
                    if (isclient) {
                        i = sv.getDataGame();
                        System.out.println("fuwuqichuanshu:::"+i);
                    } else if (!isclient) {
                        i = cl.getDataGame();
                    }
                    System.out.println("服务器接受"+i);
                    but = map.array.searchlabel(i);
                    for (LineLabel lab : map.array.label) { // 鐩戞祴line锛岃惤瀛�
                        if ((but == lab) && (!lab.condition)) {
                                turn=map.luozi(but, turn, false); // 钀藉瓙
     //                         turn=!turn;
                                myframe.update(myframe.getGraphics());


                            time = true;
                            turn = !turn;
                            break;
                        }
                    }
                }

                if (map.isend()) {
                    System.out.println(map.win());
                    if (map.win().equals("RedWin!")) {
                        map.normalRedwin.setVisible(true);
                        map.normalRedwin.repaint();
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                    } else {
                        map.normalBluewin.setVisible(true);
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                        map.normalBluewin.repaint();
                    }
                    turn = true;
                }

			}else {
                if (turn) {
                    for (LineLabel lab : map.array.label) { // 鑾峰緱榧犳爣鐩戝惉锛岃嚜宸辫惤瀛�
                        if ((but == lab) && (!lab.condition)) {


							turn=map.luozi(but, !turn, false);
                            turn=!turn;
							myframe.update(myframe.getGraphics());

                            if (isclient) {
                                sv.setDataGame(but.note);
                            } else if (!isclient) {
							cl.setDataGame(but.note);
						}

                            time = true;
                            turn = !turn;
                            break;
                        }
                    }
                }
                if (map.isend()) {
                    System.out.println(map.win());
                    turn = true;

                    if (map.win().equals("RedWin!")) {
                        map.normalRedwin.setVisible(true);
                        map.normalRedwin.repaint();
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                    } else {
                        map.normalBluewin.setVisible(true);
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                        map.normalBluewin.repaint();
                    }
                }

                while (!turn) { // 褰搕urn杞笉鍒拌嚜宸辨椂锛岀瓑寰呰幏寰楃綉缁滀紶杈�
                    // System.out.println("while涓�);
                    if (isclient) {
                        i = sv.getDataGame();
                        System.out.println("fuwuqichuanshu:::"+i);
                    }
                    else if (!isclient) {
                        i = cl.getDataGame();
                    }
                    but = map.array.searchlabel(i);
                    for (LineLabel lab : map.array.label) { // 鐩戞祴line锛岃惤瀛�
                        if ((but == lab) && (!lab.condition)) {

                                turn=map.luozi(but, !turn, false);
                                turn=!turn;
                                myframe.update(myframe.getGraphics());


                            time = true;
                            turn = !turn;
                            break;
                        }
                    }
                }

                if (map.isend()) {
                    System.out.println(map.win());
                    if (map.win().equals("RedWin!")) {
                        map.normalRedwin.setVisible(true);
                        map.normalRedwin.repaint();
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                    } else {
                        map.normalBluewin.setVisible(true);
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                        map.normalBluewin.repaint();
                    }
                    turn = true;
                }
            }

		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) { // 榧犳爣绉诲叆line鏃讹紝鏇存崲line鑳屾櫙鍥剧墖

			// LineLabel but=(LineLabel) e.getSource();
			//
			// for(LineLabel lab:map.array.label){
			// if(but==lab&&(!lab.condition)){
			// lab.icon= LabelPicture.lineiconMovein;
			// lab.setIcon(lab.icon);
			// lab.repaint();
			// }
			// }

		}

		@Override
		public void mouseExited(MouseEvent e) { // 榧犳爣绉诲嚭line鏃讹紝鎭㈠line鑳屾櫙鍥剧墖

			// LineLabel but=(LineLabel) e.getSource();
			//
			// for(LineLabel lab:map.array.label){
			// if(but==lab&&(!lab.condition)){
			// lab.icon= LabelPicture.lineiconMoveout;
			// lab.setIcon(lab.icon);
			// lab.repaint();
			// }
			// }

			// myframe.update(myframe.getGraphics());//
			// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌
		}
	}

	class ButtonSettingListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			OtherButton but = (OtherButton) e.getSource();

			if (but.name.equals("Home")) {
				thread.stop();
				map.mypanel.remove(map.lab);
				map.mypanel.remove(map.lab1);
				map.mypanel.setVisible(false);
				map.mypanel.repaint();
				PanelBegin panelBegin = new PanelBegin((GameFrame) myframe, 1);
				JPanel panel = (JPanel) myframe.getContentPane();
				myframe.remove(panel);
				myframe.setContentPane(panelBegin);
				myframe.setVisible(true);
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

}
