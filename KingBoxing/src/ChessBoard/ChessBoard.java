package ChessBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by DELL on 14-5-18.
 */
public class ChessBoard {
    JFrame myframe;
    Player player;
    Map map;
    SingleGame single;
    DoubleGame doublegame;
    Online online;
    Story story;
    SuperGame supergame;
    int x;
    //Thread thread1;

    public ChessBoard(JFrame myframe1,Player player1,int x1,int x2,Boolean boo){
    	//this.thread1=thread1;
        myframe=myframe1;
        player=player1;
        map=new Map(myframe1);
        x=x1;
        if (x1==1) {
            single=new SingleGame(myframe,player,map);
        }else if(x1==2){
            doublegame=new DoubleGame(myframe,player,map);
        }else if(x1==3){
            online=new Online(myframe,player,map,boo);
        }else if(x1==4){
            story=new Story(myframe,player,map,x2);
        }else if(x1==5){
            supergame=new SuperGame(myframe,player,map,x2);
        }
    }

    public void setboard(){
        if (x==5) {
            map.setMap(true);
        }else{
            map.setMap(false);
        }



        map.singlestartxuanfu.setVisible(false);
     // map.onlinexuanfu.setVisible(false);

        map. mypanel.setVisible(true);
   //   myframe.add(map.singlestartxuanfu);
        myframe.add(map.mypanel);
        myframe.setVisible(true);


        if(x==1){
            single.button();
        }else if(x==2){
            doublegame.button();
        }else if(x==3&&online.isclient){
            online.button();
        }else if(x==4){
            story.button();
        }else if(x==5){
            supergame.button();
        }

    }

    public void setboard(String ip){

        map.setMap(false);

        map.singlestartxuanfu.setVisible(false);
     // map.onlinexuanfu.setVisible(false);

        map. mypanel.setVisible(true);
   //   myframe.add(map.singlestartxuanfu);
        myframe.add(map.mypanel);
        myframe.setVisible(true);

        if (x==3) {
            online.button(ip);
        }

    }

}

