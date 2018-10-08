/**
 * ����ǥ������ Ȱ���� ��ȿ�� üũ ����޼ҵ�
 * @author ����� 
 *
 */
public class Validator {
	/**
	 * �Է��ʵ� �Է¿��� ����
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value){
		if (value == null || value.trim().length() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * ���̵� ��ȿ�� ����
	 * ������������������ 8~10�� ���̵�
	 * ex) bangry313
	 * @param id
	 * @return
	 */
	public static boolean isValidId(String id){
		return false;
	}

	/**
	 * �̸��� ��ȿ�� ����
	 * ex) bangry313@gmail.com
	 * @param email
	 * @return
	 */
	public static boolean isValidEmail(String email) {
		return false;
	}
	
	/**
	 * ��ȭ��ȣ ��ȿ�� ����
	 * 2~3�ڸ�����-3~4�ڸ�����-4�ڸ�����
	 * ex) 02-1234-5678
	 * @param number
	 * @return
	 */
	public static boolean isValidPhoneNumber(String number) {
		return false;
	}
	
	/**
	 * �޴�����ȣ ��ȿ�� ����
	 * 010|011|016|017|018|019-3~4�ڸ�����-4�ڸ�����
	 * ex) 10-9179-8707
	 * @param number
	 * @return
	 */
	public static boolean isValidMobileNumber(String number) {
		return false;
	}
	
	/**
	 * �ֹε�Ϲ�ȣ ��ȿ�� ����
	 * 6�ڸ�����-1~8�� �����ϴ� 7�ڸ�����
	 * ex) 680313-1234567
	 * @param ssn
	 * @return
	 */
	public static boolean isValidSSN(String ssn) {
		return false;
	}
	
	/**
	 * IP�ּ� ��ȿ�� ����
	 * 0~255.0~255.0~255.0~255
	 * ex) 192.168.0.28
	 * @param ip
	 * @return
	 */
	public static boolean isValidIP(String ip) {
		return false;
	}
	
	/**
	 * ���ϸ� ��ȿ�� ����
	 * ex) sample.gif
	 * @param ip
	 * @return
	 */
	public static boolean isValidFile(String fileName) {
		return false;
	}

	
	public static void main(String[] args) {
		System.out.println(Validator.isEmpty("  "));
		System.out.println(Validator.isValidId("bangry313"));
		System.out.println(Validator.isValidEmail("kj3133k@aa.com"));
		System.out.println(Validator.isValidPhoneNumber("02-1234-1234"));
		System.out.println(Validator.isValidMobileNumber("019-1234-1234"));
		System.out.println(Validator.isValidSSN("680313-1234568"));
		System.out.println(Validator.isValidIP("192.168.34.56"));
		System.out.println(Validator.isValidFile("abc.png"));
	}
}
