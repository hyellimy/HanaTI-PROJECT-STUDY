package kr.or.kosta.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

/**
 * Chatting Server
 * @author 김기정
 */
public class ChatServer {
	public static final int PORT = 7777;
	private boolean running;
	private ServerSocket serverSocket;
	private Hashtable<String, Client> clients;
	
	public boolean isRunning() {
		return running;
	}

	public Hashtable<String, Client> getClients() {
		return clients;
	}
	
	public void startUp() throws IOException {
		try {
			serverSocket = new ServerSocket(PORT);
		}catch (Exception e) {
			throw new IOException("["+PORT + "] 포트 충돌로 ChatServer를 구동할 수 없습니다.");
		}
		
		running = true;
		clients = new Hashtable<String, Client>();
		System.out.println("BTS["+PORT + "] ChatServer Start....");
		
		while(running) {
			try {
				Socket socket = serverSocket.accept();
				Client client = new Client(socket);
				
				if(addClient(client)) {
					client.start();
					System.out.println("#### ["+socket.getInetAddress()+"]님께서 서버에 연결하셨습니다. ####");
				}else {
					
				}
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void shutDown() {}
	
	public boolean addClient(Client client) {
		if(clients.contains(client.getName())) {
			return false;
		}
		clients.put(client.getNickName(), client);
		return true;
		
	}
	public void removeClient(Client client) {}
	public void sendAllMessage(String message) {}
	
}






