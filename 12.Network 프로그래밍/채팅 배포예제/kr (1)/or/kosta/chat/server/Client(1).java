package kr.or.kosta.chat.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import kr.or.kosta.chat.common.Protocol;

/**
 * 클라언트의 데이터 수신 및 처리
 * @author 김기정
 *
 */
public class Client extends Thread {
	
	private boolean running;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	/** 클라이언트 식별자 */
	private String nickName = "손님";
	
	ChatServer chatServer;
	
	public Client(Socket socket, ChatServer chatServer) throws IOException {
		this.socket = socket;
		this.chatServer = chatServer;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
	}
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Socket getSocket() {
		return socket;
	}

	public void recieveMessage() {
		while(running) {
			String clientMessage = null;
			try {
				clientMessage = in.readLine();
				System.out.println("[Debug] : 클라이언트 수신 데이터: " + clientMessage);
				process(clientMessage);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {}
		}
	}
	
	/**
	 * 클라이언트의 메시지를 파싱하여 서비스 제공
	 * @param message
	 */
	public void process(String message) {
		String[] tokens = message.split(Protocol.DELEMETER);
		int protocol = Integer.parseInt(tokens[0]);
		nickName = tokens[1];
		
		switch (protocol) {
		case Protocol.CONNECT:
			// 대화명 중복 여부 체크
			if(chatServer.isExistNickName(nickName)) {
				sendMessage(Protocol.CONNECT_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER +  "FAIL");
				
			}else {
				chatServer.addClient(this);
				System.out.println("[Debug] : 접속 클라이언트 수 : " + chatServer.getClientCount());
				sendMessage(Protocol.CONNECT_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER +  "SUCCESS");
			}
			break;

		default:
			break;
		}
	}
	
	public void sendMessage(String message) {
		out.println(message);
	}
	
	
	@Override
	public void run() {
		recieveMessage();
	}

}
