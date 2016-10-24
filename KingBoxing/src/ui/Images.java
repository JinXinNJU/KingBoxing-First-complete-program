package ui;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public  class Images {
	
	public ArrayList<BufferedImage> animation = new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> ending=new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> about=new ArrayList<BufferedImage>();
	
	public Image start = new ImageIcon("START/1.png").getImage();
	public Image begin = new ImageIcon("BEGIN/1.png").getImage();
	
	public Image part1_1=new ImageIcon("PART1/1.jpg").getImage();
	public Image part2_1=new ImageIcon("PART2/1.jpg").getImage();
	public Image part3_1=new ImageIcon("PART3/1.jpg").getImage();
	public Image part4_1=new ImageIcon("PART4/1.jpg").getImage();
	public Image part5_1=new ImageIcon("PART5/1.jpg").getImage();
	public Image part6_1=new ImageIcon("PART6/1.jpg").getImage();
	public Image part7_1=new ImageIcon("PART7/1.jpg").getImage();
	//public Image part8_1=new ImageIcon("PART8/1.jpg").getImage();
	
	
	public Image choose1=new ImageIcon("CHOOSE/1.jpg").getImage();
	public Image choose2=new ImageIcon("CHOOSE/2.jpg").getImage();
	public Image choose3=new ImageIcon("CHOOSE/3.jpg").getImage();
	public Image choose4=new ImageIcon("CHOOSE/4.jpg").getImage();
	public Image choose5=new ImageIcon("CHOOSE/5.jpg").getImage();
	public Image choose6=new ImageIcon("CHOOSE/6.jpg").getImage();
	public Image choose7=new ImageIcon("CHOOSE/7.jpg").getImage();
	
	public Image specialBg=new ImageIcon("SPECIAL/1.jpg").getImage();
	
	public ImageIcon objects1=new ImageIcon("OBJECTS/1.png");
	public ImageIcon objects2=new ImageIcon("OBJECTS/2.png");
	public ImageIcon objects3=new ImageIcon("OBJECTS/3.png");
	public ImageIcon objects4=new ImageIcon("OBJECTS/4.png");
	public ImageIcon objects5=new ImageIcon("OBJECTS/5.png");
	public ImageIcon objects6=new ImageIcon("OBJECTS/6.png");
	public ImageIcon objects7=new ImageIcon("OBJECTS/7.png");
	
	public ImageIcon helpingExit=new ImageIcon("BUTTON_BEGIN/help1.gif");
	public ImageIcon helping=new ImageIcon("BUTTON_BEGIN/help.gif");
	public ImageIcon buttonStart = new ImageIcon("BUTTON_START/START.png");
	public ImageIcon buttonAbout = new ImageIcon("BUTTON_START/ABOUT.png");
	public ImageIcon buttonQuit = new ImageIcon("BUTTON_START/QUIT.png");
	public ImageIcon buttonDouble = new ImageIcon("BUTTON_BEGIN/DOUBLE.png");
	public ImageIcon buttonHelp = new ImageIcon("BUTTON_BEGIN/HELP.png");
	public ImageIcon buttonInternet = new ImageIcon("BUTTON_BEGIN/INTERNET.png");
	public ImageIcon buttonSingle = new ImageIcon("BUTTON_BEGIN/SINGLE.png");
	public ImageIcon buttonStory = new ImageIcon("BUTTON_BEGIN/STORY.png");
	public ImageIcon buttonClose1 = new ImageIcon("BUTTON_CLOSE/1.png");
	public ImageIcon buttonClose2 = new ImageIcon("BUTTON_CLOSE/2.png");
	public ImageIcon buttonSpecial=new ImageIcon("BUTTON_SPECIAL/1.png");
	public ImageIcon buttonSpecial1=new ImageIcon("BUTTON_SPECIAL/2.png");
	public ImageIcon buttonEnter1=new ImageIcon("DIALOG/1.png");
	public ImageIcon fame1=new ImageIcon("DIALOG/2.png");
	public ImageIcon buttonExit1=new ImageIcon("DIALOG/3.png");
	public ImageIcon buttonFound=new ImageIcon("DIALOG2/found.png");
	public ImageIcon buttonFound2=new ImageIcon("DIALOG2/found2.png");
	public ImageIcon buttonJoin=new ImageIcon("DIALOG2/join.png");
	public ImageIcon buttonJoin2=new ImageIcon("DIALOG2/join2.png");
	
	public ImageIcon[] story1Label=new ImageIcon[]{new ImageIcon("PART1/2.jpg"),new ImageIcon("PART1/3.jpg"),new ImageIcon("PART1/4.jpg"),new ImageIcon("PART1/5.jpg"),new ImageIcon("PART1/6.jpg"),new ImageIcon("PART1/7.jpg"),new ImageIcon("PART1/8.jpg"),new ImageIcon("PART1/9.jpg"),new ImageIcon("PART1/10.jpg"),new ImageIcon("PART1/11.jpg"),new ImageIcon("PART1/12.jpg"),new ImageIcon("PART1/13.jpg"),new ImageIcon("PART1/14.jpg"),new ImageIcon("PART1/15.jpg"),new ImageIcon("PART1/16.jpg"),new ImageIcon("PART1/17.jpg"),new ImageIcon("PART1/18.jpg"),new ImageIcon("PART1/19.jpg"),new ImageIcon("PART1/20.jpg"),new ImageIcon("PART1/21.jpg"),new ImageIcon("PART1/22.jpg"),new ImageIcon("PART1/23.jpg"),new ImageIcon("PART1/24.jpg"),new ImageIcon("PART1/25.jpg"),new ImageIcon("PART1/26.jpg"),new ImageIcon("PART1/27.jpg"),new ImageIcon("PART1/28.jpg"),new ImageIcon("PART1/29.jpg"),new ImageIcon("PART1/30.jpg"),new ImageIcon("PART1/31.jpg"),new ImageIcon("PART1/32.jpg")};
	public ImageIcon[] story2Label=new ImageIcon[]{new ImageIcon("PART2/2.jpg"),new ImageIcon("PART2/3.jpg"),new ImageIcon("PART2/4.jpg"),new ImageIcon("PART2/5.jpg")};
	public ImageIcon[] story3Label=new ImageIcon[]{new ImageIcon("PART3/2.jpg"),new ImageIcon("PART3/3.jpg"),new ImageIcon("PART3/4.jpg"),new ImageIcon("PART3/5.jpg"),new ImageIcon("PART3/6.jpg"),new ImageIcon("PART3/7.jpg"),new ImageIcon("PART3/8.jpg"),new ImageIcon("PART3/9.jpg"),new ImageIcon("PART3/10.jpg"),new ImageIcon("PART3/11.jpg"),new ImageIcon("PART3/12.jpg"),new ImageIcon("PART3/13.jpg"),new ImageIcon("PART3/14.jpg"),new ImageIcon("PART3/15.jpg"),new ImageIcon("PART3/16.jpg"),new ImageIcon("PART3/17.jpg"),new ImageIcon("PART3/18.jpg"),new ImageIcon("PART3/19.jpg"),new ImageIcon("PART3/20.jpg"),new ImageIcon("PART3/21.jpg"),new ImageIcon("PART3/22.jpg"),new ImageIcon("PART3/23.jpg"),new ImageIcon("PART3/24.jpg"),new ImageIcon("PART3/25.jpg"),new ImageIcon("PART3/26.jpg"),new ImageIcon("PART3/27.jpg")};
    public ImageIcon[] story4Label=new ImageIcon[]{new ImageIcon("PART4/2.jpg"),new ImageIcon("PART4/3.jpg"),new ImageIcon("PART4/4.jpg"),new ImageIcon("PART4/5.jpg"),new ImageIcon("PART4/6.jpg"),new ImageIcon("PART4/7.jpg"),new ImageIcon("PART4/8.jpg"),new ImageIcon("PART4/9.jpg"),new ImageIcon("PART4/10.jpg"),new ImageIcon("PART4/11.jpg"),new ImageIcon("PART4/12.jpg"),new ImageIcon("PART4/13.jpg"),new ImageIcon("PART4/14.jpg"),new ImageIcon("PART4/15.jpg")};
    public ImageIcon[] story5Label=new ImageIcon[]{new ImageIcon("PART5/2.jpg"),new ImageIcon("PART5/3.jpg"),new ImageIcon("PART5/4.jpg"),new ImageIcon("PART5/5.jpg"),new ImageIcon("PART5/6.jpg"),new ImageIcon("PART5/7.jpg"),new ImageIcon("PART5/8.jpg"),new ImageIcon("PART5/9.jpg"),new ImageIcon("PART5/10.jpg"),new ImageIcon("PART5/11.jpg"),new ImageIcon("PART5/12.jpg"),new ImageIcon("PART5/13.jpg"),new ImageIcon("PART5/14.jpg"),new ImageIcon("PART5/15.jpg"),new ImageIcon("PART5/16.jpg"),new ImageIcon("PART5/17.jpg"),new ImageIcon("PART5/18.jpg"),new ImageIcon("PART5/19.jpg"),new ImageIcon("PART5/20.jpg")};
    public ImageIcon[] story6Label=new ImageIcon[]{new ImageIcon("PART6/2.jpg"),new ImageIcon("PART6/3.jpg"),new ImageIcon("PART6/4.jpg"),new ImageIcon("PART6/5.jpg"),new ImageIcon("PART6/6.jpg"),new ImageIcon("PART6/7.jpg"),new ImageIcon("PART6/8.jpg"),new ImageIcon("PART6/9.jpg")};
    public ImageIcon[] story7Label=new ImageIcon[]{new ImageIcon("PART7/2.jpg"),new ImageIcon("PART7/3.jpg"),new ImageIcon("PART7/4.jpg"),new ImageIcon("PART7/5.jpg"),new ImageIcon("PART7/6.jpg"),new ImageIcon("PART7/7.jpg"),new ImageIcon("PART7/8.jpg"),new ImageIcon("PART7/9.jpg"),new ImageIcon("PART7/10.jpg"),new ImageIcon("PART7/11.jpg"),new ImageIcon("PART7/12.jpg"),new ImageIcon("PART7/13.jpg"),new ImageIcon("PART7/14.jpg"),new ImageIcon("PART7/15.jpg"),new ImageIcon("PART7/16.jpg"),new ImageIcon("PART7/17.jpg"),new ImageIcon("PART7/18.jpg"),new ImageIcon("PART7/19.jpg"),new ImageIcon("PART7/20.jpg"),new ImageIcon("PART7/21.jpg"),new ImageIcon("PART7/22.jpg"),new ImageIcon("PART7/23.jpg"),new ImageIcon("PART7/24.jpg"),new ImageIcon("PART7/25.jpg"),new ImageIcon("PART7/26.jpg"),new ImageIcon("PART7/27.jpg"),new ImageIcon("PART7/28.jpg"),new ImageIcon("PART7/29.jpg"),new ImageIcon("PART7/30.jpg"),new ImageIcon("PART7/31.jpg")};
    //public ImageIcon[] story8Label=new ImageIcon[]{new ImageIcon("PART8/2.jpg"),new ImageIcon("PART8/3.jpg"),new ImageIcon("PART8/4.jpg"),new ImageIcon("PART8/5.jpg"),new ImageIcon("PART8/6.jpg"),new ImageIcon("PART8/7.jpg"),new ImageIcon("PART8/8.jpg"),new ImageIcon("PART8/9.jpg"),new ImageIcon("PART8/10.jpg"),new ImageIcon("PART8/11.jpg"),new ImageIcon("PART8/12.jpg"),new ImageIcon("PART8/13.jpg")};
    
	public Images() {
		for (int i = 1; i <= 5; i++) {
			try {
				animation
						.add(ImageIO.read(new File("ANIMATION/" + i + ".jpg")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int i=1;i<=14;i++){
			try{
				ending.add(ImageIO.read(new File("PART8/"+i+".jpg")));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		for(int i=1;i<=9;i++){
			try{
				about.add(ImageIO.read(new File("ABOUTUS/"+i+".jpg")));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	

}
