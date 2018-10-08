import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Vector;

/**
 * Class를 이용하여 동적 객체(인스턴스) 생성
 * 
 * @author 김기정
 *
 */
public class ClassExample3 {

	public static void main(String[] args) {
//		String className = "java.lang.String";
		
		Object object = null;		
		try {
//			Class cls = Class.forName(className);
			Class cls = String.class;
			
			// 매개변수 있는 생성자 호출
			Constructor constructor = cls.getConstructor(String.class);
			object = constructor.newInstance("동적객체생성");
			System.out.println(object instanceof String);
			System.out.println(((String)object).length());
			
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
