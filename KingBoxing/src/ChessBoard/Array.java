package ChessBoard;

/**
 * Created by DELL on 14-5-18.
 */
public class Array {
    public Boxx[] box;
    public LineLabel[] label;
    public int x=0;
    LineLabel huiqi1;
    LineLabel huiqi2;

    public Array(){
        this.box=new Boxx[BoxxPicture.boxnumber];
        this.label=new LineLabel[LabelPicture.labelnumber];
    }

    public int getBlue(){
        int blue=0;
        for(Boxx lin:box){
            if(lin.number==-2){
                blue++;
            }
        }
        return blue;
    }

    public int getRed(){
        int red=0;
        for(Boxx lin:box){
            if(lin.number==-1){
                red++;
            }
        }
        return red;
    }

    public LineLabel searchlabel(int i){
        for(LineLabel lab:label){
            if(lab.note==i){
                return lab;
            }
        }
        return null;
    }

    public Boxx searchbox(int i){
        for(Boxx boxx:box){
            if(boxx.note==i){
                return boxx;
            }
        }
        return null;
    }

    protected Boxx getbox1(LineLabel line){
        for(Boxx boxx:this.box){
            if(boxx.isContain(line)){
                return boxx;
            }
        }
        return null;
    }

    protected Boxx getbox2(LineLabel line){
        int i=0;
        Boxx boxx=null;

        for(i=(line.box1.note+1);i<this.box.length;i++){
            boxx=this.searchbox(i);
            if(boxx.isContain(line)){
                return boxx;
            }
        }
        return null;
    }

    protected LineLabel getbuttonup(Boxx box){
        int notion=(box.note/ Picture.rownumber)*(2* Picture.rownumber+1)+box.note% Picture.rownumber;
        return this.label[notion];
    }
    protected LineLabel getbuttondown(Boxx box){
        int notion=(box.note/ Picture.rownumber)*(2* Picture.rownumber+1)+box.note% Picture.rownumber+(2* Picture.rownumber+1);
        return this.label[notion];
    }
    protected LineLabel getbuttonleft(Boxx box){
        int notion=(box.note/ Picture.rownumber)*(2* Picture.rownumber+1)+box.note% Picture.rownumber+ Picture.rownumber;
        return this.label[notion];
    }
    protected LineLabel getbuttonright(Boxx box){
        int notion=(box.note/ Picture.rownumber)*(2* Picture.rownumber+1)+box.note% Picture.rownumber+ Picture.rownumber+1;
        return this.label[notion];
    }
}
