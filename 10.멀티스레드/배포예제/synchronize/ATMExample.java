package synchronize;

/**
 * ������ ����ȭ ����
 * @author �����
 *
 */
public class ATMExample {
	
	public static void main(String[] args) {
		
		// �����忡 ���� �����Ǵ� ATM ����
		ATM atm = new ATM();
		
		Family mom = new Family("����");
		mom.setAtm(atm);
		Family son = new Family("�Ƶ�");
		son.setAtm(atm);
		
		mom.start();
		son.start();
	}

}
