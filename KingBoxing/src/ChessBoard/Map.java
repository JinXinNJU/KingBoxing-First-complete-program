package ChessBoard;

import javax.swing.*;

import java.util.ArrayList;

/**
 * Created by DELL on 14-5-18.
 */
public class Map {
	JFrame myframe;
    ArrayList<OtherButton> button=new ArrayList<OtherButton>();
    MyPanel mypanel=new MyPanel();
    Array array=new Array();
    SmallLabel singlestartxuanfu=new SmallLabel("Start");
    JLabel lab= new JLabel();
    JLabel lab1=new JLabel("0:0");
    SmallLabel normalBluewin=new SmallLabel("Bluewin");
    SmallLabel normalRedwin=new SmallLabel("Redwin");
    SmallLabel youwin=new SmallLabel("Youwin");
    SmallLabel youlose=new SmallLabel("Youlose");
    SmallLabel homexuanfu=new SmallLabel("Home");
    SmallLabel[] small=new SmallLabel[10];
    Boolean special;
 //   MyPanel score_time=new MyPanel();
 //   OtherButton join=new OtherButton("Join");

    public Map(JFrame myframe1){
    	myframe=myframe1;
    }
    
    public void setMap(Boolean special1){
        int i=0;
        special=special1;

        mypanel.setLayout(null);
        mypanel.setBounds(0, 0, Picture.framewidth, Picture.frameheight);
        mypanel.icon=Picture.panel;

        singlestartxuanfu.setLayout(null);
        singlestartxuanfu.setBounds(XuanfuPanelPicture.startx_axis, XuanfuPanelPicture.starty_axis, XuanfuPanelPicture.startwidth, XuanfuPanelPicture.startheight);
        singlestartxuanfu.setIcon(XuanfuPanelPicture.starticon);
        singlestartxuanfu.setVisible(false);
        mypanel.add(singlestartxuanfu);

//        singlestartxuanfu.setLayout(null);
//        singlestartxuanfu.setVisible(false);
//        singlestartxuanfu.icon=XuanfuPanelPicture.starticon;
//        singlestartxuanfu.setBounds(XuanfuPanelPicture.startx_axis, XuanfuPanelPicture.starty_axis,XuanfuPanelPicture.startwidth, XuanfuPanelPicture.startheight);


//        youwin.setLayout(null);
//        youwin.setVisible(false);
//        youwin.icon=XuanfuPanelPicture.youwinicon;
//        youwin.setBounds(XuanfuPanelPicture.youwinx_axis, XuanfuPanelPicture.youwiny_axis, XuanfuPanelPicture.youwinwidth, XuanfuPanelPicture.youwinheight);

//        youlose.setLayout(null);
//        youlose.setVisible(false);
//        youlose.icon=XuanfuPanelPicture.youloseicon;
//        youlose.setBounds(XuanfuPanelPicture.youlosex_axis, XuanfuPanelPicture.youlosey_axis, XuanfuPanelPicture.youlosewidth, XuanfuPanelPicture.youloseheight);

//        normalRedwin.setLayout(null);
//        normalRedwin.setVisible(false);
//        normalRedwin.icon=XuanfuPanelPicture.normalRedicon;
//        normalRedwin.setBounds(XuanfuPanelPicture.normalRedx_axis, XuanfuPanelPicture.normalRedy_axis, XuanfuPanelPicture.normalRedwidth, XuanfuPanelPicture.normalRedheight);

//        normalBluewin.setLayout(null);
//        normalBluewin.setVisible(false);
//        normalBluewin.icon=XuanfuPanelPicture.normalBlueicon;
//        normalBluewin.setBounds(XuanfuPanelPicture.normalBluex_axis,XuanfuPanelPicture.normalBluey_axis, XuanfuPanelPicture.normalBluewidth,XuanfuPanelPicture.normalBlueheight);
//
//        normalBluewin1.setLayout(null);
//        normalBluewin1.setVisible(false);
//        normalBluewin1.icon=XuanfuPanelPicture.normalBlueicon;
//        normalBluewin1.setBounds(XuanfuPanelPicture.normalBluex_axis,XuanfuPanelPicture.normalBluey_axis, XuanfuPanelPicture.normalBluewidth,XuanfuPanelPicture.normalBlueheight);
//
//
        normalBluewin.setLayout(null);
        normalBluewin.setBounds(XuanfuPanelPicture.normalBluex_axis, XuanfuPanelPicture.normalBluey_axis, XuanfuPanelPicture.normalBluewidth, XuanfuPanelPicture.normalBlueheight);
        normalBluewin.setIcon(XuanfuPanelPicture.normalBlueicon);
        normalBluewin.setVisible(false);

        normalRedwin.setLayout(null);
        normalRedwin.setBounds(XuanfuPanelPicture.normalRedx_axis, XuanfuPanelPicture.normalRedy_axis, XuanfuPanelPicture.normalRedwidth, XuanfuPanelPicture.normalRedheight);
        normalRedwin.setIcon(XuanfuPanelPicture.normalRedicon);
        normalRedwin.setVisible(false);

        youwin.setLayout(null);
        youwin.setBounds(XuanfuPanelPicture.youwinx_axis, XuanfuPanelPicture.youwiny_axis, XuanfuPanelPicture.youwinwidth, XuanfuPanelPicture.youwinheight);
        youwin.setIcon(XuanfuPanelPicture.youwinicon);
        youwin.setVisible(false);

        youlose.setLayout(null);
        youlose.setBounds(XuanfuPanelPicture.youlosex_axis, XuanfuPanelPicture.youlosey_axis, XuanfuPanelPicture.youlosewidth, XuanfuPanelPicture.youloseheight);
        youlose.setIcon(XuanfuPanelPicture.youloseicon);
        youlose.setVisible(false);

        homexuanfu.setLayout(null);
        homexuanfu.setVisible(false);
        homexuanfu.setIcon(XuanfuPanelPicture.quitgameicon);
        homexuanfu.setBounds(XuanfuPanelPicture.quitgamex_axis, XuanfuPanelPicture.quitgamey_axis, XuanfuPanelPicture.quitgamewidth, XuanfuPanelPicture.quitgameheight);
        
        this.setotherbutton();
        this.setsmalllabel();

        mypanel.add(small[5]);
        mypanel.add(small[6]);
        mypanel.add(small[7]);
        mypanel.add(small[8]);
        mypanel.add(small[9]);
        mypanel.add(homexuanfu);
        mypanel.add(singlestartxuanfu);
        mypanel.add(normalRedwin);
        mypanel.add(normalBluewin);
        mypanel.add(youwin);
        mypanel.add(youlose);

   //   mypanel.setBounds(0, 0, Picture.framewidth, Picture.frameheight);

        for(i=0;i<this.array.box.length;i++){
            this.array.box[i]=new Boxx(i);
            if (special) {
                this.array.box[i].setBounds(this.array.box[i].getnewX_axis(),this.array.box[i].getnewY_axis(),BoxxPicture.box_line,BoxxPicture.box_line);
            }else{
                this.array.box[i].setBounds(this.array.box[i].getX_axis(),this.array.box[i].getY_axis(), BoxxPicture.box_line, BoxxPicture.box_line);
            }
            this.array.box[i].setIcon(this.array.box[i].icon);
            this.array.box[i].setVisible(false);
            mypanel.add(this.array.box[i]);
        }

        for(i=0;i<this.array.label.length;i++){
            this.array.label[i]=new LineLabel(i);
            this.array.label[i].setOpaque(false);
            this.array.label[i].setVisible(true);
            //    System.out.println(array.label[i].x_axis+";"+array.label[i].y_axis+";"+array.label[i].getwidth()+";"+array.label[i].getheight());
            if (special) {
                this.array.label[i].setBounds(this.array.label[i].getnewx_axis(),this.array.label[i].getnewy_axis(),this.array.label[i].getnewwidth(),this.array.label[i].getnewheight());
            } else {
                this.array.label[i].setBounds(array.label[i].x_axis,array.label[i].y_axis, array.label[i].getwidth(), array.label[i].getheight());
            }
            this.array.label[i].setIcon(this.array.label[i].icon);
            mypanel.add(this.array.label[i]);
        }

        for(Boxx boxx:this.array.box){
            boxx.buttonup=this.array.getbuttonup(boxx);
            boxx.buttondown=this.array.getbuttondown(boxx);
            boxx.buttonleft=this.array.getbuttonleft(boxx);
            boxx.buttonright=this.array.getbuttonright(boxx);
        }
        for(LineLabel lab:this.array.label){
            lab.box1=this.array.getbox1(lab);
            if(lab.isexist){
                lab.box2=this.array.getbox2(lab);
            }
        }
    }

    public void setsmalllabel(){

        SmallLabel start_xianshou=new SmallLabel("Xianshou");
        start_xianshou.setxianshou();
        start_xianshou.setBounds(start_xianshou.x_axis,start_xianshou.y_axis,start_xianshou.width,start_xianshou.height);
        start_xianshou.setIcon(start_xianshou.icon);
        start_xianshou.setVisible(true);
        singlestartxuanfu.add(start_xianshou);
        small[0]=start_xianshou;

        SmallLabel start_houshou=new SmallLabel("Houshou");
        start_houshou.sethoushou();
        start_houshou.setBounds(start_houshou.x_axis,start_houshou.y_axis,start_houshou.width,start_houshou.height);
        start_houshou.setIcon(start_houshou.icon);
        start_houshou.setVisible(true);
        singlestartxuanfu.add(start_houshou);
        small[1]=start_houshou;

        SmallLabel start_easy=new SmallLabel("Easy");
        start_easy.seteasy();
        start_easy.setBounds(start_easy.x_axis,start_easy.y_axis,start_easy.width,start_easy.height);
        start_easy.setIcon(start_easy.icon);
        start_easy.setVisible(true);
        singlestartxuanfu.add(start_easy);
        small[2]=start_easy;

        SmallLabel start_medium=new SmallLabel("Medium");
        start_medium.setmedium2();
        start_medium.setBounds(start_medium.x_axis,start_medium.y_axis,start_medium.width,start_medium.height);
        start_medium.setIcon(SmallLabelPicture.mediumicon2);
        start_medium.setVisible(true);
        singlestartxuanfu.add(start_medium);
        small[3]=start_medium;

        SmallLabel start_hard=new SmallLabel("Hard");
        start_hard.sethard();
        start_hard.setBounds(start_hard.x_axis,start_hard.y_axis,start_hard.width,start_hard.height);
        start_hard.setIcon(start_hard.icon);
        start_hard.setVisible(true);
        singlestartxuanfu.add(start_hard);
        small[4]=start_hard;

        SmallLabel restart=new SmallLabel("Restart");
        restart.setrestart();
        restart.setBounds(restart.x_axis, restart.y_axis, restart.width, restart.height);
        restart.setIcon(restart.icon);
        restart.setVisible(false);
//        normalRedwin.add(restart);
//        normalBluewin.add(restart);
//        youwin.add(restart);
//        youlose.add(restart);
        small[5]=restart;

        SmallLabel quitgamebutton=new SmallLabel("QuitGame");
        quitgamebutton.setquitgame();
        quitgamebutton.setBounds(quitgamebutton.x_axis, quitgamebutton.y_axis, quitgamebutton.width, quitgamebutton.height);
        quitgamebutton.setIcon(quitgamebutton.icon);
        quitgamebutton.setVisible(false);
 //      normalRedwin.add(quitgamebutton);
 //       normalBluewin.add(quitgamebutton);
 //       youwin.add(quitgamebutton);
 //       youlose.add(quitgamebutton);
        small[6]=quitgamebutton;

        SmallLabel quit=new SmallLabel("Quit");
        quit.setquit();
        quit.setBounds(quit.x_axis, quit.y_axis, quit.width, quit.height);
        quit.setIcon(quit.icon);
        quit.setVisible(false);
        small[7]=quit;

        SmallLabel cancel=new SmallLabel("Cancel");
        cancel.setcancel();
        cancel.setBounds(cancel.x_axis, cancel.y_axis, cancel.width, cancel.height);
        cancel.setIcon(cancel.icon);
        cancel.setVisible(false);
        small[8]=cancel;

        SmallLabel continued=new SmallLabel("Continue");
        continued.setcontinue();
        continued.setBounds(continued.x_axis,continued.y_axis,continued.width,continued.height);
        continued.setIcon(continued.icon);
        continued.setVisible(false);
//        youwin.add(continued);
//        continued.add(continued);
        small[9]=continued;

    }

    public void setotherbutton(){

        OtherButton start=new OtherButton("Start");
        start.setstart();
        start.setBounds(ButtonPicture.startx_axis, ButtonPicture.starty_axis, ButtonPicture.startwidth, ButtonPicture.startheight);
        start.setIcon(ButtonPicture.starticon);
        start.setVisible(true);
        mypanel.add(start);

        OtherButton home=new OtherButton("Home");
        home.sethome();
        home.setBounds(ButtonPicture.homex_axis, ButtonPicture.homey_axis, ButtonPicture.homewidth, ButtonPicture.homeheight);
        home.setIcon(ButtonPicture.homeicon);
        home.setVisible(true);
        mypanel.add(home);

//        join=new OtherButton("Join");
//        join.setjoin();
//        join.setBounds(ButtonPicture.joinx_axis,ButtonPicture.joiny_axis,ButtonPicture.joinwidth,ButtonPicture.joinheight);
//        join.setIcon(ButtonPicture.joinicon);
//        join.setVisible(false);
//        mypanel.add(join);

        button.add(start);
        button.add(home);

    }

    public Boolean luozi(LineLabel lab,Boolean turn,Boolean special){
    	
        if(turn){                                          //turn==true鏄帺瀹� false鏄數鑴�
            if (lab.note%11<5) {
                if (special) {
                    lab.icon=LabelPicture.newlineiconRed;
                }else{
                    lab.icon= LabelPicture.lineiconRed;                //Red鏄�1锛孊lue鏄�2
                }
            }else{
                if (special) {
                    lab.icon=LabelPicture.newlineiconRed2;
                }else{
                    lab.icon= LabelPicture.lineiconRed2;                //Red鏄�1锛孊lue鏄�2
                }
            }
        }else{
            if (lab.note%11<5) {
                if (special) {
                    lab.icon=LabelPicture.newlineiconBlue;
                }else{
                    lab.icon= LabelPicture.lineiconBlue;                //Red鏄�1锛孊lue鏄�2
                }
            }else{
                if (special) {
                    lab.icon=LabelPicture.newlineiconBlue2;
                }else{
                    lab.icon= LabelPicture.lineiconBlue2;                //Red鏄�1锛孊lue鏄�2
                }
            }
        }
        lab.setIcon(lab.icon);
        lab.repaint();
        lab.box1.number++;
        if (lab.isexist) {
            lab.box2.number++;
        }

        if(lab.isexist){
            if(lab.box1.number==4||lab.box2.number==4){
                turn=!turn;
            }
        }else{
            if(lab.box1.number==4){
                turn=!turn;
            }
        }

        if(lab.box1.number==4){
            lab.box1.setVisible(true);
            if(!turn){
                if (special) {
                   lab.box1.icon=BoxxPicture.newboxiconRed;
                }else{
                    lab.box1.icon= BoxxPicture.boxiconRed;
                }
                lab.box1.number=-1;
            }else{
                if (special) {
                    lab.box1.icon=BoxxPicture.newboxiconBlue;
                }else{
                    lab.box1.icon= BoxxPicture.boxiconBlue;
                }
                lab.box1.number=-2;
            }
            lab.box1.setIcon(lab.box1.icon);
            lab.box1.repaint();
        }
        if(lab.isexist){
            if(lab.box2.number==4){
                lab.box2.setVisible(true);
                if(!turn){
                    if (special) {
                        lab.box2.icon=BoxxPicture.newboxiconRed;
                    }else{
                        lab.box2.icon= BoxxPicture.boxiconRed;
                    }
                    lab.box2.number=-1;
                }else{
                    if (special) {
                        lab.box2.icon=BoxxPicture.newboxiconBlue;
                    }else{
                        lab.box2.icon= BoxxPicture.boxiconBlue;
                    }
                    lab.box2.number=-2;
                }
                lab.box2.setIcon(lab.box2.icon);
                lab.box2.repaint();
            }
        }
       // myframe.update(myframe.getGraphics());
        lab.condition=true;
        mypanel.repaint();
        return turn;
    }

//    public Boolean huiqiing(LineLabel lab,Boolean turn){
//        if(lab.condition){
//            lab.condition=false;
//            if (lab.box1.number>0) {
//                lab.box1.number--;
//            }else{
//                lab.box1.number=3;
//                lab.box1.icon=null;
//                lab.box1.setIcon(lab.box1.icon);
//                lab.box1.repaint();
//            }
//            if (lab.isexist){
//                if(lab.box2.number>0){
//                    lab.box2.number--;
//                }else{
//                    lab.box2.number=3;
//                    lab.box2.icon=null;
//                    lab.box2.setIcon(lab.box2.icon);
//                    lab.box2.repaint();
//                }
//            }
//
//            lab.icon=null;
//            lab.setIcon(lab.icon);
//            lab.repaint();
//            return !turn;
//        }
//
//        return turn;
//
//    }

    public Boolean isend(){
        for(Boxx lin:array.box){
            if(lin.number!=-1&&lin.number!=-2){
                return false;
            }
        }
        return true;
    }
    public String win(){
        int red=0;
        for(Boxx lin:array.box){
            if(lin.number==-1){
                red++;
            }
        }
        if(red>12){
            return "RedWin!";
        }
        return "BlueWin!";
    }

}

class Picture {
    static ImageIcon panel=new ImageIcon("Picture/1.jpg");
    static ImageIcon panel2=new ImageIcon("Picture/2.jpg");
    static ImageIcon panel3=new ImageIcon("Picture/3.jpg");
    static ImageIcon panel4=new ImageIcon("Picture/4.jpg");
    static ImageIcon panel5=new ImageIcon("Picture/5.jpg");
    static ImageIcon panel6=new ImageIcon("Picture/6.jpg");
    static ImageIcon panel7=new ImageIcon("Picture/7.jpg");
    static ImageIcon newpanel=new ImageIcon("NewPicture/1.jpg");
    static ImageIcon newpanel2=new ImageIcon("NewPicture/2.jpg");
    static ImageIcon newpanel3=new ImageIcon("NewPicture/3.jpg");
    static ImageIcon newpanel4=new ImageIcon("NewPicture/4.jpg");
    static ImageIcon newpanel5=new ImageIcon("NewPicture/5.jpg");
    static ImageIcon newpanel6=new ImageIcon("NewPicture/6.jpg");
    static ImageIcon newpanel7=new ImageIcon("NewPicture/7.jpg");
    static ImageIcon newpanel8=new ImageIcon("NewPicture/8.jpg");
    static int rownumber=5;
    static int columnnumber=5;
    static int framewidth=821;
    static int frameheight=547;
    static int frame_x=250;
    static int frame_y=80;
 //   static int score_timex_axis;
 //   static int score_timey_axis;
 //   static int score_timewidth;
 //   static int score_timeheight;
    static ImageIcon win;
    static ImageIcon lose;
   // static ImageIcon score_timeicon;
}