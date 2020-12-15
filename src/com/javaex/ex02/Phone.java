package com.javaex.ex02;

public class Phone {
	
	//필드
	private String name, hp, company;
	
	//생성자
	public Phone() {}
	public Phone(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	//메소드 getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	//메소드 일반
	public void showContect() {
		System.out.println(name+ "   " +hp+ "  " +company);
	}
	
	@Override
	public String toString() {
		return "Phone [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	
	
	
	
}
