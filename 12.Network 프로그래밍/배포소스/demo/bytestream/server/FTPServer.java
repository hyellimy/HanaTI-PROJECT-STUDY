package demo.bytestream.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket 바이트 스트림을 이용하여 파일 다운로드 서비스 제공
 * @author 김기정
 */
public class FTPServer {
	
	public static final int PORT = 2018;
	
	private boolean stop;
	private ServerSocket serverSocket;
	
	
	// setter/getter
	public boolean isStop() {
		return stop;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	/** 서버 구동 */
	public void startUp() throws IOException{
		serverSocket = new ServerSocket(PORT);
	}
	
	/** 서버 종료 */
	public void shutDown() throws IOException{
		if(serverSocket != null) serverSocket.close();
	}
	
	/** 클라이언트 연결 수신 */
	public void connectListening() throws IOException{
		while(!stop){
			Socket socket = serverSocket.accept();
			InetAddress ia = socket.getInetAddress();
			System.out.println("FTP Client[" + ia.getHostAddress() + "] Connected...");
			
			FTPThread thread = new FTPThread(socket);
			thread.start();
		}		
	}
	
	public static void main(String[] args) {
		FTPServer server = new FTPServer();
		try {
			server.startUp();
			System.out.println("FTPServer["+PORT+"] Startup.....");
			server.connectListening();
		} catch (IOException e) {
			System.out.println("[Degug] : 아래와 같은 예외가 발생하여 서버를 구동할 수 없습니다.");
			System.out.println(e);
		}

	}
}
