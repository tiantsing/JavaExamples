package com.test;

public class Test1 {

	public static void main(String[] args) {
		char ch[] = {'H','e','l','l','o'};
		change(ch);
		System.out.println(ch);

	}

	private static void change(char[] ch) {
		ch[0] = 'C';
	}

}
