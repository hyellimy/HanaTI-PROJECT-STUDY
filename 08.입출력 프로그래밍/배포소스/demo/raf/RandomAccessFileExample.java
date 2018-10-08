package demo.raf;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile은 스트림 API와 달리 파일에 대한 임의접근이 가능하고,
 * 양방향 입출력이 가능하고,
 * 자바 8개의 데이터타입별로 읽기 및 쓰기가 가능한 입출력 유틸리티 클래스이다.
 * File + BufferedInputStream(BufferedOutputStream) + DataInputStream(DataoutputStream) 통합 기능 제공
 * 단점은 File 처리에만 사용할 수 있다.
 * @author 김기정
 *
 */
public class RandomAccessFileExample {

	public static void main(String[] args) throws IOException {
		String path = "raf_example.dbf";
		RandomAccessFile raf = new RandomAccessFile(path, "rw");
		
		// 파일 사이즈
		long fileSize = raf.length();
		System.out.println("파일사이즈: " + fileSize);
				
		boolean flage = true;
		char c = '김';
		int age = 30;
		long money = 345567L;
		double weight = 75.78;
		String message = "랜덤억세스파일 다루기";
				
		// 현재 파일 포인터 위치
		long pointer = raf.getFilePointer();
		System.out.println(pointer);
						
		// 다양한 데이터 타입별 쓰기
		raf.writeBoolean(flage);
		System.out.println(raf.getFilePointer());
		raf.writeChar(c);
		System.out.println(raf.getFilePointer());
		raf.writeInt(age);
		System.out.println(raf.getFilePointer());
		raf.writeLong(money);
		System.out.println(raf.getFilePointer());
		raf.writeDouble(weight);
		System.out.println(raf.getFilePointer());
		raf.writeUTF(message);
		System.out.println(raf.getFilePointer());
		
		System.out.println("파일사이즈: " + raf.length());
		
		// 처음부터 다시 읽기 위해 포인터 위치를 처음으로 변경
		raf.seek(0);
		System.out.println(raf.readBoolean());
		System.out.println(raf.readChar());
		System.out.println(raf.readInt());
		System.out.println(raf.readLong());
		System.out.println(raf.readDouble());
		System.out.println(raf.readUTF());
				
		raf.close();	

	}

}
