package ChessBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 14-5-19.
 */
public class XuanfuPanel extends JPanel{
    String name;
    ImageIcon icon;
    public XuanfuPanel(String name1){
        name=name1;
    }

    public void paintComponent(Graphics g){
        ImageIcon icon= null;
        if (this.name.equals("StartXuanfu")) {
            icon = this.icon;
            g.drawImage(icon.getImage(), XuanfuPanelPicture.startx_axis,XuanfuPanelPicture.starty_axis,
                    XuanfuPanelPicture.startwidth, XuanfuPanelPicture.startheight, this);
        }

        //    icon= XuanfuPanelPicture.onlineicon;
    //    g.drawImage(icon.getImage(),XuanfuPanelPicture.onlinex_axis,XuanfuPanelPicture.onliney_axis,
    //            XuanfuPanelPicture.onlinewidth,XuanfuPanelPicture.onlineheight,this);

        if (this.name.equals("RedwinXuanfu")) {
            icon=this.icon;
            g.drawImage(icon.getImage(),XuanfuPanelPicture.normalRedx_axis,XuanfuPanelPicture.normalRedy_axis,
                    XuanfuPanelPicture.normalRedwidth,XuanfuPanelPicture.normalRedheight,this);
        }

        if (this.name.equals("BluewinXuanfu")) {
            icon=this.icon;
            g.drawImage(icon.getImage(),XuanfuPanelPicture.normalBluex_axis,XuanfuPanelPicture.normalBluey_axis,
                    XuanfuPanelPicture.normalBluewidth,XuanfuPanelPicture.normalBlueheight,this);
        }

        if (this.name.equals("YouWin")) {
            icon=this.icon;
            g.drawImage(icon.getImage(),XuanfuPanelPicture.youwinx_axis,XuanfuPanelPicture.youwiny_axis,
                    XuanfuPanelPicture.youwinwidth,XuanfuPanelPicture.youwinheight,this);
        }

        if (this.name.equals("YouLose")) {
            icon=this.icon;
            g.drawImage(icon.getImage(),XuanfuPanelPicture.youlosex_axis,XuanfuPanelPicture.youlosey_axis,
                    XuanfuPanelPicture.youlosewidth,XuanfuPanelPicture.youloseheight,this);
        }

        if (this.name.equals("QuitGame")) {
            icon=this.icon;
            g.drawImage(icon.getImage(),XuanfuPanelPicture.quitgamex_axis,XuanfuPanelPicture.quitgamey_axis,
                    XuanfuPanelPicture.quitgamewidth,XuanfuPanelPicture.quitgameheight,this);
        }

    }

}

class XuanfuPanelPicture{

    static ImageIcon starticon=new ImageIcon("XuanfuPicture/setting.png");
    static int startx_axis=0;
    static int starty_axis=0;
    static int startwidth=821;
    static int startheight=547;

//    static ImageIcon onlineicon;
//    static int onlinex_axis;
//    static int onliney_axis;
//    static int onlinewidth;
//    static int onlineheight;

    static ImageIcon normalRedicon=new ImageIcon("HomePicture/redwin.png");
    static int normalRedx_axis=0;
    static int normalRedy_axis=0;
    static int normalRedwidth=821;
    static int normalRedheight=547;

    static ImageIcon normalBlueicon=new ImageIcon("HomePicture/bluewin.png");
    static int normalBluex_axis=0;
    static int normalBluey_axis=0;
    static int normalBluewidth=821;
    static int normalBlueheight=547;

    static ImageIcon quitgameicon=new ImageIcon("HomePicture/quitgame.png");
    static int quitgamex_axis=0;
    static int quitgamey_axis=0;
    static int quitgamewidth=821;
    static int quitgameheight=547;

    static ImageIcon youwinicon=new ImageIcon("HomePicture/youwin.png");
    static int youwinx_axis=0;
    static int youwiny_axis=0;
    static int youwinwidth=821;
    static int youwinheight=547;

    static ImageIcon youloseicon=new ImageIcon("HomePicture/youlose.png");
    static int youlosex_axis=0;
    static int youlosey_axis=0;
    static int youlosewidth=821;
    static int youloseheight=547;

}
