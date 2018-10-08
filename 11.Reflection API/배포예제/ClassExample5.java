import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Method를 이용하여 동적 메소드 호출
 * 
 * @author 김기정
 *
 */
public class ClassExample5 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = "substring";
		
		String str = "Hello World";
//		str.length();
		
		Class cls = String.class;
		Method method =  cls.getMethod(methodName, int.class,  int.class);
		// 매개변수 없는 메소드 호출
		Object ret = method.invoke(str, 6, 11);
		System.out.println(ret);
	}
}
