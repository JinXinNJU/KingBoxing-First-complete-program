package ChessBoard;

import javax.swing.*;

/**
 * Created by DELL on 14-5-18.
 */
public class LineLabel extends JLabel {


    public Boolean condition;
    public Boxx box1;
    public Boxx box2;
    public Boolean isexist;
    ImageIcon icon;
    int x_axis;
    int y_axis;
    int note;

    public LineLabel(int i){
        this.note=i;
        this.icon=null;
        this.isexist= Labelopporate.isexsis(i);
        this.x_axis=this.getx_axis();
        this.y_axis=this.gety_axis();
        this.condition=false;
    }

    public int getx_axis(){
        int x;
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            x=LabelPicture.label_x1 + (this.note% (2* Picture.rownumber+1)) * (this.getwidth()-4);
        }else{
            x= LabelPicture.label_x2 + (this.note% (2* Picture.rownumber+1) - Picture.rownumber) * (this.getheight()-4);
        }

        return x;
    }
    public int gety_axis(){
        int y;
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            y= LabelPicture.label_y2 + (this.note / (2* Picture.rownumber+1)) * (this.getwidth()-5);
        }else{
            y= LabelPicture.label_y1 + (this.note / (2* Picture.rownumber+1)) * (this.getheight()-5);
        }

        return y;
    }
    public int getheight(){
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            return LabelPicture.labelheight;
        }else{
            return LabelPicture.labelwidth;
        }
    }
    public int getwidth(){
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            return LabelPicture.labelwidth;
        }else{
            return LabelPicture.labelheight;
        }
    }

    public int getnewx_axis(){
        int x;
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            x=LabelPicture.newlabel_x1 + (this.note% (2* Picture.rownumber+1)) * (this.getnewwidth()-4);
        }else{
            x= LabelPicture.newlabel_x2 + (this.note% (2* Picture.rownumber+1) - Picture.rownumber) * (this.getnewheight()-4);
        }

        return x;
    }
    public int getnewy_axis(){
        int y;
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            y= LabelPicture.newlabel_y2 + (this.note / (2* Picture.rownumber+1)) * (this.getnewwidth()-5);
        }else{
            y= LabelPicture.newlabel_y1 + (this.note / (2* Picture.rownumber+1)) * (this.getnewheight()-5);
        }

        return y;
    }
    public int getnewheight(){
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            return LabelPicture.newlabelheight;
        }else{
            return LabelPicture.newlabelwidth;
        }
    }
    public int getnewwidth(){
        if((this.note%(2* Picture.rownumber+1))< Picture.rownumber){
            return LabelPicture.newlabelwidth;
        }else{
            return LabelPicture.newlabelheight;
        }
    }
}

class LabelPicture{
    static ImageIcon line;
    static ImageIcon lineiconRed=new ImageIcon("Picture/red.png");
    static ImageIcon lineiconRed2=new ImageIcon("Picture/hong.png");
    static ImageIcon lineiconBlue=new ImageIcon("Picture/blue.png");
    static ImageIcon lineiconBlue2=new ImageIcon("Picture/lan.png");
    static ImageIcon lineiconMovein=new ImageIcon("Picture/6.jpg");
    static ImageIcon lineiconMoveout=null;
    static ImageIcon newlineiconRed=new ImageIcon("NewPicture/red.png");
    static ImageIcon newlineiconRed2=new ImageIcon("NewPicture/red2.png");
    static ImageIcon newlineiconBlue=new ImageIcon("NewPicture/blue.png");
    static ImageIcon newlineiconBlue2=new ImageIcon("NewPicture/blue2.png");
    static ImageIcon newlineiconMovein=new ImageIcon("NewPicture/6.jpg");
    static ImageIcon newlineiconMoveout=null;
    static int labelnumber=60;
    static int labelwidth=89;
    static int labelheight=38;
    static int label_x1=303;
    static int label_x2=287;
    static int label_y1=65;
    static int label_y2=50;
    static int newlabelwidth=89;
    static int newlabelheight=38;
    static int newlabel_x1=340;
    static int newlabel_x2=336;
    static int newlabel_y1=75;
    static int newlabel_y2=60;


}
