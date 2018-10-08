package demo.objectstream;

import java.net.*;

/**
 * 객체(Object) 단위의 네트워크 입출력
 * @author 김기정
 */
public class ObjectStreamServer{
	public static final int PORT = 2018;
   
   public static void main(String[] args){
    boolean stop = false;  
   	ServerSocket serverSocket = null;
   	
   	Socket socket = null;
   	EchoThread echoThread = null;
 
   	System.out.println("Object Echo Server Start!!!");
   	
   	try{
   		serverSocket = new ServerSocket(PORT);
   		
		while(!stop){
   			socket = serverSocket.accept();
   			System.out.println("["+socket.getInetAddress() + "] Connected...");
   			echoThread = new EchoThread(socket);
   			echoThread.start();
   		}
   	}
   	catch (Exception ex){
   		ex.printStackTrace();
   	}
   }
}




