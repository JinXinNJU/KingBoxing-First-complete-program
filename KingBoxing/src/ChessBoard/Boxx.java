package ChessBoard;

import javax.swing.*;

/**
 * Created by DELL on 14-5-18.
 */
public class Boxx extends JLabel {
    public LineLabel buttonup;
    public LineLabel buttondown;
    public LineLabel buttonleft;
    public LineLabel buttonright;
    public int number;
    public ImageIcon icon;
    int x_axis;
    int y_axis;
    public int note;

    public Boxx(int i){
        this.note=i;
        this.number=0;
        this.icon=null;
        this.x_axis=this.getX_axis();
        this.y_axis=this.getY_axis();

    }

    public int getX_axis(){
        int x;
        x= BoxxPicture.box_x+(this.note% Picture.rownumber)*(LabelPicture.labelwidth-4);
        return x;
    }
    public int getY_axis(){
        int y;
        y= BoxxPicture.box_y+(this.note/ Picture.rownumber)*(LabelPicture.labelwidth-5);
        return y;
    }

    public int getnewX_axis(){
        int x;
        x= BoxxPicture.newbox_x+(this.note% Picture.rownumber)*(LabelPicture.newlabelwidth-4);
        return x;
    }
    public int getnewY_axis(){
        int y;
        y= BoxxPicture.newbox_y+(this.note/ Picture.rownumber)*(LabelPicture.newlabelwidth-5);
        return y;
    }

    public Boolean isContain(LineLabel lab){
        if(this.buttonup==lab||this.buttondown==lab||this.buttonleft==lab||this.buttonright==lab){
            return true;
        }
        return false;
    }

    //判断两个Box是否相邻，用于AI
    public Boolean isConnect(Boxx box2){
        if(((this.note-Picture.rownumber)==box2.note)||((this.note-1)==box2.note)||((this.note+1)==box2.note)||((this.note+Picture.rownumber)==box2.note)){
            return true;
        }else{
            return false;
        }
    }

    public LineLabel get3button(){

        if(!buttonleft.condition){
            return buttonleft;
        }else if(!buttonright.condition){
            return buttonright;
        }else if(!buttonup.condition){
            return buttonup;
        }else if(!buttondown.condition){
            return buttondown;
        }

        return null;
    }

    public LineLabel commonlabel(Boxx box2){

        if(this.buttonleft==box2.buttonright){
            if (!this.buttonleft.condition) {
                return buttonleft;
            }
        }else if(this.buttonleft==box2.buttonup){
            if (!this.buttonleft.condition) {
                return buttonleft;
            }
        }else if(this.buttonleft==box2.buttondown){
            if (!this.buttonleft.condition) {
                return buttonleft;
            }
        }

        if(this.buttonright==box2.buttonleft){
            if (!this.buttonright.condition) {
                return buttonright;
            }
        }else if(this.buttonright==box2.buttondown){
            if (!this.buttonright.condition) {
                return buttonright;
            }
        }else if(this.buttonright==box2.buttonup){
            if (!this.buttonright.condition) {
                return buttonright;
            }
        }

        if (this.buttonup==box2.buttonleft){
            if(!this.buttonup.condition){
                return buttonup;
            }
        }else if(this.buttonup==box2.buttonright){
            if(!this.buttonup.condition){
                return buttonup;
            }
        }else if(this.buttonup==box2.buttondown){
            if(!this.buttonup.condition){
                return buttonup;
            }
        }

        if (this.buttondown==box2.buttonleft){
            if(!this.buttondown.condition){
                return buttondown;
            }
        }else if(this.buttondown==box2.buttonright){
            if(!this.buttondown.condition){
                return buttondown;
            }
        }else if(this.buttondown==box2.buttonup){
            if(!this.buttondown.condition){
                return buttondown;
            }
        }

        return null;
    }
}

class BoxxPicture{
    static ImageIcon boxiconRed=new ImageIcon("Picture/o.png");
    static ImageIcon boxiconBlue=new ImageIcon("Picture/x.png");
    static ImageIcon newboxiconRed=new ImageIcon("NewPicture/o.png");
    static ImageIcon newboxiconBlue=new ImageIcon("NewPicture/x.png");
    static int boxnumber=25;
    static int box_line=65;
    static int box_x=316;
    static int box_y=80;
    static int newbox_x=355;
    static int newbox_y=90;
}
