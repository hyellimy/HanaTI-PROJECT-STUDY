package kr.or.kosta.race.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class RaceUI extends JFrame {
	Stadium raceCanvas;
	
	JPanel menuPanel;
	Dimension buttonDimension;
	JButton readyButton, startButton, recordButton;
	
	Runner[] runners;
	
	public RaceUI(){
		this("::: 짱구 달리기 대회 :::");
	}
	public RaceUI(String title){
		super(title);
		
		raceCanvas = new Stadium("stadium.png");
		menuPanel = new JPanel();
		menuPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		buttonDimension = new Dimension(100, 40);
		readyButton = new JButton("준비");
		readyButton.setPreferredSize(buttonDimension);
		startButton = new JButton("땅!!!");
		startButton.setPreferredSize(buttonDimension);
		recordButton = new JButton("결과보기");
		recordButton.setEnabled(false);
		recordButton.setPreferredSize(buttonDimension);
	}
	
	public void setContents(){
		menuPanel.add(readyButton);
		menuPanel.add(startButton);
		menuPanel.add(recordButton);
		add(raceCanvas, BorderLayout.CENTER);
		add(menuPanel, BorderLayout.SOUTH);
	}
	
	public void exit(){
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void readyRace(){
		runners = new Runner[4];
		runners[0] = new Runner(Stadium.startLine, 320, "승은", "/images/jjangu0.gif");
		runners[1] = new Runner(Stadium.startLine, 350, "용현", "/images/jjangu1.gif");
		runners[2] = new Runner(Stadium.startLine, 410, "재혁", "/images/jjangu2.gif");
		runners[3] = new Runner(Stadium.startLine, 470, "상일", "/images/jjangu3.gif");
		raceCanvas.setRunners(runners);
		raceCanvas.repaint();
	}
	
	public void startRace(){
		startRunners();
		reflesh();
	}
	
	private void startRunners(){
		for(Runner runner : runners){
			runner.start();
		}
	}
	
	private void reflesh(){
		new Thread(){
			@Override
			public void run() {
				while(true){
					if(isFinished()){
						break;
					}
					raceCanvas.repaint();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "경기가 종료되었습니다.");
				reset();
			}
		}.start();
	}
	
	private boolean isFinished(){
		int finishCount = 0;
		for(Runner runner : runners){
			if(runner.getLapTime() != 0.0){
				finishCount++;
			}
		}
		return finishCount == runners.length;
	}
	
	private void reset(){
		readyButton.setEnabled(false);
		startButton.setEnabled(false);
		recordButton.setEnabled(true);
	}
	
	
	public void recordRace(){
		Arrays.sort(runners);
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<runners.length; i++){
			sb.append((i+1) + "위 : "+ runners[i].toString()+"\n");			
		}
		JOptionPane.showMessageDialog(null, sb.toString(), "경기결과", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void registEvent(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
		
		readyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				readyRace();
			}
		});
		
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startRace();
			}
		});
		
		recordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				recordRace();
			}
		});
	}
}
