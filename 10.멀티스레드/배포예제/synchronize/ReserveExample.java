package synchronize;

public class ReserveExample {
	public static void main(String[] args) {
		// ��Ƽ�����忡 ���� �����Ǵ� ��ü ����
		MovieReserveSystem reserveSystem = new MovieReserveSystem(10);
		
		// �׽�Ʈ�� ���� �� ������ ���� �� ����
		Member m1 = new Member("��ȣ", reserveSystem);
		Member m2 = new Member("����", reserveSystem);
		Member m3 = new Member("�¿�", reserveSystem);
		
		m1.start();
		m2.start();
		m3.start();
	}
}