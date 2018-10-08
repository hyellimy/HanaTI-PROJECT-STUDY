import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;


/**
 * CardLayout 적용 Frame
 * @author 김기정
 *
 */
public class TalkFrame extends Frame {
	
	LoginPanel loginPanel;
	MainPanel mainPanel;
	
	Panel cardPanel;
	CardLayout cardLayout;
	
	
	public TalkFrame() {
		this("이름없음");
	}
	
	public TalkFrame(String title) {
		super(title);
		loginPanel = new LoginPanel();
		mainPanel = new MainPanel();
		
		cardPanel = new Panel();
		cardLayout = new CardLayout();
		
	}
	
	// 화면 배치
	public void setContents() {

		
	}
	
	public void setCenter() {
		//Runtime.getRuntime().exec(command);
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	private void setColorAll(Color bg) {
		Component[] components = getComponents();
		for (Component component : components) {
			if(component instanceof Panel) {
				Component[] cs = ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);
		}
	}
	
	public static void main(String[] args) {
		TalkFrame frame = new TalkFrame("Kotalk");
		frame.setContents();
		frame.setSize(300, 500);
		frame.setCenter();
		frame.setVisible(true);
	}

}
