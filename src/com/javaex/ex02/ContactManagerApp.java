package com.javaex.ex02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactManagerApp {

	public static void main(String[] args) throws IOException{
		
		int menu;
		boolean endFlag = true;	//while문을 빠져나오기위한 변수
		List<Phone> pList = new ArrayList<Phone>(); 
		
		ManagementDB manager = new ManagementDB();	//DB관리 클래스를 만들어 사용
		PhoneCtrl controll = new PhoneCtrl();
		manager.loadDB(pList);	//DB를 불러옴
		
		System.out.println("******************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("******************************************");
		
		while (endFlag) {
			
			menu = controll.selectMenu();

			switch (menu) {
				case 1:
					System.out.println("<1.리스트>");
					controll.printContect(pList);
					break;
					
				case 2:
					System.out.println("<2.등록>");
					controll.addContect(pList);
					break;
					
				case 3:
					System.out.println("<3.삭제>");
					controll.delContect(pList);
					break;
					
				case 4:
					System.out.println("<4.검색>");
					controll.findContect(pList);
					break;
					
				case 5:
					manager.saveDB(pList);	//DB를 저장함
					
					System.out.println("\n******************************************");
					System.out.println("*               감사합니다               *");
					System.out.println("******************************************");
					endFlag = false;
					break;
					
				default :
					System.out.println("[다시 입력해 주세요.]");
					break;
			}
		}
		
	}

}
