package com.javaex.ex01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManagerApp {

	public static void main(String[] args) throws IOException{
		
		int menu, num;
		String name, hp, company;
		boolean endFlag = true;	//while문을 빠져나오기위한 변수
		List<Phone> pList = new ArrayList<Phone>(); 
		
		Scanner sc = new Scanner(System.in);
		
		ManagementDB manager = new ManagementDB();	//DB관리 클래스를 만들어 사용
		
		manager.loadDB(pList);	//DB를 불러옴
		
		System.out.println("******************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("******************************************");
		
		while (endFlag) {
			System.out.println("\n1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("------------------------------------------");
			System.out.print(">메뉴번호:");
			menu = sc.nextInt();

			switch (menu) {
				case 1:
					System.out.println("<1.리스트>");
					for (int i = 0; i < pList.size(); i++) {
						System.out.print(i+1+".   ");
						pList.get(i).showContect();
					}
					break;
					
				case 2:
					System.out.println("<2.등록>");
					System.out.print(">이름:");
					sc.nextLine(); //정수형 입력 후 문자열 입력 오류 해결
					name = sc.nextLine();
					System.out.print(">휴대전화:");
					hp = sc.nextLine();
					System.out.print(">회사전화:");
					company = sc.nextLine();
					
					Phone person = new Phone(name, hp, company);
					
					pList.add(person);
					
					System.out.println("[등록되었습니다.]");
					break;
					
				case 3:
					System.out.println("<3.삭제>");
					System.out.print(">번호:");
					num = sc.nextInt();
					
					pList.remove(num-1);
					break;
					
				case 4:
					System.out.println("<4.검색>");
					System.out.print(">이름:");
					sc.nextLine();	//정수형 입력 후 문자열 입력 오류 해결
					name = sc.nextLine();
					
					for (int i = 0; i < pList.size(); i++) {
						
						if(pList.get(i).getName().indexOf(name) != -1) {
							System.out.print(i+1+".   ");
							pList.get(i).showContect();
						}
						
					}
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
		
		sc.close();
	}

}
