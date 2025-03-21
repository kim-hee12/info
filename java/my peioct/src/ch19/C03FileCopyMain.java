package ch19;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class C03FileCopyMain {
	
	private static String FileDir = "C:\\iotest\\";

	public static void main(String[] args) throws IOException {
		
		for(String arg : args)
			System.out.println(arg);
		
		Reader fin = new FileReader(FileDir + args[0]);
		Writer fout = new FileWriter(FileDir + args[1]);
		
		while(true) {
			int data = fin.read();
			if(data==-1)
				break;
			fout.write((char)data);
			fout.flush();
		}
		fin.close();
		fout.close();
	}

}
