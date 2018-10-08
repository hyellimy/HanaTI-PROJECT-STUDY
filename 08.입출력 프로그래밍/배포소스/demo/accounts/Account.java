package demo.accounts;
/**
 * 일상생활의 객체를 추상화하기 위한 모델링 클래스 정의
 * 은행계좌 객체
 */
public class Account {


	// static 초기화 블럭(특수한 목적의 명령어 실행)
	static {
//		System.out.println("초기화 블럭 실행입니다..1");
//		System.out.println("초기화 블럭 실행입니다..2");
	}
	
	// 클래스(static) 변수
	public  static final String bankName = "하나은행";

	// 인스턴스 변수 선언
	private String accountNum ;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// 생성자
	public Account(){
		this(null, null);
	}

	public Account(String accountNum, String accountOwner){
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0);
	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter/getter 메소드
	public void setAccountNum(String accountNum){
		this.accountNum = accountNum;
	}

	public String getAccountNum(){
		return accountNum;	
	}

	public void setAccountOwner(String accountOwner){
		this.accountOwner = accountOwner;
	}

	public String getAccountOwner(){
		return accountOwner;	
	}

	public void setRestMoney(long restMoney){
		this.restMoney = restMoney;
	}

	public void setPasswd(int passwd){
		this.passwd = passwd;
	}

	public int getPasswd(){
		return passwd;
	}


	// 인스턴스 메소드
	public long deposit(long money)  throws AccountException{
		if(money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.", -1);
		}
		
		restMoney += money;
		return restMoney;
	}

	public long withdraw(long money) throws AccountException{
		if(money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.", -1);
		}
		
		if(money > restMoney) {
			throw new AccountException("잔액이 부족합니다.", -2);			
		}
		
		restMoney -= money;
		return restMoney;
	}

	public long getRestMoney(){
		return restMoney;
	}

	public boolean checkPasswd(int pw){
		return passwd == pw;
	}
	
	@Override
	public String toString() {
		return getAccountNum() + "\t" + getAccountOwner() + "\t" + "****" + "\t" + getRestMoney();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean eq = false;
		if(obj instanceof Account) {
			eq = toString().equals(obj.toString());
		}
		return eq;
	}
	
	
	

	//클래스(static) 메소드
	public static int sum(int a, int b){
		return a + b;
	}
	
}
