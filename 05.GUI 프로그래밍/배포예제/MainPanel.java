import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

public class MainPanel extends Panel {
	
	Label tempL;
	Button logoutB;
	
	public MainPanel() {
		tempL = new Label("This is Test Panel", Label.CENTER);
		logoutB = new Button("LOGOUT");
		setContents();
	}
	
	public void setContents() {
		setLayout(new BorderLayout());
		Panel panel = new Panel();
		panel.add(logoutB);
		
		add(tempL, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("메인화면");
		MainPanel mainPanel = new MainPanel();
		
		frame.add(mainPanel);
		frame.setSize(300, 500);
//		frame.pack();
		frame.setVisible(true);
	}

}
