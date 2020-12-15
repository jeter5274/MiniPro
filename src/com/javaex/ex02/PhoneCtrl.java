package com.javaex.ex02;

import java.util.List;
import java.util.Scanner;

public class PhoneCtrl {
	
	Scanner sc = new Scanner(System.in);
	
	public int selectMenu() {
		System.out.println("\n1.리스트  2.등록  3.삭제  4.검색  5.종료");
		System.out.println("------------------------------------------");
		System.out.print(">메뉴번호:");
		
		return sc.nextInt();
	}

	public void printContect(List<Phone> pList) {
		for (int i = 0; i < pList.size(); i++) {
			System.out.print(i+1+".   ");
			pList.get(i).showContect();
		}
	}
	
	public void addContect(List<Phone> pList) {
		System.out.print(">이름:");
		sc.nextLine(); //정수형 입력 후 문자열 입력 오류 해결
		String name = sc.nextLine();
		System.out.print(">휴대전화:");
		String hp = sc.nextLine();
		System.out.print(">회사전화:");
		String company = sc.nextLine();
		
		Phone person = new Phone(name, hp, company);
		
		pList.add(person);
		
		System.out.println("[등록되었습니다.]");
	}
	
	public void delContect(List<Phone> pList) {
		System.out.print(">번호:");
		int num = sc.nextInt();
		
		pList.remove(num-1);
	}
	
	public void findContect(List<Phone> pList) {
		System.out.print(">이름:");
		sc.nextLine();	//정수형 입력 후 문자열 입력 오류 해결
		String name = sc.nextLine();
		
		for (int i = 0; i < pList.size(); i++) {
			
			if(pList.get(i).getName().indexOf(name) != -1) {
				System.out.print(i+1+".   ");
				pList.get(i).showContect();
			}
			
		}
	}
	
	
}
