package synchronize;

/**
 * ��Ƽ�����忡 ���� �����Ǵ� ��ü
 * @author �����
 */
public class MovieReserveSystem {
	
	private boolean[] tickets;

	public MovieReserveSystem() {
		this(10);
	}

	public MovieReserveSystem(int count) {
		tickets = new boolean[count];
	}
	
	// ����ȭ ó�� ���� ���� ���...
	public /*synchronized*/ boolean reserve(Member member) {
		System.out.println("reserve() Called...");
		synchronized (MovieReserveSystem.class) {
			System.out.println(member.getUserName() + "�� ���� ��û!!!");
			// ������ �����ͺ��̽� ������ üũ �Ѵٴ� �ǹ̷� 1�� ���� ���
			try {
				System.out.println(member.getUserName() + "�� ���� ������ .............");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (int i = 0; i < tickets.length; i++) {
				// ����Ǿ� ���� �ʾ�����
				if (!tickets[i]) {
					// �������� ����
					tickets[i] = true;
					System.out.println("�� " + member.getUserName() + "�� "
							+ (i + 1) + "�� �¼� ����ó�� �Ϸ�~~");
					return tickets[i];
				}
			}
		}
		
		// �¼��� ������
		return false;
	}
	
	// ����ȭ ó���� ���...
	/*
	public boolean reserve(Member member) {
		System.out.println("reserve() Called...");
		// ��ü�� ����ȭ ó��
		//synchronized (this) {
		synchronized (MovieReserveSystem.class) {
			System.out.println(member.getUserName() + "�� ���� ��û!!!");
			// ������ �����ͺ��̽� ������ üũ �Ѵٴ� �ǹ̷� 1�� ���� ���
			try {
				System.out.println(member.getUserName() + "�� ���� ������ .............");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
			for (int i = 0; i < tickets.length; i++) {
				// ����Ǿ� ���� �ʾ�����
				if (!tickets[i]) {
					// �������� ����
					tickets[i] = true;
					System.out.println("�� " + member.getUserName() + "�� "
							+ (i + 1) + "�� �¼� ����ó�� �Ϸ�~~");
					return tickets[i];
				}
			}
		}
		// �¼��� ������
		return false;
	}
	*/
}