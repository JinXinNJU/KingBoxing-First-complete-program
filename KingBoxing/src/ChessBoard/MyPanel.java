package ChessBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DELL on 14-5-18.
 */
public class MyPanel extends JPanel {

    ImageIcon icon;

    public void paintComponent(Graphics g){

        ImageIcon icon= this.icon;
        g.drawImage(icon.getImage(), 0, 0, Picture.framewidth, Picture.frameheight, this);

     //   icon=Picture.score_timeicon;
     //   g.drawImage(icon.getImage(),Picture.score_timex_axis,Picture.score_timey_axis,Picture.score_timewidth,Picture.score_timeheight,this);

        //  System.exit(0);
    }

}

