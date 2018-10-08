import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method를 이용하여 동적 메소드 호출
 * 
 * @author 김기정
 *
 */
public class ClassExample4 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = "length";
		
		String str = "Hello World";
//		str.length();
		
		Class cls = String.class;
		Method method =  cls.getMethod(methodName, null);
		// 매개변수 없는 메소드 호출
		Object ret = method.invoke(str, null);
		System.out.println(ret instanceof Integer);
		System.out.println(ret);
	}

}
