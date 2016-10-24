package ChessBoard;

import javax.swing.*;

import ui.GameFrame;
import ui.PanelBegin;
import ui.PanelPart6;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Ai.*;

/**
 * Created by DELL on 14-5-18.
 */
public class SingleGame implements Runnable{
    JFrame myframe;
    Map map;
    Boolean turn;
    Player player;
    int nandu;
    Thread thread=new Thread(this);
    Boolean time=false;
    Boolean thisgame;
    Thread thread1;

    public void run(){
            int i=180;
            
        while(i>0) {
            if(time){
                i=180;
                map.lab1=new JLabel(String.valueOf(map.array.getRed())+":"+map.array.getBlue());
                time=false;
            }
            map.lab = new JLabel(String.valueOf(i));
            Font font=new Font("宋体",Font.PLAIN,40);
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

            try {
                for (int j=0;j<100;j++) {
                    thread.sleep(10);
                    if(time){
                        break;
                    }
                }
                map.mypanel.remove(map.lab);
                map.mypanel.remove(map.lab1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }

        if(turn){
            map.normalBluewin.setVisible(true);
            map.small[5].setVisible(true);
            map.small[6].setVisible(true);
            map.small[6].repaint();
            map.small[5].repaint();
            map.normalBluewin.repaint();
        }else{
            map.normalRedwin.setVisible(true);
            map.normalRedwin.repaint();
            map.small[5].setVisible(true);
            map.small[6].setVisible(true);
            map.small[6].repaint();
            map.small[5].repaint();
        }

    }

    public SingleGame(JFrame myframe1,Player player1,Map map1){
        this.player=player1;
        myframe=myframe1;
        map=map1;
        turn=true;
        nandu=((int) (Math.random()*7))+1;
    }

    public void button(){
        if(nandu==1){
            map.mypanel.icon=Picture.panel;
        }else if(nandu==2){
            map.mypanel.icon=Picture.panel2;
        }else if(nandu==3){
            map.mypanel.icon=Picture.panel3;
        }else if(nandu==4){
            map.mypanel.icon=Picture.panel4;
        }else if (nandu==5) {
            map.mypanel.icon=Picture.panel5;
        }else if (nandu==6) {
            map.mypanel.icon=Picture.panel6;
        }else if (nandu==7) {
            map.mypanel.icon=Picture.panel7;
        }

        map.mypanel.repaint();

        for(OtherButton oth:map.button){
            oth.addMouseListener(new ButtonSettingListener());
        }

        for(SmallLabel sma:map.small){
            sma.addMouseListener(new SmalllabelListener());
        }

        map.singlestartxuanfu.setVisible(true);
        map.singlestartxuanfu.repaint();
        start1();

    }

public void start1(){

    for(LineLabel lin:map.array.label){
        lin.condition=false;
        lin.icon=null;
        lin.setIcon(lin.icon);
        lin.repaint();
    }
    
    map.array.x=0;
    
    for(Boxx lin:map.array.box){
        lin.icon=null;
        lin.number=0;
        lin.setIcon(lin.icon);
        lin.repaint();
    }

   // myframe.update(myframe.getGraphics());// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌

}

    public void singlerun(Boolean turn1){

        for(JLabel lab:map.array.label){
            lab.addMouseListener(new LineLabelListener());
        }

        turn=turn1;
        thisgame=turn1;

        thread=new Thread(this);
        thread.start();

        if(!turn){
            Ai ai=new Ai(map.array);
            LineLabel but=ai.complete(nandu);

            for(LineLabel lab:map.array.label){
                if((but==lab)&&(!lab.condition)){
                    turn=map.luozi(but, turn,false);
                    time=true;
                    turn=!turn;
                    break;
                }
            }
        }

    }

    class LineLabelListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            LineLabel but=(LineLabel) e.getSource();

            for(LineLabel lab:map.array.label){
                if((but==lab)&&(!lab.condition)){
                    turn=map.luozi(but, turn,false);
                    time=true;
                    turn=!turn;
                    break;
                }
            }
            if(map.isend()){
//                try {
//                    thread.sleep(1000000);
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
                System.out.println(map.win());
                if((map.win().equals("RedWin!"))){
                    player.hassinglewin();
                }else{
                    player.hassinglelose();
                }
                if(map.win().equals("RedWin!")){
                    map.normalRedwin.setVisible(true);
                    map.normalRedwin.repaint();
                    map.small[5].setVisible(true);
                    map.small[6].setVisible(true);
                    map.small[6].repaint();
                    map.small[5].repaint();
                }else{
                    map.normalBluewin.setVisible(true);
                    map.small[5].setVisible(true);
                    map.small[6].setVisible(true);
                    map.small[6].repaint();
                    map.small[5].repaint();
                    map.normalBluewin.repaint();
                }
                turn=true;
            }

            //    myframe.update(myframe.getGraphics());// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌

            while(!turn){
                Ai ai=new Ai(map.array);
                but=ai.complete(nandu);
                System.out.println(but.note);

                for(LineLabel lab:map.array.label){
                    if((but==lab)&&(!lab.condition)){
                        turn=map.luozi(but, turn,false);
                        time=true;
                        turn=!turn;
                        break;
                    }
                }
                if(map.isend()){
//                    try {
//                        thread.sleep(1000000);
//                    } catch (InterruptedException e1) {
//                        e1.printStackTrace();
//                    }
                    System.out.println(map.win());
                    if((map.win().equals("RedWin!"))){
                        player.hassinglewin();
                    }else{
                        player.hassinglelose();
                    }
                    if(map.win().equals("RedWin!")){
                        map.normalRedwin.setVisible(true);
                        map.normalRedwin.repaint();
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                    }else{
                        map.normalBluewin.setVisible(true);
                        map.small[5].setVisible(true);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                        map.small[5].repaint();
                        map.normalBluewin.repaint();
                    }
                    turn=true;
                }
            }


        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {

//            LineLabel but=(LineLabel) e.getSource();
//
//            for(LineLabel lab:map.array.label){
//                if(but==lab&&(!lab.condition)){
//                    lab.icon= LabelPicture.lineiconMovein;
//                    lab.setIcon(lab.icon);
//                    lab.repaint();
//                }
//            }

            //    myframe.update(myframe.getGraphics());// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌
        }

        @Override
        public void mouseExited(MouseEvent e) {

//            LineLabel but=(LineLabel) e.getSource();
//
//            for(LineLabel lab:map.array.label){
//                if(but==lab&&(!lab.condition)){
//                    lab.icon= LabelPicture.lineiconMoveout;
//                    lab.setIcon(lab.icon);
//                    lab.repaint();
//                }
//            }

            //     myframe.update(myframe.getGraphics());// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌
        }
}

    class SmalllabelListener implements MouseListener{


        @Override
        public void mouseClicked(MouseEvent e) {

            SmallLabel but=(SmallLabel) e.getSource();

            if(but.name.equals("Xianshou")){
                map.singlestartxuanfu.setVisible(false);
                map.singlestartxuanfu.repaint();
                singlerun(true);
            }else if(but.name.equals("Houshou")){
                map.singlestartxuanfu.setVisible(false);
                map.singlestartxuanfu.repaint();
                singlerun(false);
            }else if(but.name.equals("Easy")){
            	but.x=1;
                but.seteasy2();
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.setIcon(but.icon);
                but.repaint();
                map.small[3].setmedium();
                map.small[4].sethard();
                map.small[3].setIcon(map.small[3].icon);
                map.small[3].setBounds(map.small[3].x_axis, map.small[3].y_axis, map.small[3].width, map.small[3].height);
                map.small[4].setIcon(map.small[4].icon);
                map.small[4].setBounds(map.small[4].x_axis,map.small[4].y_axis,map.small[4].width,map.small[4].height);
                map.small[3].repaint();
                map.small[4].repaint();
            }else if(but.name.equals("Medium")){
            	but.x=2;
                but.setmedium2();
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.setIcon(but.icon);
                but.repaint();
                map.small[2].seteasy();
                map.small[4].sethard();
                map.small[2].setIcon(map.small[2].icon);
                map.small[2].setBounds(map.small[2].x_axis, map.small[2].y_axis, map.small[2].width, map.small[2].height);
                map.small[4].setIcon(map.small[4].icon);
                map.small[4].setBounds(map.small[4].x_axis,map.small[4].y_axis,map.small[4].width,map.small[4].height);
                map.small[2].repaint();
                map.small[4].repaint();
            }else if(but.name.equals("Hard")){
            	but.x=3;
                but.sethard2();
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.setIcon(but.icon);
                but.repaint();
                map.small[3].setmedium();
                map.small[2].seteasy();
                map.small[3].setIcon(map.small[3].icon);
                map.small[3].setBounds(map.small[3].x_axis, map.small[3].y_axis, map.small[3].width, map.small[3].height);
                map.small[2].setIcon(map.small[2].icon);
                map.small[2].setBounds(map.small[2].x_axis,map.small[2].y_axis,map.small[2].width,map.small[2].height);
                map.small[3].repaint();
                map.small[2].repaint();
            }

            if (but.name.equals("Restart")) {
                thread.stop();
                map.mypanel.remove(map.lab);
                map.mypanel.remove(map.lab1);
                map.normalBluewin.setVisible(false);
                map.normalRedwin.setVisible(false);
                map.small[5].setVisible(false);
                map.small[6].setVisible(false);
                map.small[6].repaint();
                map.small[5].repaint();
                map.normalBluewin.repaint();
                map.normalRedwin.repaint();
                map.singlestartxuanfu.setVisible(true);
                map.singlestartxuanfu.repaint();
                start1();
            }else if(but.name.equals("QuitGame")){
                thread.stop();
                map.mypanel.remove(map.lab);
                map.mypanel.remove(map.lab1);
                map.normalBluewin.setVisible(false);
                map.normalRedwin.setVisible(false);
                map.small[5].setVisible(false);
                map.small[6].setVisible(false);
                map.mypanel.setVisible(false);
                map.mypanel.repaint();
                map.small[6].repaint();
                map.small[5].repaint();
                map.normalBluewin.repaint();
                map.normalRedwin.repaint();
                PanelBegin panelBegin=new PanelBegin((GameFrame) myframe,1);
    			JPanel panel=(JPanel) myframe.getContentPane();
    			myframe.remove(panel);
    			myframe.setContentPane(panelBegin);
    			myframe.setVisible(true);
                //鍒囧叆涓荤晫闈�
            }else if(but.name.equals("Quit")){
                thread.stop();
                map.mypanel.remove(map.lab);
                map.mypanel.remove(map.lab1);
                map.mypanel.setVisible(false);
                map.mypanel.repaint();
                PanelBegin panelBegin=new PanelBegin((GameFrame) myframe,1);
    			JPanel panel=(JPanel) myframe.getContentPane();
    			myframe.remove(panel);
    			myframe.setContentPane(panelBegin);
    			myframe.setVisible(true);
                //璺宠浆鑷充富鐣岄潰!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            }else if(but.name.equals("Cancel")){
            	map.homexuanfu.setVisible(false);
            	map.small[7].setVisible(false);
            	map.small[8].setVisible(false);
            	map.homexuanfu.repaint();
            	map.small[7].repaint();
            	map.small[8].repaint();
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
        	
            SmallLabel but=(SmallLabel) e.getSource();

                if(but.name.equals("Restart")){
                but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                but.repaint();
                }else if(but.name.equals("QuitGame")){
                    but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Quit")){
                    but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Cancel")){
                    but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Xianshou")){
                    but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Houshou")){
                    but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                    but.repaint();
                if(but.name.equals("Easy")){
                	if(SmallLabel.x!=1){
                  	but.seteasy2();
                    but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                    but.setIcon(but.icon);
                    but.repaint();
                	}
                }else if(but.name.equals("Medium")){
                	if(SmallLabel.x!=2){
                	but.setmedium2();
                    but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                    but.setIcon(but.icon);
                    but.repaint();
                	}
                }else if(but.name.equals("Hard")){
                	if(SmallLabel.x!=3){
                	but.sethard2();
                	but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                    but.setIcon(but.icon);
                    but.repaint();
                	}
                	
                }
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {

            SmallLabel but=(SmallLabel) e.getSource();

            if(but.name.equals("Restart")){
            but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
            but.repaint();
            }else if(but.name.equals("QuitGame")){
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.repaint();
            }else if(but.name.equals("Quit")){
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.repaint();
            }else if(but.name.equals("Cancel")){
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.repaint();
            }else if(but.name.equals("Xianshou")){
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.repaint();
            }else if(but.name.equals("Houshou")){
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.repaint();
            }else if(but.name.equals("Easy")){
            	if(SmallLabel.x!=1){
            	but.seteasy();
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.setIcon(but.icon);
                but.repaint();
            	}
            }else if(but.name.equals("Medium")){
            	if(SmallLabel.x!=2){
            	but.setmedium();
                but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.setIcon(but.icon);
                but.repaint();
            	}
            }else if(but.name.equals("Hard")){
            	if(SmallLabel.x!=3){
            	but.sethard();
            	but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                but.setIcon(but.icon);
                but.repaint();
            	}
            }
        }

    }
    class ButtonSettingListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            OtherButton but=(OtherButton) e.getSource();

            if(but.name.equals("Home")){
                map.homexuanfu.setVisible(true);
                map.homexuanfu.repaint();
                map.small[7].setVisible(true);
                map.small[8].setVisible(true);
                map.small[7].repaint();
                map.small[8].repaint();
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
