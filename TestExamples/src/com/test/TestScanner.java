package com.test;

import java.util.Scanner;

/**
 * ���Ի�ü�������
 * @author tianq
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������֣�");
		String name = scanner.nextLine();
		System.out.println("���������䣺");
		int age = scanner.nextInt();

		System.out.println("#########");
		System.out.println(name);
		System.out.println(age);
	}

}
