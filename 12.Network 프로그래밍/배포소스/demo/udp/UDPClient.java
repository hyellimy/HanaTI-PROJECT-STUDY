package demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP기반 클라이언트
 */
public class UDPClient {
	String serverIP;
	DatagramSocket dataSocket;	
	DatagramPacket sendPacket;
	
	public UDPClient(){
		this("localhost");
	}
	public UDPClient(String serverIP){
		this.serverIP = serverIP;
	}
	
	
	public void clientStart() throws Exception{
		// DatagramPacket 송수신을 위한 DatagramSocket 생성
		dataSocket  = new DatagramSocket(8282);// 수신을 위한 포트

		String inputMessage = "안녕하세요. 김기정입니다..";
		byte[] buffer = inputMessage.getBytes();
		
		// 서버에 전송할 우편물 생성
		sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(serverIP), 2018);
		
		// 서버에 데이터(우편물) 전송
		dataSocket.send(sendPacket);
		
		// 데이터 수신을 위한 DatagramPacket(빈우편물) 생성
		DatagramPacket dataReceivePacket = new DatagramPacket(buffer, buffer.length);
		dataSocket.receive(dataReceivePacket);
		System.out.println("서버로부터 에코된 메시지: " + new String(buffer, 0, buffer.length));			
	}
	
	public void close() {
		if (dataSocket != null) {
			dataSocket.close();
		}
	}
	
	
	public static void main(String[] args) {
		UDPClient client = new UDPClient();
		try {
			client.clientStart();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			client.close();
		}
	}

}
