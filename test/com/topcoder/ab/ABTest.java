package com.topcoder.ab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ABTest {
	
	static AB ab = null;
	
	@BeforeAll
	static void setUp() {
		ab = new AB();
	}
	
	void assertValues(String expected, int N, int K) {
		assertEquals(expected, ab.createString(N, K));
	}

	@Test
	void testBaseCases() {
		assertValues("BA",2, 0);
		assertValues("AB",2, 1);
		assertValues("",1, 1);
		assertValues("",1, 0);
		assertValues("",0, 0);
		assertValues("",5, 8);
		assertValues("ABBBBABBBB",10, 12);
	}
	
	@Test
	void test3CharCases() {
		assertValues("BBB", 3, 0);
		assertValues("BAB", 3, 1);
		assertValues("ABB", 3, 2);
	}
	
	@Test
	void test4CharCases() {
		assertValues("BBBB", 4, 0);
		assertValues("ABBB", 4, 3);
		assertValues("AABB", 4, 4);
		assertValues("ABBB", 4, 3);
		assertValues("BABB", 4, 2);
	}
	
	@Test
	void testMaxK() {
		assertEquals(0, ab.getMaxK(0));
		assertEquals(0, ab.getMaxK(1));
		assertEquals(1, ab.getMaxK(2));
		assertEquals(2, ab.getMaxK(3));
		assertEquals(4, ab.getMaxK(4));
		assertEquals(6, ab.getMaxK(5));
		assertEquals(9, ab.getMaxK(6));
		assertEquals(12, ab.getMaxK(7));
	}
	
	@Test
	void testFillStringWithBs() {
		assertEquals("B", ab.fillStringWithBs(1));
		assertEquals("BB", ab.fillStringWithBs(2));
		assertEquals("BBB", ab.fillStringWithBs(3));
		assertEquals("BBBB", ab.fillStringWithBs(4));
		assertEquals("BBBBB", ab.fillStringWithBs(5));
		
		
	}
	
	@Test
	void testCountBs() {
		assertEquals(1, ab.countBs("AB"));
		assertEquals(3, ab.countBs("BBB"));
		assertEquals(4, ab.countBs("BBBB"));
		assertEquals(5, ab.countBs("BBBBB"));
		assertEquals(5, ab.countBs("BABABABABA"));
		assertEquals(5, ab.countBs("ABABABABABA"));
		
	}
	
	@Test
	void testReplaceIthB() {
		assertEquals("AABA", ab.replaceIthB("ABBA", 1));
		assertEquals("ABAA", ab.replaceIthB("ABBA", 2));
		assertEquals("ABBA", ab.replaceIthB("ABBA", 3));
		assertEquals("AAAA", ab.replaceIthB("AAAA", 3));
		assertEquals("BBBBB", ab.replaceIthB("BBBBB", 0));
		assertEquals("ABBBB", ab.replaceIthB("BBBBB", 1));
		assertEquals("BABBB", ab.replaceIthB("BBBBB", 2));
		assertEquals("BBABB", ab.replaceIthB("BBBBB", 3));
		assertEquals("BBBAB", ab.replaceIthB("BBBBB", 4));
		assertEquals("BBBBA", ab.replaceIthB("BBBBB", 5));
		assertEquals("BBBBB", ab.replaceIthB("BBBBB", 6));
	}
	
	
	@Test
	void testCalculateK() {
		assertEquals(1, ab.calculateK("AB"));
	}
	
	/*
	 * Examples
3)
10
12
Returns: "BAABBABAAB"
Please note that this is an example of a solution; other valid solutions will also be accepted.
	 */

}
