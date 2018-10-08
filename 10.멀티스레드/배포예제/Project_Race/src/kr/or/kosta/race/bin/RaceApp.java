package kr.or.kosta.race.bin;

import kr.or.kosta.race.util.GUIUtil;
import kr.or.kosta.race.view.RaceUI;

public class RaceApp {
	public static void main(String[] args) {
		RaceUI ui = new RaceUI();
		ui.setContents();
		ui.setSize(1027, 740);
		ui.setResizable(false);
		GUIUtil.setLookNFeel(ui, GUIUtil.STYLE_NIMBUS);
		ui.setVisible(true);
		ui.registEvent(); 
	}
}
