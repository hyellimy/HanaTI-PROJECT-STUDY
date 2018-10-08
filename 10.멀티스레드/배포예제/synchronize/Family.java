package synchronize;

public class Family extends Thread{
	private ATM atm;
	
	public Family(String name){
		super(name);
	}
	
	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}
	
	/** ����ȭ ó�� ���� ���� ��� */
	/*
	public void run() {
		// �����忡�� ���������� �ݾ� ���
		try {
			// �׽�Ʈ ���
			atm.withdrawMoney("1111-2222", 1111, 10000, getName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	/** synchronized{} ���� �̿��� ����ȭ ���� �ذ� */
	/*
	public void run() {
		// �����忡�� ���������� �ݾ� ���
		try {
			synchronized (atm.account) {
				atm.withdrawMoney("1111-2222", 1111, 10000, getName());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	
	/** ����ȭ ó�� �� �߻��� �� �ִ� ������ ��� �� ����� ������ �߻��� �� �ִ� */
	/*
	public void run() {
		// �����忡�� ���������� �ݾ� ���
		try {
			synchronized (atm.account) {
				for(int i=0; i<10; i++){
					atm.withdrawMoney("1111-2222", 1111, 10000, getName());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	/** wait(), notify()/notifyAll() �޼ҵ带 �̿��� ��� �� ����� ���� �ذ�*/
	public void run() {
		
		// �����忡�� ���������� �ݾ� ���
		try {
			synchronized (atm.account) {
				for(int i=0; i<10; i++){
					atm.withdrawMoney("1111-2222", 1111, 10000, getName());
					atm.account.notify();
					//atm.account.notifyAll();
					atm.account.wait();
					//atm.account.wait(3000);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
