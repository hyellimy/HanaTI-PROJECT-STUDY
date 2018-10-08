import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regex API�� �̿��� ����ǥ���� ���
 * @author �����
 */
public class RegExpressionExample0 {

	public static void main(String[] args) {
		String message = "Hello Java World...";
		String regExp = "java";
//		Pattern pattern = Pattern.compile(regExp);// ��ҹ��� ����
		Pattern pattern = Pattern.compile(regExp, Pattern.CASE_INSENSITIVE);
		
		Matcher matcher = pattern.matcher(message);
		System.out.println(matcher.matches()); // ���ϰ� ��ġ ���� ��ȯ
		System.out.println(matcher.find());    // ���ϰ� ��ġ�ϴ� ���ڿ� ���� ���� ��ȯ
		
		System.out.println("-------------------------");
		
		String str = "as";
		pattern = Pattern.compile(".s");
		matcher = pattern.matcher(str);
		System.out.println(matcher.matches());
		
		// Pattern Ŭ������ static �޼ҵ� Ȱ��
		System.out.println(Pattern.matches(".s", str));
		System.out.println(Pattern.matches("..s", str));
	}

}
