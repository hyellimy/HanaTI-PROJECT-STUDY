import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����ǥ������ �̿��� ���ڿ� ġȯ
 * @author �����
 */
public class RegExpressionExample2 {
	
	public static void main(String[] args) {
		String message = "A broken hand works, but not a broken heart.";
		
		// "broken"�� "drunken"���� ġȯ
		String regex = "broken";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(message);
		
		String replacedMessage = matcher.replaceAll("drunken");
		
		System.out.println("���� ���ڿ�: " + message);
		System.out.println("ġȯ�� ���ڿ�: " + replacedMessage);
		
		// String�� ����ǥ���� �����ϴ� replaceAll() �޼ҵ� ����Ͽ� ���� ġȯ ����
		//System.out.println(replacedMessage.replaceAll("drunken", "java"));
	}
}
