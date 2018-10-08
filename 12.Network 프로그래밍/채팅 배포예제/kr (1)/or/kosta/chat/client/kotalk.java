package kr.or.kosta.chat.client;

public class kotalk {

	public static void main(String[] args) {
		
		ChatFrame frame = new ChatFrame("::: kotalk :::");
		frame.setContents();
		frame.setSize(400, 500);
		frame.setCenter();
		frame.eventRegist();
		frame.setVisible(true);
		
		ChatClient chatClient = new ChatClient(frame);
		
		frame.setChatClient(chatClient);

	}

}
