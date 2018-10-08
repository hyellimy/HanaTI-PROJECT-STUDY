package kr.or.kosta.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * 서버와의 통신 대행자
 * @author 김기정
 */
public class ChatClient {
	public static final String SERVER = "127.0.0.1";
	public static final int PORT = 7777;
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private boolean running;
	
	
	public void connectServer() throws Exception {
		try {
			socket = new Socket(SERVER, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			running = true;
		}catch (Exception e) {
			throw new Exception("서버를 찾을 수 없습니다..");
		}
		
	}
	public void stopClient() {
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {}
		}		
	}
	public void sendMessage(String message) {
		if(out != null) out.println(message);
	}
	
	public void receiveMessage() {
		new Thread() {
			@Override
			public void run() {
				while(running) {
					String serverMessage = null;
					try {
						serverMessage = in.readLine();
						System.out.println("[Debug] : 서버 수신 데이터: " + serverMessage);
						process(serverMessage);
						
					} catch (IOException e) {
						System.out.println("네트워크가 단절되었습니다..");
						break;
					}
				}
				
				if(socket != null) {
					try {
						socket.close();
					} catch (IOException e) {}
				}
			}
			
		}.start();
		
		
		
	}
	
	public void process(String message) {
		System.out.println(message);
	}

}





