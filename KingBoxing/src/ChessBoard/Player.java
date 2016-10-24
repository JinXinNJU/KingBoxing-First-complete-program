package ChessBoard;

/**
 * Created by DELL on 14-5-18.
 */
public class Player {

    int singlewin;
    int singlelose;
    int storywin;
    int storylose;
    String name;

    public Player(String playername){
        this.name=playername;
        this.singlewin=0;
        this.singlelose=0;
        this.storywin=0;
        this.storylose=0;
    }
    
    public Player(){
        this.name="NaKon";
        this.singlewin=0;
        this.singlelose=0;
        this.storywin=0;
        this.storylose=0;
    }

    public void hassinglewin(){
        singlewin++;
    }
    public void hassinglelose(){
        singlelose++;
    }
    public void hasstorywin(){
        storywin++;
    }
    public void hasstorylose(){
        storylose++;
    }

    public void show(){

    }
}
