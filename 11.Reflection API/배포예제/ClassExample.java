import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Class를 이용하여 클래스 관련 다양한 정보 얻기
 * 
 * @author 김기정
 *
 */
public class ClassExample {
	
	public void exampleMethod() {
		System.out.println("exampleMethod 실행");
	}

	public static void main(String[] args) {
		try {
			Class cls = Class.forName("ClassExample");
			System.out.println("----- 슈퍼클래스 얻기 -----");
			Class supercls = cls.getSuperclass();
			System.out.println(supercls.toString());
			
			System.out.println("----- 생성자 얻기 -----");
			Constructor[] cons =  cls.getConstructors();
			for (Constructor constructor : cons) {
				System.out.println(constructor.toString());
			}
			
			System.out.println("----- 메소드 얻기 -----");
			Method[] methods = cls.getMethods();
			for (Method method : methods) {
				System.out.println(method.toString());
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
