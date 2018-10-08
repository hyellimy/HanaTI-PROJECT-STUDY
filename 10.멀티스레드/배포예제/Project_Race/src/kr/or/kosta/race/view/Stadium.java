package kr.or.kosta.race.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Stadium extends Canvas {
	
	Image backgroundImage;
	Runner[] runners;
	
	public static int startLine = 150;
	public static int finishLine = startLine + 800;
		
	public Stadium(String fileName){
		backgroundImage = new ImageIcon(getClass().getResource("/images/"+fileName)).getImage();
	}
	
	public Stadium(String imagePath, Runner[] runners){
		backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
		this.runners = runners;
	}
	
	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public Runner[] getRunners() {
		return runners;
	}

	public void setRunners(Runner[] runners) {
		this.runners = runners;
	}
	
	// 메모리상의 이미지
	Image memoryImage;
	Graphics bufferGraphics;
	
	@Override
	public void paint(Graphics g) {
		//drawBackground(g);
		//drawRunners(g);
		
		// 버블버퍼링을 이용한 이미지 깜빡임 없애기
		// 메모리상에 이미지를 그리고 그이미지를 현재 캔바스에 덮어그리기..
		memoryImage = createImage(this.getWidth(), this.getHeight());
		bufferGraphics = memoryImage.getGraphics();
		drawBackground(bufferGraphics);
		drawRunners(bufferGraphics);
		g.drawImage(memoryImage, 0, 0, this);
	}
	
	/** 지우는 기능을 없애기 위해 재정의 */
	@Override
	public void update(Graphics g) {
		paint(g);
	}

	
	/** 배경이미지 및  라인 그리기 */
	private void drawBackground(Graphics g){
		if(backgroundImage != null){
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
			g.setColor(Color.white);
			g.fillRect(startLine,  350, 5, 230);
			g.fillRect(finishLine, 350, 5, 230);
		}
	}
	
	/** 경주마 그리기 */
	private void drawRunners(Graphics g){
		if(runners != null){
			for (int i=0; i<runners.length; i++) {
				Runner runner = runners[i];
				g.drawImage(runner.getImage(), runner.getX(), runner.getY(), this);
				g.setColor(Color.yellow);
				g.drawString(runner.getRunnerName(), runner.getX(), runner.getY()+10);
			}
		}
	}
}
