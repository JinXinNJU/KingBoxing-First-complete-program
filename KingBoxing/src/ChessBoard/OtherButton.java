package ChessBoard;

import javax.swing.*;

/**
 * Created by DELL on 14-5-18.
 */
public class OtherButton extends JLabel {

    String name;
    int x_axis;
    int y_axis;
    int width;
    int height;
    ImageIcon icon;

    public OtherButton(String name){
        this.name=name;
    }
    public void setstart(){
        this.x_axis=ButtonPicture.startx_axis;
        this.y_axis=ButtonPicture.starty_axis;
        this.width=ButtonPicture.startwidth;
        this.height=ButtonPicture.startheight;
        this.icon=ButtonPicture.starticon;
    }
//    public void setsetting(){
//        this.x_axis=ButtonPicture.settingx_axis;
//        this.y_axis=ButtonPicture.settingy_axis;
//        this.width=ButtonPicture.settingwidth;
//        this.height=ButtonPicture.settingheight;
//        this.icon=ButtonPicture.settingicon;
//    }

    public void sethome(){
        this.x_axis=ButtonPicture.homex_axis;
        this.y_axis=ButtonPicture.homey_axis;
        this.width=ButtonPicture.homewidth;
        this.height=ButtonPicture.homeheight;
        this.icon=ButtonPicture.homeicon;
    }
//    public void setjoin(){
//        this.x_axis=ButtonPicture.joinx_axis;
//        this.y_axis=ButtonPicture.joiny_axis;
//        this.width=ButtonPicture.joinwidth;
//        this.height=ButtonPicture.joinheight;
//        this.icon=ButtonPicture.joinicon;
//    }

}


class ButtonPicture{
    static ImageIcon starticon=new ImageIcon("Picture/start.png");
//    static ImageIcon settingicon;
    static ImageIcon homeicon=new ImageIcon("Picture/home.png");
//    static ImageIcon joinicon;

    static int startx_axis=10;
    static int starty_axis=457;
    static int startwidth=53;
    static int startheight=45;

//    static int settingx_axis;
//    static int settingy_axis;
//    static int settingwidth;
//    static int settingheight;


    static int homex_axis=49;
    static int homey_axis=492;
    static int homewidth=55;
    static int homeheight=47;

//    static int joinx_axis;
//    static int joiny_axis;
//    static int joinwidth;
//    static int joinheight;
}
