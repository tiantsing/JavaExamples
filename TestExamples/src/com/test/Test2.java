package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * String[] array = new String[] {"1","2","3","4"};
		 * listAll(Arrays.asList(array),"");
		 */
		System.out.println(0.1);
	}

	private static void listAll(List candidate, String prefix) {
		System.out.println(prefix);
		for(int i=0;i<candidate.size();i++) {
			List temp = new LinkedList(candidate);
			listAll(temp,prefix + temp.remove(i));
		}
		System.out.println();
	}

}
