/**
 * String Ŭ������ ����ǥ���� ���� �޼ҵ�� Ȱ��
 * @author �����
 */
public class RegExpressionExample3 {
	
	public static void main(String[] args) {
		String msg1 = "hello world";
		System.out.println(msg1.matches("hello"));          // false
		System.out.println(msg1.matches("hello ([a-z]*)")); // true
	
		System.out.println("------------------------");
		String msg2 = "hello a9��";
		System.out.println(msg2.matches("hello ([a-z]*)"));
		System.out.println(msg2.matches("hello ([a-z0-9]*)"));
		System.out.println(msg2.matches("hello ([a-z0-9��-�R]*)"));
		System.out.println(msg2.matches("hello\\p{Space}([a-z0-9��-�R]*)"));
		
		System.out.println("------------------------");
		String msg3 = "gooooooogle";
		System.out.println(msg3.matches("google"));
		System.out.println(msg3.matches("go*gle"));
		
		System.out.println("------------------------");
		
		// ����(���Խ�)�� �����ڷ� ����Ͽ� ��ū �и�
		String message = "��ū1--��ū2**��ū3..��ū4";
		String regex = "(\\-\\-|\\*\\*|\\.\\.)";
		String[] tokens = message.split(regex);
		for (String token : tokens) {
			System.out.println(token);
		}
		
		// ���ڿ� ġȯ
		String txt = "gooooooogle goooogle gooogle goooogle";
		System.out.println(txt.replaceAll("go*gle", "����"));
	}
}
