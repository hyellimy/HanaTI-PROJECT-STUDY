package synchronize;

/**
 * �ϻ��Ȱ�� ������¸� ǥ���ϱ� ���� Ŭ����(�߻�ȭ)
 * ��ü�� ���� ������Ÿ�� ����
 */
public class Account /*extends Object */{
	
	//Ŭ����(static) ����
//	public static String bankName = "KOSTA Bank";
	public static final String BANK_NAME = "KOSTA Bank";
	
	
	// �ν��Ͻ� ����
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	
	// ������(Constructor) Overloading(�ߺ�����)
	public Account(){
//		accountNum = null;
//		accountOwner = null;
//		passwd = 0;
//		restMoney = 0L;
		this(null, null);
	}
	
	public Account(String accountNum, String accountOwner){
//		this.accountNum = accountNum;
//		this.accountOwner = accountOwner;
//		this.passwd = 1111;
//		this.restMoney = 0;
		this(accountNum, accountOwner, 1111);
	}
	
	public Account(String accountNum, String accountOwner, int passwd){
//		this.accountNum = accountNum;
//		this.accountOwner = accountOwner;
//		this.passwd = passwd;
//		this.restMoney = 0;
		this(accountNum, accountOwner, passwd, 0);
		
	}
	
	public Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}
	
	// setter/getter methods
	public String getAccountNum(){
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	
	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getPasswd() {
		return passwd;
	}

	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}

	// �ν��Ͻ� �޼ҵ�
	public long deposit(long money){
		return restMoney += money;
	}

	public long withdraw(long money){
		return restMoney -= money;
	}

	public long getRestMoney(){
		return restMoney;	
	}

	public boolean checkPasswd(int pw){
		return passwd == pw;
	}

	// ��ü�� ������ �ִ� �Ӽ��� ���
	public void print(){
		System.out.println(accountNum + "\t" + accountOwner + "\t" + restMoney + "\t" + "****");
	}
	
	// Ŭ���� �޼ҵ�
	public static double calculateRate() {
		return 0.08;
	}
	
	@Override
	public String toString() {
//		return  "����ݰ���\t"+ accountNum + "\t" + accountOwner + "\t*****\t" + restMoney;
		return  String.format("%-9s", "����ݰ���") + String.format("%-17s", accountNum) + String.format("%-6s", accountOwner) + String.format("%-7s", "*****")  + String.format("%,14d��", restMoney);
	}
	
	@Override
	public boolean equals(Object obj) {
		return toString().equals(obj.toString());
	}

}
