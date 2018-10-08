package demo.objectstream;

import java.io.*;
import java.net.*;

/**
 * 객체(Object) 단위의 네트워크 입출력
 * @author 김기정
 */
public class ObjectStreamClient{
	
	public static void main(String[] args){
		Socket clientSocket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try{
			clientSocket = new Socket("localhost", 2018);
			         			
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			ois = new ObjectInputStream(clientSocket.getInputStream());
			
			// 전송할 객체를 생성
			User user = new User("김기정", "bangry", 30);
			oos.writeObject(user);
			oos.flush();
			
			User readUser = (User)ois.readObject();
			System.out.println("[디버깅]서버로 부터 수신한 객체 : " + readUser);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(ois != null){try {ois.close();} catch (IOException e) {}}
			if(oos != null){try {oos.close();} catch (IOException e) {}}
			if(clientSocket != null){try {clientSocket.close();} catch (IOException e) {}}
		}
	}
}
