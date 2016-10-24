package ChessBoard;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
   private Integer pass=null;
   private Socket socket=null;
   private ObjectInputStream ois=null;
   private ObjectOutputStream oos=null;
   
   public void startServer(){
	   try{
		   ServerSocket serverSocket=new ServerSocket(1994);
		   System.out.println("我是服务器在1994端口监听");
		   socket=serverSocket.accept();
		   System.out.println("有客户连接到服务器！");
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
   
   public Integer getDataGame(){
	   try{
		   ois=new ObjectInputStream(socket.getInputStream());
		   pass=(Integer) ois.readObject();
		   System.out.println("get");
	   }catch(ClassNotFoundException e){
		   e.printStackTrace();
	   }catch(IOException e){
		   e.printStackTrace();
	   }
	   return pass;
   }
   
   public void setDataGame(Integer pass){
	   try{
		   oos=new ObjectOutputStream(socket.getOutputStream());
		   oos.writeObject(pass);
		   System.out.println("send");
	   }catch(IOException e){
		   e.printStackTrace();
	   }
	   this.pass=pass;
   }
}
