package com.tiantsing.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitFlowTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("This is BeforeClass!");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("This is AfterClass!");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("This is @Before!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("This is @After!");
	}

	@Test
	public void test() {
		System.out.println("This is test!");
	}
	@Test
	public void test2() {
		System.out.println("This is test2!");
	}

}
