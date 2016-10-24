package ChessBoard;

import Ai.Ai;

import javax.swing.*;

import ui.GameFrame;
import ui.PanelBegin;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by DELL on 14-5-24.
 */
public class SuperGame implements Runnable{


    /**
     * Created by DELL on 14-5-18.
     */
        JFrame myframe;
        Map map;
        Boolean turn;
        Player player;
        int nandu;
        Thread thread=new Thread(this);
        Boolean time=false;
        Boolean thisgame;
        int model;
Thread thread1;

    public void run(){
        int i=180;
        //      System.out.println("hahaha");
        JLabel lab= null;
        JLabel lab1=new JLabel("0:0"); 
      
        while(i>0) {
            if(time){
                i=180;
                lab1=new JLabel(String.valueOf(map.array.getRed())+":"+map.array.getBlue());
                time=false;
            }
            //   System.out.println(i);
            lab = new JLabel(String.valueOf(i));
            //    lab1=new JLabel()
            Font font=new Font("宋体",Font.PLAIN,40);
            lab.setForeground(Color.white);
            lab.setFont(font);
            lab.setBounds(160, 25, 140, 80);
            lab.setVisible(true);
            lab1.setForeground(Color.white);
            lab1.setFont(font);
            lab1.setBounds(172, 115, 100, 60);
            lab1.setVisible(true);
            map.mypanel.add(lab);
            map.mypanel.add(lab1);
            lab.repaint();
            lab1.repaint();

            try {
                for (int j=0;j<100;j++) {
                    thread.sleep(10);
                    if(time){
                        break;
                    }
                }
                map.mypanel.remove(lab);
                map.mypanel.remove(lab1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }

        if(turn){
            map.normalBluewin.setVisible(true);
            map.small[6].setVisible(true);
            map.small[6].repaint();
            map.normalBluewin.repaint();
        }else{
            map.normalRedwin.setVisible(true);
            map.normalRedwin.repaint();
            map.small[6].setVisible(true);
            map.small[6].repaint();
        }

    }

        public SuperGame(JFrame myframe1,Player player1,Map map1,int x1){
            this.player=player1;
            myframe=myframe1;
            map=map1;
            turn=true;
            nandu=((int) (Math.random()*8))+1;
            model=x1;
        }

        public void button(){
            if(nandu==1){
                map.mypanel.icon=Picture.newpanel;
            }else if(nandu==2){
                map.mypanel.icon=Picture.newpanel2;
            }else if(nandu==3){
                map.mypanel.icon=Picture.newpanel3;
            }else if(nandu==4){
                map.mypanel.icon=Picture.newpanel4;
            }else if (nandu==5) {
                map.mypanel.icon=Picture.newpanel5;
            }else if (nandu==6) {
                map.mypanel.icon=Picture.newpanel6;
            }else if (nandu==7) {
                map.mypanel.icon=Picture.newpanel7;
            }else if(nandu==8){
                map.mypanel.icon=Picture.newpanel8;
            }

            map.mypanel.repaint();

            for(OtherButton oth:map.button){
                oth.addMouseListener(new ButtonSettingListener());
            }
            for(SmallLabel sma:map.small){
                sma.addMouseListener(new SmalllabelListener());
            }
            for(LineLabel lab:map.array.label){
                lab.addMouseListener(new LineLabelListener());
            }

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

            singlerun(true);

            // myframe.update(myframe.getGraphics());// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌

        }

        public void singlerun(Boolean turn1){

            turn=turn1;
            thisgame=turn1;

            thread=new Thread(this);
            thread.start();

            if(!turn){
                Ai ai=new Ai(map.array);
                LineLabel but=ai.complete(nandu);

                for(LineLabel lab:map.array.label){
                    if((but==lab)&&(!lab.condition)){
                        turn=map.luozi(but, turn,true);
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
                        turn=map.luozi(but, turn,true);
                        time=true;
                        turn=!turn;
                        break;
                    }
                }
                if(map.isend()){
                    System.out.println(map.win());
                    if((map.win().equals("RedWin!"))){
                        player.hassinglewin();
                    }else{
                        player.hassinglelose();
                    }
                    if(map.win().equals("RedWin!")){
                        map.normalRedwin.setVisible(true);
                        map.normalRedwin.repaint();
                        map.small[6].setLocation(SmallLabelPicture.quitgamex_axis-62,SmallLabelPicture.quitgamey_axis);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
                    }else{
                        map.normalBluewin.setVisible(true);
                        map.small[6].setLocation(SmallLabelPicture.quitgamex_axis-62,SmallLabelPicture.quitgamey_axis);
                        map.small[6].setVisible(true);
                        map.small[6].repaint();
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
                            turn=map.luozi(but, turn,true);
                            time=true;
                            turn=!turn;
                            break;
                        }
                    }
                    if(map.isend()){
                        System.out.println(map.win());
                        if((map.win().equals("RedWin!"))){
                            player.hassinglewin();
                        }else{
                            player.hassinglelose();
                        }
                        if(map.win().equals("RedWin!")){
                            map.small[6].setLocation(SmallLabelPicture.quitgamex_axis-62,SmallLabelPicture.quitgamey_axis);
                            map.normalRedwin.setVisible(true);
                            map.normalRedwin.repaint();
                            map.small[6].setVisible(true);
                            map.small[6].repaint();
                        }else{
                            map.small[6].setLocation(SmallLabelPicture.quitgamex_axis-62,SmallLabelPicture.quitgamey_axis);
                            map.normalBluewin.setVisible(true);
                            map.small[6].setVisible(true);
                            map.small[6].repaint();
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

//                LineLabel but=(LineLabel) e.getSource();
//
//                for(LineLabel lab:map.array.label){
//                    if(but==lab&&(!lab.condition)){
//                        lab.icon= LabelPicture.newlineiconMovein;
//                        lab.setIcon(lab.icon);
//                        lab.repaint();
//                    }
//                }

                //    myframe.update(myframe.getGraphics());// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌
            }

            @Override
            public void mouseExited(MouseEvent e) {
//
//                LineLabel but=(LineLabel) e.getSource();
//
//                for(LineLabel lab:map.array.label){
//                    if(but==lab&&(!lab.condition)){
//                        lab.icon= LabelPicture.newlineiconMoveout;
//                        lab.setIcon(lab.icon);
//                        lab.repaint();
//                    }
//                }

                //     myframe.update(myframe.getGraphics());// 寰幆閲岃寮哄埗鏇存柊銆傘�鐢荤瑪鏄痶his.getGraphics()寰楀埌
            }
        }


        class SmalllabelListener implements MouseListener{


            @Override
            public void mouseClicked(MouseEvent e) {

                SmallLabel but=(SmallLabel) e.getSource();

               if(but.name.equals("QuitGame")){
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
                //鍒囧叆杞洏
                
                PanelBegin panelBegin=new PanelBegin((GameFrame) myframe,5201314);
    			JPanel panel=(JPanel) myframe.getContentPane();
    			myframe.remove(panel);
    			myframe.setContentPane(panelBegin);
    			myframe.setVisible(true);
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

                if(but.name.equals("QuitGame")){
                    but.setBounds(but.x_axis-60, but.y_axis+2, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Quit")){
                    but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Cancel")){
                    but.setBounds(but.x_axis+2, but.y_axis+2, but.width, but.height);
                    but.repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SmallLabel but=(SmallLabel) e.getSource();

                if(but.name.equals("QuitGame")){
                    but.setBounds(but.x_axis-62, but.y_axis, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Quit")){
                    but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                    but.repaint();
                }else if(but.name.equals("Cancel")){
                    but.setBounds(but.x_axis, but.y_axis, but.width, but.height);
                    but.repaint();
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
