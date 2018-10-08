package demo.notepad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileDao {
	
	public static String openFile(String path) throws IOException{
		String txt = null;
		File file = new File(path);
		if(!file.exists()) {
			throw new IOException("읽고자 하는 파일이 존재하지 않습니다.");
		}
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));
			char[] buffer = new char[(int)file.length()];
			int count = in.read(buffer);
			txt = new String(buffer, 0, count);
		}finally{
			if(in != null) in.close();
		}
		return txt;
	}
	
	
	public static void saveFile(String path, String txt) throws IOException {
		File file = new File(path);
		if(file.exists()) {
			throw new IOException("존재하는 파일입니다. 다른 이름을 사용하세요");
		}
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(file);
			txt = txt.replaceAll("\n", "\r\n");
			out.print(txt);
		}finally {
			if(out != null) out.close();
		}
		
	}
	

}
