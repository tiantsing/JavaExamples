package com.tiantsing.util;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class AnotationTest {

	@Test(expected = ArithmeticException.class)
	public void testDivide() {
		assertEquals(2,new Calculate().divide(4, 0));
	}
	@Ignore("忽略。。")
	@Test(timeout = 2000)
	public void testWhile() {
		while(true) {
			System.out.println("run forever..");
		}
	}
}
