package kr.or.kosta.chat.client;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import kr.or.kosta.chat.common.Protocol;

public class ChatFrame extends Frame {
	
	private ChatClient chatClient;
	private String nickName;
	
	Label nickNameL;
	TextField nickNameTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userList;
	
	
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;
	
	
	public ChatFrame() {
		this("이름없음");
	}
	
	public ChatFrame(String title) {
		super(title);
		nickNameL = new Label("대화명");
		nickNameTF = new TextField();
		inputTF = new TextField();
		connectB = new Button("연결");
		sendB = new Button("전송");
		messageTA = new TextArea();
		userList = new List();
		userList.add("말미잘");
		userList.add("꼴뚜기");
		userList.add("머저리");
		
		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X));
	}
	
	public ChatClient getChatClient() {
		return chatClient;
	}

	public void setChatClient(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	// 화면 배치
	public void setContents() {
		Panel northP = new Panel();
		northP.setLayout(new BorderLayout());
		northP.add(nickNameL, BorderLayout.WEST);
		northP.add(nickNameTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);
		
		Panel southP = new Panel();
		southP.setLayout(new BorderLayout());
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
		
		setLocation(100, 100);
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
	}
	
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	public void connect() {
		nickName = nickNameTF.getText();
		try {
			chatClient.connectServer();
			
			// 최초 연결 메시지 전송
			chatClient.sendMessage(Protocol.CONNECT + Protocol.DELEMETER + nickName);
//			appendMessage("@@@ ChatServer와 연결되었습니다 @@@@");
			chatClient.receiveMessage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "연결 실패", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void connectEnable(boolean flag) {
		nickNameTF.setEnabled(flag);
		connectB.setEnabled(flag);
	}
	
	public void sendMessage() {
		String message = inputTF.getText();
		if(message == null || message.trim().length() == 0) {
			return;
		}
		inputTF.setText("");
		System.out.println(message);
		
	}
	
	public void appendMessage(String message) {
		messageTA.append(message + "\n");
	}
	
	
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist() {
		nickNameTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				
			}
		});
		
		connectB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
				
			}
		});
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		inputTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		
		sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});
		
		
		userList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String name = userList.getSelectedItem();
					
				}
				
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
	}
}
