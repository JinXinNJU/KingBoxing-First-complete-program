package ChessBoard;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	private Socket socket=null;
	private ObjectInputStream ois=null;
	private ObjectOutputStream oos=null;
	private Integer pass=null;
	
	public void startConnect(String ip){
		try{
			socket=new Socket(ip,1994);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public Integer getDataGame(){
		try{
			ois=new ObjectInputStream(socket.getInputStream());
			pass=(Integer)ois.readObject();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return pass;
	}
	
	public void setDataGame(Integer pass){
		this.pass=pass;
		try{
			oos=new ObjectOutputStream(socket.getOutputStream());
		    oos.writeObject(pass);
		    System.out.println("send");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
