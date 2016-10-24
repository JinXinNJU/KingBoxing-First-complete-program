package Ai;

import java.util.ArrayList;
import ChessBoard.*;

/**
 * Created by DELL on 14-5-18.
 */
public class Ai {
    Array array;

    public Ai(Array array1){
        array=array1;
    }

    public LineLabel complete(int p){

        check();

        if (array.x==0) {
            if(bu3()!=null){
                LineLabel labbb=bu3();
                check(labbb);
                return labbb;
            }
            System.out.println("x="+array.x);
            LineLabel labbb=tianchong();
            if(labbb!=null){
                change(labbb);
                return labbb;
            }
            //        return rangbu();
        }
        array.x=1;

        return rangbu();

    }

    public void check(){
        if(change()&&(array.x==0)){
            array.x++;
        }
    }

    public void check(LineLabel lab1){
        if(change(lab1)&&(array.x==0)){
            array.x++;
        }
    }

    public Boolean change(LineLabel lab1){

        Boxx[] boxes=array.box;
        boxes[lab1.box1.note].number++;
        if(lab1.isexist){
            boxes[lab1.box2.note].number++;
        }

        ArrayList<LineLabel> list=new ArrayList<LineLabel>();

        for(LineLabel lab:array.label){
            list.add(lab);
        }

        for(Boxx box1:boxes){
            if(box1.number>=2){
                list.remove(box1.buttonleft);
                list.remove(box1.buttonright);
                list.remove(box1.buttonup);
                list.remove(box1.buttondown);
            }
        }

        boxes[lab1.box1.note].number--;
        if(lab1.isexist){
            boxes[lab1.box2.note].number--;
        }

        return list.isEmpty();
    }

    public Boolean change(){
        ArrayList<LineLabel> list=new ArrayList<LineLabel>();
        for(LineLabel lab:array.label){
            list.add(lab);
        }

        for(Boxx box1:array.box){
            if(box1.number>=2){
                list.remove(box1.buttonleft);
                list.remove(box1.buttonright);
                list.remove(box1.buttonup);
                list.remove(box1.buttondown);
            }
        }

        return list.isEmpty();
    }

    public LineLabel bu3(){
        for(Boxx box11:array.box){
            if(box11.number==3){
                System.out.println("bu3:"+box11.note);
                return box11.get3button();
            }
        }
        System.out.println("bu3:null");
        return null;
    }

    public LineLabel tianchong(){

        ArrayList<LineLabel> list=new ArrayList<LineLabel>();
        for(LineLabel lab:array.label){
            if (!lab.condition) {
                list.add(lab);
            }
        }

        for(Boxx box1:array.box){
            if(box1.number==2){
                list.remove(box1.buttonleft);
                list.remove(box1.buttonright);
                list.remove(box1.buttonup);
                list.remove(box1.buttondown);
            }
        }

        int y=(int) (Math.random()*list.size());
        System.out.println("tianchong:"+list.isEmpty());
        //  System.out.println("tianchong:"+list.get(y).note);         //   无法转换成让步模式！！！
        if(list.isEmpty()){
            return null;
        }
        return list.get(y);
    }

    public LineLabel rangbu(){

        ArrayList<ArrayList<Boxx>> boxlist=this.cut();
        System.out.println("leave:"+leave());

        if(has3()!=null){

            ArrayList<ArrayList<Boxx>> boxcut3=has3s(boxlist);
            if(boxcut3!=null){                           //内部进行2个以上line的让步
                ArrayList<Boxx> boxmax=getmax(boxlist);    //ring让步

                if(boxmax.size()>=2&&!isring(boxmax)){
                    for(ArrayList<Boxx> boxii:boxcut3){
                        if(boxii!=boxmax){
                            return ringlinebu3(boxii);
                        }
                    }
                }else if(boxmax.size()>=4&&isring(boxmax)){
                    for(ArrayList<Boxx> boxii:boxcut3){
                        if(boxii!=boxmax){
                            return ringlinebu3(boxii);
                        }
                    }
                }else{
                    for(ArrayList<Boxx> boxii:boxcut3){
                        return ringlinebu3(boxii);
                    }
                }
            }

            int i=0;
            i=array.getBlue();
            Boxx box3=has3();                              //ring让步
            ArrayList<Boxx> boxes3=getboxes(boxlist,box3);
            if(isring(boxes3)){
                if (boxes3.size()!=leave()&&(i+boxes3.size())<13) {
                    return ringrangbu(boxes3);
                }else{
                    return ringlinebu3(boxes3);
                }
            }
            if (boxes3.size()!=leave()&&(i+boxes3.size())<13) {
                return linerangbu(boxes3);
            }else{
                return ringlinebu3(boxes3);
            }
        }else {

            ArrayList<Boxx> minboxes=getmin(boxlist);

            if(minboxes.size()==2){
                return minboxes.get(0).commonlabel(minboxes.get(1));
            }else{
                if(!minboxes.get(0).buttonleft.condition){
                    return minboxes.get(0).buttonleft;
                }else if(!minboxes.get(0).buttonright.condition){
                    return minboxes.get(0).buttonright;
                }else{
                    return minboxes.get(0).buttonup;
                }
            }
        }

    }

    public LineLabel ringlinebu3(ArrayList<Boxx> boxes0){
        for(Boxx lin:boxes0){
            if(lin.number==3){
                return lin.get3button();
            }
        }
        return null;
    }

    public LineLabel linerangbu(ArrayList<Boxx> boxes3){
        Boxx box3=null;
        for(Boxx lin:boxes3){
            if(lin.number==3){
                box3=lin;
            }
        }

        if(boxes3.size()==2){                                   //计算之前占领的格子o(╯□╰)o
            Boxx boxii;                                          //需要知道自己是什么颜色的
            if(boxes3.get(0)==box3){
                boxii=boxes3.get(1);
            }else{
                boxii=boxes3.get(0);
            }
            LineLabel lablin=box3.commonlabel(boxii);
            if((!boxii.buttonleft.condition)&&boxii.buttonleft!=lablin){
                return boxii.buttonleft;
            }else if((!boxii.buttonright.condition)&&boxii.buttonright!=lablin){
                return boxii.buttonright;
            }else if((!boxii.buttonup.condition)&&boxii.buttonup!=lablin){
                return boxii.buttonup;
            }else if((!boxii.buttondown.condition)&&boxii.buttondown!=lablin){
                return boxii.buttondown;
            }else{
                return lablin;
            }

        }
    /*    else if(boxes3.size()==4){
            System.out.println("isTianzige:"+istianzi(boxes3));
            if(tianzige(boxes3)!=null){
                System.out.println("监测执行田字格");
                return tianzige(boxes3);
            }
        }
   */     return box3.get3button();


    }

    /*  public LineLabel tianzige(ArrayList<Boxx> boxes4){

          ArrayList<Boxx> boxes3=paixu(boxes4);
          LineLabel lab=has3().get3button();

          if(istianzi(boxes3)&&(boxes3.get(0).number==3)){
               System.out.println("Tianzige:"+has3().note);
               return array.searchlabel(lab.note+6);
          }else if(istianzi(boxes3)&&(boxes3.get(2).number==3)){
              System.out.println("Tianzige:"+has3().note);
              return array.searchlabel(lab.note-6);
          }else if(istianzi(boxes3)&&(boxes3.get(2).number==2)){
              System.out.println("Tianzige:"+has3().note);
              return array.searchlabel(lab.note+5);
          }
          return null;
      }
     */
  /*  public Boolean istianzi(ArrayList<Boxx> boxes3){

        ArrayList<Boxx> boxes=paixu(boxes3);
        System.out.println("tianzigenote:"+boxes.get(0).note+boxes.get(1).note+boxes.get(2).note+boxes.get(3).note);
        if(((boxes.get(0).note+1)==boxes.get(1).note)&&((boxes.get(0).note+5)==boxes.get(2).note)&&((boxes.get(0).note+6)==boxes.get(3).note)){
            return true;
        }
        return false;
    }
   */
    public ArrayList<Boxx> paixu(ArrayList<Boxx> boxes){
        int i=0,j=0;
        ArrayList<Boxx> newboxes=new ArrayList<Boxx>();
        Boxx[] boxpaixu=new Boxx[boxes.size()];

        for(i=0;i<boxes.size();i++){
            boxpaixu[i]=boxes.get(i);
        }

        for(j=0;j<boxpaixu.length;j++){
            for(i=0;i<boxpaixu.length-2;i++){
                if(boxpaixu[i].note>boxpaixu[i+1].note){
                    Boxx lin=boxpaixu[i+1];
                    boxpaixu[i+1]=boxpaixu[i];
                    boxpaixu[i]=lin;
                }
            }
        }

        for(i=0;i<boxes.size();i++){
            newboxes.add(boxpaixu[i]);
        }
        return newboxes;
    }


    public ArrayList<Boxx> getmin(ArrayList<ArrayList<Boxx>> list){

        int y=list.get(0).size();
        ArrayList<Boxx> minboxes=list.get(0);
        for(ArrayList<Boxx> boxes:list){
            if(y>boxes.size()){
                y=boxes.size();
                minboxes=boxes;
            }
        }
        System.out.println("min:"+minboxes.size());
        return minboxes;
    }

    public ArrayList<Boxx> getmax(ArrayList<ArrayList<Boxx>> list){

        int y=list.get(0).size();
        ArrayList<Boxx> maxboxes=list.get(0);
        for(ArrayList<Boxx> boxes:list){
            if(y<boxes.size()){
                y=boxes.size();
                maxboxes=boxes;
            }
        }
        System.out.println("max:"+maxboxes.size());
        return maxboxes;
    }

    public Boolean isring(ArrayList<Boxx> boxes0){
        int z=0;
        for(Boxx box1:boxes0){
            if(box1.number==3){
                z++;
            }
        }

        if(z==1){
            return false;
        }else{
            return true;
        }
    }

    public LineLabel ringrangbu(ArrayList<Boxx> boxes0){

        if(boxes0.size()==4){
            Boxx box1=null;
            Boxx box2=null;
            for(Boxx lin:boxes0){
                if (lin.number==2){
                    box1=lin;
                    break;
                }
            }
            for(Boxx lin:boxes0){
                if (lin.number==2&&lin!=box1){
                    box2=lin;
                    break;
                }
            }
            return box2.commonlabel(box1);
        }else{
            for(Boxx lin:boxes0){
                if(lin.number==3){
                    return lin.get3button();
                }
            }
        }
        return null;

    }

    public ArrayList<Boxx> getboxes(ArrayList<ArrayList<Boxx>> list, Boxx box1){

        for(ArrayList<Boxx> boxes:list){
            if(boxes.contains(box1)){
                return boxes;
            }
        }
        return null;

    }

    public Boxx has3(){
        for(Boxx box1:array.box){
            if(box1.number==3){
                return box1;
            }
        }
        return null;
    }

    public ArrayList<ArrayList<Boxx>> has3s(ArrayList<ArrayList<Boxx>> boxlist){
        ArrayList<ArrayList<Boxx>> lin=new ArrayList<ArrayList<Boxx>>();
        for(Boxx box1:array.box){
            if(box1.number==3){
                if (!lin.contains(getboxes(boxlist,box1))) {
                    lin.add(getboxes(boxlist, box1));
                }
            }
        }
        if(lin.isEmpty()||lin.size()==1){
            return null;
        }else{
            return lin;
        }
    }

    public ArrayList<ArrayList<Boxx>> cut(){

        ArrayList<ArrayList<Boxx>> list=new ArrayList<ArrayList<Boxx>>();

        for(Boxx boxxx:array.box){
            if ( boxxx.number>=2) {
                ArrayList<Boxx> ary=new ArrayList<Boxx>();
                ary.add(boxxx);
                list.add(ary);
            }
        }

        for(Boxx box1:array.box){
            for(Boxx box2:array.box){
                if((box1.commonlabel(box2)!=null)&&(box1.number!=1)&&(box2.number!=1)){
                    tianjia(list,box1,box2);
                }
            }
        }
        System.out.println("cut:"+list.size());
        return list;
    }

    public ArrayList<ArrayList<Boxx>> tianjia(ArrayList<ArrayList<Boxx>> list, Boxx box1, Boxx box2){

        ArrayList<Boxx> boxes1=hasBox(list, box1);
        ArrayList<Boxx> boxes2=hasBox(list, box2);

        if((boxes1!=null)&&(boxes2==null)){
            boxes1.add(box2);
        }else if((boxes2!=null)&&(boxes1==null)){
            boxes2.add(box1);
        }else if((boxes1!=null)&&(boxes2!=null)){
            if(boxes1!=boxes2){
                boxes1.addAll(boxes2);
                list.remove(boxes2);
            }
        }else if((boxes1==null)&&(boxes2==null)){
            ArrayList<Boxx> lin=new ArrayList<Boxx>();
            lin.add(box1);
            lin.add(box2);
            list.add(lin);
        }

        return list;
    }

    public ArrayList<Boxx> hasBox(ArrayList<ArrayList<Boxx>> list,Boxx box1){

        for(ArrayList<Boxx> boxes:list){
            if(boxes.contains(box1)){
                return boxes;
            }
        }
        return null;
    }

    public int leave(){
        int a=0;
        for(Boxx lin:array.box){
            if(lin.number>0&&lin.number<=3){
                a++;
            }
        }
        return a;
    }
}
