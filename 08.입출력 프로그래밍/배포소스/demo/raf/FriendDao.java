package demo.raf;

import java.io.*;
import java.util.*;

/**
 * RandomAccessFile을 이용하여 친구정보를 레코드 단위로 파일에 저장/읽기 처리
 * 
 * @author 김기정
 */
public class FriendDao{
	
	/** 저장 파일 경로*/
	private static final String FILE_PATH = "friends.dbf";
	
	/** 레코드(친구)수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;
	
	/** 레코드(친구 이름,나이,몸무게,전화번호) 저장을 위한 컬럼별 사이즈 고정 */
	private static final int NAME_LENGTH = 10;      // 이름(10바이트)
	private static final int AGE_LENGTH = 4;        // 나이(4바이트)
	private static final int WEIGHT_LENGTH = 8;     // 몸무게(8바이트)
	private static final int TELEPHONE_LENGTH = 26; // 전화번호(26바이트)
	
	/** 친구정보 저장을 위한 레코드 사이즈 : 48바이트 */	
	public static final int RECORD_LENGTH = NAME_LENGTH + AGE_LENGTH + WEIGHT_LENGTH + TELEPHONE_LENGTH;
	
	private RandomAccessFile file;
	
	/** 저장된 친구(레코드)수 */
	private int recordCount = 0;
	
	public FriendDao() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		
		// 저장된 파일이 있는 경우..
		if(file.length() != 0){
			recordCount = file.readInt();
		}else{
			// 임시 디버깅용
			System.out.println("처음 프로그램을 실행하여 파일에 등록된 친구 없숑~~~");
		}
	}	

	/** getter */
	public int getRecordCount() {
		return recordCount;
	}
	
	/** 친구 정보 저장 */
	public void create(Friend friend) throws IOException{
		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		// 새로운 레코드(친구) 추가
		// 10 + 4 + 8 + 26
		String name = friend.getName();
		int age = friend.getAge();
		double weight = friend.getWeight();
		String telephone = friend.getTelephone();
		
		int charCount = name.length();		
		//10바이트(5글자)로 이름 저장
		for(int i = 0; i < (NAME_LENGTH/2); i++){		
			// EX) "김기정  "
			file.writeChar((i<charCount ? name.charAt(i) : ' '));
		}
		
		// 나이(4바이트)
		file.writeInt(age);
		// 몸무게(8바이트)
		file.writeDouble(weight);
				
		// 26바이트(13글자)로 전화번호 저장		
		charCount = telephone.length();
		for(int i = 0; i < (TELEPHONE_LENGTH/2); i++){
			// EX) "010-9179-8707"
			file.writeChar((i<charCount ? telephone.charAt(i) : ' '));
		}

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드(친구) 수 1 증가
		file.seek(0);
		file.writeInt(++recordCount);
	}
	

	/** 등록된 전체리스트 반환 */
	public List<Friend>  listAll() throws IOException{
		List<Friend> list = new ArrayList<Friend>();
		for(int i=0; i<recordCount; i++){
			Friend friend = read(i);
			list.add(friend);		
		}
		return list;
	}
	
	
	/** 특정 레코드의 정보를 Friend로 반환 */
	private Friend read(int index) throws IOException{
		Friend friend = null;
		
		String name = "";
		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		for(int i=0; i<(NAME_LENGTH/2); i++){
			name += file.readChar();
		}
		name = name.trim();
		
		int age = 0;
		age = file.readInt();
		
		double weight = 0.0;
		weight = file.readDouble();
		
		String telephone = "";
		for(int i = 0;i<(TELEPHONE_LENGTH/2);i++){
			telephone += file.readChar();
		}
		telephone = telephone.trim();
		
		friend = new Friend(name, age, weight, telephone);
		return friend;
	}
	
	// 스트림 닫기
	public void close(){
		try{
			if(file != null) file.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}


