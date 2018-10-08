package kr.or.kosta.race.view;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Runner extends Thread implements Comparable<Runner>{
	private int x, y;
	private String name;
	private Image image;
	private double lapTime;
	
	public Runner(int x, int y, String name, String imagePath){
		this.name = name;
		image = new ImageIcon(getClass().getResource(imagePath)).getImage();
		this.x = x - image.getWidth(null);
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String getRunnerName() {
		return name;
	}

	public void setRunnerName(String name) {
		this.name = name;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	public double getLapTime() {
		return lapTime;
	}

	public void setLapTime(double lapTime) {
		this.lapTime = lapTime;
	}
	
	@Override
	public String toString() {
		return getRunnerName()+"("+getLapTime()+")";
	}
	
	@Override
	public int compareTo(Runner runner) {
		double value = getLapTime() - runner.getLapTime();
		if(value > 0){
			return 1;
		}else if(value == 0){
			return 0;
		}else{
			return -1;
		}
	}

	@Override
	public void run() {
		long begin = System.currentTimeMillis();
		int distance = 10;
		Random random = new Random();
		while(true){
			try {
				int delay = random.nextInt(200);
				Thread.sleep(delay);
				x += distance;
				// 결승점 통과시
				if((x + image.getWidth(null)) == Stadium.finishLine){
					long end = System.currentTimeMillis();
					lapTime = (end - begin)/1000.0;
				}
				
				if(x >= Stadium.finishLine){
					break;
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
