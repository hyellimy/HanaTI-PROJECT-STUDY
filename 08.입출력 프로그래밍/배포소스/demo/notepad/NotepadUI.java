package demo.notepad;

/**
 * 문자스트림을 이용한 자바 메모장
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class NotepadUI extends JFrame {
	
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem newMI, openMI, saveMI, exitMI;
	
	JTextArea ta;
	JPanel glassPane;
	JButton openB, saveB;
	
	public NotepadUI() {
		this("제목없음 - 자바 메모장");
	}

	public NotepadUI(String title) {
		super(title);
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		newMI = new JMenuItem("New", createIcon("new.png"));
		newMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		openMI = new JMenuItem("Open File", createIcon("open.png"));
		openMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
		saveMI = new JMenuItem("Save File", createIcon("save.png"));
		saveMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
		exitMI = new JMenuItem("Exit", createIcon("exit.png"));
		exitMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
		
		ta = new JTextArea();
		openB = new JButton("파일 열기", createIcon("open.png"));
		saveB = new JButton("파일 저장", createIcon("save.png"));
	}
	
	public void setMenu(){
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newMI);
		fileMenu.add(openMI);
		fileMenu.addSeparator();
		fileMenu.add(saveMI);
		fileMenu.addSeparator();
		fileMenu.add(exitMI);
	}

	public void setContents() {
		JPanel glassPane = (JPanel) getGlassPane();
		glassPane.setVisible(true);
		glassPane.add(openB);
		glassPane.add(saveB);
		add(new JScrollPane(ta), BorderLayout.CENTER);
	}
	
	private Icon createIcon(String fileName){
		return new ImageIcon(getClass().getResource("images/"+fileName));
	}
	
	public void setLookNFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 
	
	/** 파일 열기 */
	public void fileOpen(){
		BufferedReader in = null;
		JFileChooser fileChooser = new JFileChooser(".");
		int confirm = fileChooser.showOpenDialog(this);
		// 확인 버튼 선택시
		if(confirm == JFileChooser.APPROVE_OPTION){
			File selectedFile = fileChooser.getSelectedFile();
			ta.setText("");
			try {
				String txt = FileDao.openFile(selectedFile.getAbsolutePath());
				ta.append(txt);
				setTitle(selectedFile.getName());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "에러", JOptionPane.ERROR_MESSAGE);				
			} 
		}
	}
	
	
	/** 파일 저장 */
	public void fileSave(){
		JFileChooser fileChooser = new JFileChooser(".");
		int confirm = fileChooser.showSaveDialog(this);
		if(confirm == JFileChooser.APPROVE_OPTION){
			File saveFile = fileChooser.getSelectedFile();
			try {
				String fileText = ta.getText();
				FileDao.saveFile(saveFile.getAbsolutePath(), fileText);
				setTitle(saveFile.getName());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "경고", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void exit() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		openB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileOpen();
			}
		});
		
		saveB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileSave();
			}
		});
		
		
		newMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
			}
		});
		
		openMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileOpen();
			}
		});
		
		saveMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fileSave();
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
	}

	
}
