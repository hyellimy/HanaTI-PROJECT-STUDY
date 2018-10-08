package demo.notepad;

public class JNote {

	public static void main(String[] args) {
		NotepadUI frame = new NotepadUI();
		frame.setMenu();
		frame.setContents();
		frame.setSize(800, 500);
		frame.setLookNFeel();
		frame.setVisible(true);
		frame.eventRegist();
	}

}
