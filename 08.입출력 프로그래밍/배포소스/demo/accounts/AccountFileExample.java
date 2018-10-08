package demo.accounts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AccountFileExample {
	
	static final String path = "accounts.dat";
	
	public static void main(String[] args) throws IOException {
		// 계좌정보 파일 저장 테스트
		Account account= new Account("1111-2222-3333", "김기정", 1111, 1000000);
		MinusAccount maccount= new MinusAccount("2222-2222-3333", "김대출", 1111, 1000000, 10000000);
		
		// 텍스트 파일에 콤마(,)로 구분하여 계좌정보 저장(CSV 데이터)
		PrintWriter out = new PrintWriter(path);
		
		out.println(account.getAccountNum() + "," + account.getAccountOwner() + "," + account.getPasswd() + "," + account.getRestMoney() + "," + 0);
		out.println(maccount.getAccountNum() + "," + maccount.getAccountOwner() + "," + maccount.getPasswd() + "," + maccount.getRestMoney() + "," +maccount.getBorrowMoney());
		out.close();
		
		// 계좌정보 파일 읽기 테스트
		BufferedReader in = new BufferedReader(new FileReader(path));
		String accountInfo = null;
		while((accountInfo=in.readLine()) != null) {
//			System.out.println(accountInfo);
			// 계좌의 속성정보들이 필요할 경우
			StringTokenizer st = new StringTokenizer(accountInfo, ",");
			String num = st.nextToken();
			String owner = st.nextToken();
			int passwd = Integer.parseInt(st.nextToken());
			long restMoney = Long.parseLong(st.nextToken());
			long borrowMoney = Long.parseLong(st.nextToken());
			System.out.println(num);
			System.out.println(owner);
			System.out.println(passwd);
			System.out.println(restMoney);
			System.out.println(borrowMoney);
		}
		
		in.close();

	}

}
