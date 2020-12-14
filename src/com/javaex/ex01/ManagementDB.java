package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class ManagementDB {
	
	//DB파일의 경로를 path문자열로 관리
	private String path = "C:\\javaStudy\\workspace\\MiniPro\\src\\com\\javaex\\ex01\\PhoneDB.txt";
	
	//DB파일을 불러옴
	public void loadDB(List<Phone> list) throws IOException {
		
		Reader r = new FileReader(path);
		BufferedReader br = new BufferedReader(r);
		
		while(true) {
			String line = br.readLine();
			if(line == null) {
				break;
			}
			String[] split = line.split(",");
			Phone person = new Phone(split[0], split[1], split[2]);
			
			list.add(person);
		}
		
		br.close();
	}
	
	//DB를 저장함
	public void saveDB(List<Phone> list) throws IOException {
		
		Writer w = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(w);
		
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i).getName()+","+list.get(i).getHp()+","+list.get(i).getCompany());
			bw.newLine();
		}
		
		bw.close();
	}
	
}
