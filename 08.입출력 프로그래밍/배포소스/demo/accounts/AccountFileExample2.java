package demo.accounts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccountFileExample2 {
	
	static final String path = "accounts2.dat";
	
	public static void main(String[] args) throws IOException {
		// 계좌정보 파일 저장 테스트
		Account account= new Account("1111-2222-3333", "김기정", 1111, 1000000);
		MinusAccount maccount= new MinusAccount("2222-2222-3333", "김대출", 1111, 1000000, 10000000);
		
		// 자바 데이터타입별로 저장
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		
		out.writeUTF(account.getAccountNum());
		out.writeUTF(account.getAccountOwner());
		out.writeInt(account.getPasswd());
		out.writeLong(account.getRestMoney());
		out.writeLong(0L);
		
		out.writeUTF(maccount.getAccountNum());
		out.writeUTF(maccount.getAccountOwner());
		out.writeInt(maccount.getPasswd());
		out.writeLong(maccount.getRestMoney());
		out.writeLong(maccount.getBorrowMoney());
		out.close();
		
		// 계좌정보 파일 읽기 테스트
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		String num = in.readUTF();
		String owner = in.readUTF();
		int passwd = in.readInt();
		long restMoney = in.readLong();
		long borrowMoney = in.readLong();
		
		System.out.println(num);
		System.out.println(owner);
		System.out.println(passwd);
		System.out.println(restMoney);
		System.out.println(borrowMoney);
		
		num = in.readUTF();
		owner = in.readUTF();
		passwd = in.readInt();
		restMoney = in.readLong();
		borrowMoney = in.readLong();
		
		System.out.println(num);
		System.out.println(owner);
		System.out.println(passwd);
		System.out.println(restMoney);
		System.out.println(borrowMoney);
		
		in.close();

	}

}
