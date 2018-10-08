package demo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * DatagramSocket과 DatagramPacket을 이용한 UDP 기반 에코서버
 * 편의상 스레드를 이용한 멀티 에코는 생략
 */
public class UDPServer {
	public static final int PORT = 2018;
	
	boolean stop;
	DatagramSocket dataSocket;
	DatagramPacket receivePacket;

	public void serverStart() throws SocketException {
		// DatagramPacket 수신/송신을 위한 DatagramSocket 생성
		dataSocket = new DatagramSocket(PORT);
		System.out.println("### UDP EchoServer Start!! ###");
		while (!stop) {
			// 클라이언트 데이터 수신을 위한 DatagramPacket 생성(빈우편물)
			byte[] buffer = new byte[512];
			receivePacket = new DatagramPacket(buffer, buffer.length);

			try {
				// 클라이언트 데이터 수신
				dataSocket.receive(receivePacket); // 데이터 수신시까지 블럭
				
				InetAddress clientIP = receivePacket.getAddress();
				// 수신된 데이터 읽기
				byte[] clientData = receivePacket.getData();
				// 클라이언트에서 테스트로 전송한 데이터가 문자열이기 때문에 문자 디코딩처리..
				String clientMessage = new String(clientData, 0, clientData.length);
				System.out.println("클라이언트("+clientIP + ")로부터의 수신 메시지 : " + clientMessage);

				// 클라이언트로 데이터 전송(에코)
				// 클라이언트로 데이터송신을 위한 DatagramPacket 생성
				DatagramPacket dataSendPacket = new DatagramPacket(clientData, clientData.length, clientIP,	receivePacket.getPort());
				dataSocket.send(dataSendPacket);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopServer() {
		if (dataSocket != null) {
			dataSocket.close();
		}
	}

	public static void main(String[] args) {
		UDPServer server = new UDPServer();
		try {
			server.serverStart();
		} catch (SocketException e) {
			e.printStackTrace();
		} finally {
			server.stopServer();
		}

	}

}
