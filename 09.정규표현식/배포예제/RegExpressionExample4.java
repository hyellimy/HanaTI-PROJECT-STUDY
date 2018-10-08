/**
 * ����ǥ������ Ȱ���� ��ȿ�� üũ
 * @author �����
 */
public class RegExpressionExample4 {

	public static void main(String[] args) {
		String[] emails = { "test@abc.com", "aaaa", "abcd@", "abc@mydomain", "bangry@xxx.co.kr" };
		
		// �̸��� ��ȿ�� ������ ���� ����(���Խ�)
		// bangry313@gmail.com
		//String pattern = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$";
		//String pattern = "^[a-zA-Z0-9]{6,}@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+$";
		String pattern = "^[\\w]+@[\\w]+(\\.[\\w]+)+$";
		
		for (String email : emails) {
			System.out.println(email + " : " + email.matches(pattern));
		}
	}
}
