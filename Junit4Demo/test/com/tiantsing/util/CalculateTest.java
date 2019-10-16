package com.tiantsing.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTest {

	@Test
	public void testAdd() {
		assertEquals(6,new Calculate().add(3, 3));
	}
	@Test
	public void testSubtract() {
		assertEquals(3,new Calculate().subtract(5, 2));
	}
	@Test
	public void testMultiply() {
		assertEquals(4,new Calculate().multiply(2, 2));
	}
	@Test
	public void testDivide() {
		assertEquals(2,new Calculate().divide(4, 2));
	}
}
