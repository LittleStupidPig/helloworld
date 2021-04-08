package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Analyse{
	public static void main(String[] args) {
		
		File f=new File("D:/project/Test/document","hello.txt");
		ReadFile(f);	
	}
	
	public static void ReadFile(File f){
		try(FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);){
			StringBuffer sb=new StringBuffer();
			while(true){
				String line=br.readLine();
				if(null==line)
					break;
				int count=0;
                catchWords(line,sb,count);
			}
			System.out.println(sb.toString());
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private static void catchWords(String line,StringBuffer sb,int count) {
		int position=line.trim().indexOf(' ');
		 if(position>0){
			if(count!=0){
			sb.append("-");
			}
			sb.append(line.substring(0,position));
			count++;
			line=line.substring(position).trim();
			if(line.length()!=0){
				catchWords(line,sb,count);
			}
		 }
		 else{
			 sb.append("\r\n");
		 }
	}
}