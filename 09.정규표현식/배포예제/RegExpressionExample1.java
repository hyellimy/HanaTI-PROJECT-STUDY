import java.util.regex.Pattern;

/**
 * ����ǥ����(����)�� �̿��� ���ڿ� �˻�
 * @author �����
 */
public class RegExpressionExample1 {

	public static void main(String[] args) {
		// �׽�Ʈ�� ���� ���ڿ� ���
		String[] searchValues = { "bat", "baby", "bonus", "cA", "ca", "co", "c", "c.", "c0", "car", "combat", "count", "date", "disc" };
		
		System.out.println("-------- ���ϰ� ��ġ�ϴ� �����ҹ��� ---------");
		for (String searchValue : searchValues) {
			// c�� �����ϴ� ���� �ҹ��� ���� ����
			boolean match = Pattern.matches("c[a-z]*", searchValue);
			if (match) {
				System.out.println(searchValue + "�� ����ǥ���İ� ��ġ.");
			}
		}
	}
}
