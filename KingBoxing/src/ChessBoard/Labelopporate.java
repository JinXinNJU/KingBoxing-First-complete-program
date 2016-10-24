package ChessBoard;

/**
 * Created by DELL on 14-5-18.
 */
public class Labelopporate {
    //查询Label是否与两个Box相邻
    static Boolean isexsis(int note){
        if(note< Picture.rownumber||note>(2* Picture.columnnumber* Picture.rownumber+ Picture.columnnumber-1)
                ||((note%(2* Picture.rownumber+1))== Picture.rownumber)||((note%(2* Picture.rownumber+1))==(2* Picture.rownumber))){
            return false;
        }else{
            return true;
        }
    }
}
