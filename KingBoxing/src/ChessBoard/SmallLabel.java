package ChessBoard;

import javax.swing.*;

/**
 * Created by DELL on 14-5-19.
 */
public class SmallLabel extends JLabel {
    String name;
    int x_axis;
    int y_axis;
    int width;
    int height;
    ImageIcon icon;
    static int x=2;

    public SmallLabel(String name1){
        this.name=name1;
    }

    public void setxianshou(){
        this.x_axis=SmallLabelPicture.xianshoux_axis;
        this.y_axis=SmallLabelPicture.xianshouy_axis;
        this.width=SmallLabelPicture.xianshouwidth;
        this.height=SmallLabelPicture.xianshouheight;
        this.icon=SmallLabelPicture.xianshouicon;
    }
    public void setxianshou2(){
        this.x_axis=SmallLabelPicture.xianshoux_axis2;
        this.y_axis=SmallLabelPicture.xianshouy_axis2;
        this.width=SmallLabelPicture.xianshouwidth2;
        this.height=SmallLabelPicture.xianshouheight2;
        this.icon=SmallLabelPicture.xianshouicon2;
    }

    public void sethoushou(){
        this.x_axis=SmallLabelPicture.houshoux_axis;
        this.y_axis=SmallLabelPicture.houshouy_axis;
        this.width=SmallLabelPicture.houshouwidth;
        this.height=SmallLabelPicture.houshouheight;
        this.icon=SmallLabelPicture.houshouicon;
    }
    public void sethoushou2(){
        this.x_axis=SmallLabelPicture.houshoux_axis2;
        this.y_axis=SmallLabelPicture.houshouy_axis2;
        this.width=SmallLabelPicture.houshouwidth2;
        this.height=SmallLabelPicture.houshouheight2;
        this.icon=SmallLabelPicture.houshouicon2;
    }
    
    public void seteasy(){
        this.x_axis=SmallLabelPicture.easyx_axis;
        this.y_axis=SmallLabelPicture.easyy_axis;
        this.width=SmallLabelPicture.easywidth;
        this.height=SmallLabelPicture.easyheight;
        this.icon=SmallLabelPicture.easyicon;
    }
    public void seteasy2(){
        this.x_axis=SmallLabelPicture.easyx_axis2;
        this.y_axis=SmallLabelPicture.easyy_axis2;
        this.width=SmallLabelPicture.easywidth2;
        this.height=SmallLabelPicture.easyheight2;
        this.icon=SmallLabelPicture.easyicon2;
    }
    
    public void setmedium(){
        this.x_axis=SmallLabelPicture.mediumx_axis;
        this.y_axis=SmallLabelPicture.mediumy_axis;
        this.width=SmallLabelPicture.mediumwidth;
        this.height=SmallLabelPicture.mediumheight;
        this.icon=SmallLabelPicture.mediumicon;
    }
    public void setmedium2(){
        this.x_axis=SmallLabelPicture.mediumx_axis2;
        this.y_axis=SmallLabelPicture.mediumy_axis2;
        this.width=SmallLabelPicture.mediumwidth2;
        this.height=SmallLabelPicture.mediumheight2;
        this.icon=SmallLabelPicture.mediumicon2;
    }
    
    public void sethard(){
        this.x_axis=SmallLabelPicture.hardx_axis;
        this.y_axis=SmallLabelPicture.hardy_axis;
        this.width=SmallLabelPicture.hardwidth;
        this.height=SmallLabelPicture.hardheight;
        this.icon=SmallLabelPicture.hardicon;
    }
    public void sethard2(){
        this.x_axis=SmallLabelPicture.hardx_axis2;
        this.y_axis=SmallLabelPicture.hardy_axis2;
        this.width=SmallLabelPicture.hardwidth2;
        this.height=SmallLabelPicture.hardheight2;
        this.icon=SmallLabelPicture.hardicon2;
    }
    
    public void setrestart(){
        this.x_axis=SmallLabelPicture.restartx_axis;
        this.y_axis=SmallLabelPicture.restarty_axis;
        this.width=SmallLabelPicture.restartwidth;
        this.height=SmallLabelPicture.restartheight;
        this.icon=SmallLabelPicture.restarticon;
    }
    public void setrestart2(){
        this.x_axis=SmallLabelPicture.restartx_axis2;
        this.y_axis=SmallLabelPicture.restarty_axis2;
        this.width=SmallLabelPicture.restartwidth2;
        this.height=SmallLabelPicture.restartheight2;
        this.icon=SmallLabelPicture.restarticon2;
    }
    
    public void setquitgame(){
        this.x_axis=SmallLabelPicture.quitgamex_axis;
        this.y_axis=SmallLabelPicture.quitgamey_axis;
        this.width=SmallLabelPicture.quitgamewidth;
        this.height=SmallLabelPicture.quitgameheight;
        this.icon=SmallLabelPicture.quitgameicon;
    }
    public void setquitgame2(){
        this.x_axis=SmallLabelPicture.quitgamex_axis2;
        this.y_axis=SmallLabelPicture.quitgamey_axis2;
        this.width=SmallLabelPicture.quitgamewidth2;
        this.height=SmallLabelPicture.quitgameheight2;
        this.icon=SmallLabelPicture.quitgameicon2;
    }
    
    public void setcontinue(){
        this.x_axis=SmallLabelPicture.continuex_axis;
        this.y_axis=SmallLabelPicture.continuey_axis;
        this.width=SmallLabelPicture.continuewidth;
        this.height=SmallLabelPicture.continueheight;
        this.icon=SmallLabelPicture.continueicon;
    }
    public void setcontinue2(){
        this.x_axis=SmallLabelPicture.continuex_axis2;
        this.y_axis=SmallLabelPicture.continuey_axis2;
        this.width=SmallLabelPicture.continuewidth2;
        this.height=SmallLabelPicture.continueheight2;
        this.icon=SmallLabelPicture.continueicon2;
    }
    
    public void setquit(){
        this.x_axis=SmallLabelPicture.quitx_axis;
        this.y_axis=SmallLabelPicture.quity_axis;
        this.width=SmallLabelPicture.quitwidth;
        this.height=SmallLabelPicture.quitheight;
        this.icon=SmallLabelPicture.quiticon;
    }
    public void setquit2(){
        this.x_axis=SmallLabelPicture.quitx_axis2;
        this.y_axis=SmallLabelPicture.quity_axis2;
        this.width=SmallLabelPicture.quitwidth2;
        this.height=SmallLabelPicture.quitheight2;
        this.icon=SmallLabelPicture.quiticon2;
    }
    
    public void setcancel(){
        this.x_axis=SmallLabelPicture.cancelx_axis;
        this.y_axis=SmallLabelPicture.cancely_axis;
        this.width=SmallLabelPicture.cancelwidth;
        this.height=SmallLabelPicture.cancelheight;
        this.icon=SmallLabelPicture.cancelicon;
    }
    public void setcancel2(){
        this.x_axis=SmallLabelPicture.cancelx_axis2;
        this.y_axis=SmallLabelPicture.cancely_axis2;
        this.width=SmallLabelPicture.cancelwidth2;
        this.height=SmallLabelPicture.cancelheight2;
        this.icon=SmallLabelPicture.cancelicon2;
    }


}

class SmallLabelPicture{
    static int xianshoux_axis=435;
    static int xianshouy_axis=350;
    static int xianshouwidth=102;
    static int xianshouheight=29;
    static ImageIcon xianshouicon=new ImageIcon("XuanfuPicture/offensive.png");
    static int xianshoux_axis2=405;
    static int xianshouy_axis2=337;
    static int xianshouwidth2=162;
    static int xianshouheight2=56;
    static ImageIcon xianshouicon2=new ImageIcon("XuanfuPicture/offensive2.png");

    static int houshoux_axis=300;
    static int houshouy_axis=350;
    static int houshouwidth=99;
    static int houshouheight=29;
    static ImageIcon houshouicon=new ImageIcon("XuanfuPicture/defensive.png");
    static int houshoux_axis2=267;
    static int houshouy_axis2=335;
    static int houshouwidth2=166;
    static int houshouheight2=58;
    static ImageIcon houshouicon2=new ImageIcon("XuanfuPicture/defensive2.png");

    static int easyx_axis=392;
    static int easyy_axis=179;
    static int easywidth=60;
    static int easyheight=34;
    static ImageIcon easyicon=new ImageIcon("XuanfuPicture/easy.png");
    static int easyx_axis2=340;
    static int easyy_axis2=167;
    static int easywidth2=157;
    static int easyheight2=57;
    static ImageIcon easyicon2=new ImageIcon("XuanfuPicture/easy2.png");

    static int mediumx_axis=370;
    static int mediumy_axis=237;
    static int mediumwidth=110;
    static int mediumheight=26;
    static ImageIcon mediumicon=new ImageIcon("XuanfuPicture/medium.png");
    static int mediumx_axis2=338;
    static int mediumy_axis2=224;
    static int mediumwidth2=165;
    static int mediumheight2=58;
    static ImageIcon mediumicon2=new ImageIcon("XuanfuPicture/medium2.png");

    static int hardx_axis=384;
    static int hardy_axis=293;
    static int hardwidth=67;
    static int hardheight=26;
    static ImageIcon hardicon=new ImageIcon("XuanfuPicture/hard.png");
    static int hardx_axis2=337;
    static int hardy_axis2=278;
    static int hardwidth2=159;
    static int hardheight2=61;
    static ImageIcon hardicon2=new ImageIcon("XuanfuPicture/hard2.png");

    static int restartx_axis=290;
    static int restarty_axis=306;
    static int restartwidth=93;
    static int restartheight=32;
    static ImageIcon restarticon=new ImageIcon("HomePicture/restart.png");
    static int restartx_axis2=257;
    static int restarty_axis2=290;
    static int restartwidth2=159;
    static int restartheight2=57;
    static ImageIcon restarticon2=new ImageIcon("HomePicture/restart2.png");

    static int quitgamex_axis=420;
    static int quitgamey_axis=300;
    static int quitgamewidth=132;
    static int quitgameheight=41;
    static ImageIcon quitgameicon=new ImageIcon("HomePicture/quitgamebutton.png");
    static int quitgamex_axis2=405;
    static int quitgamey_axis2=291;
    static int quitgamewidth2=161;
    static int quitgameheight2=58;
    static ImageIcon quitgameicon2=new ImageIcon("HomePicture/quitgamebutton2.png");

    static int continuex_axis=360;
    static int continuey_axis=243;
    static int continuewidth=114;
    static int continueheight=30;
    static ImageIcon continueicon=new ImageIcon("HomePicture/continue.png");
    static int continuex_axis2=339;
    static int continuey_axis2=231;
    static int continuewidth2=156;
    static int continueheight2=54;
    static ImageIcon continueicon2=new ImageIcon("HomePicture/continue2.png");

    static int quitx_axis=297;
    static int quity_axis=300;
    static int quitwidth=132;
    static int quitheight=41;
    static ImageIcon quiticon=new ImageIcon("HomePicture/quitgamebutton.png");
    static int quitx_axis2=282;
    static int quity_axis2=291;
    static int quitwidth2=161;
    static int quitheight2=58;
    static ImageIcon quiticon2=new ImageIcon("HomePicture/quitgamebutton2.png");

    static int cancelx_axis=437;
    static int cancely_axis=300;
    static int cancelwidth=88;
    static int cancelheight=42;
    static ImageIcon cancelicon=new ImageIcon("HomePicture/cancel.png");
    static int cancelx_axis2=397;
    static int cancely_axis2=295;
    static int cancelwidth2=167;
    static int cancelheight2=52;
    static ImageIcon cancelicon2=new ImageIcon("HomePicture/cancel2.png");


}
