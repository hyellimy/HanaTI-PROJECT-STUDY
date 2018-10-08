package synchronize;

public class Member extends Thread {
	private String userName;
	
	private MovieReserveSystem reserveSystem;
	
	public Member(String userName, MovieReserveSystem reserveSystem){
		this.userName = userName;
		this.reserveSystem = reserveSystem;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public void run(){
		// ��ȭ����
		reserveSystem.reserve(this);
	}
}
