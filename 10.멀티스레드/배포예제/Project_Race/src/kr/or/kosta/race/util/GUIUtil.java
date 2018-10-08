package kr.or.kosta.race.util;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * GUI 제작에 필요한 공통 기능들...
 * @author 김기정
 */
public class GUIUtil {
	
	
	/** 컨테이너 화면 중앙 배치 */
	public static void setCenterScreen(Container container){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		int x = (dim.width - container.getWidth()) / 2;
		int y = (dim.height - container.getHeight()) / 2;
		container.setLocation(x, y);	
	}
	
	/** 컨테이너 전체 화면 배치 */
	public static void setFullScreen(Container container){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		container.setSize(dim);	
	}
	
	public static final String STYLE_WINDOW = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String STYLE_LINUX = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String STYLE_NIMBUS = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String STYLE_OS = UIManager.getSystemLookAndFeelClassName();
	
	/** 컨테이너에 룩앤필 적용 */
	public static void setLookNFeel(Container component, String lookNFeelName) {
		try {
			UIManager.setLookAndFeel(lookNFeelName);
			SwingUtilities.updateComponentTreeUI(component);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 
}











