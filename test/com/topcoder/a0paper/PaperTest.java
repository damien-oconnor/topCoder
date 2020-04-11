package com.topcoder.a0paper;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PaperTest extends Assert {

	@Test
	void testValidFalse() {
		int[] a; 
		
		a = new int[] {0,1,0};
		assertFalse( Paper.valid(a) );
		
		a = new int[] {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
		assertFalse( Paper.valid(a) );
		
		a = new int[] {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		assertFalse( Paper.valid(a) );
		
		a = new int[] {0};
		assertFalse( Paper.valid(a) );
		
		a = new int[] {0,1};
		assertFalse( Paper.valid(a) );
	}
	
	@Test
	void testValidTrue() {
		int[] a; 
		
		a = new int[] {1};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {0,2};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {0,3};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {1,24};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {0,1,2};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {0, 1, 1, 2};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {0, 1, 1, 1, 2};
		assertTrue( Paper.valid(a) );
	}
	
	@Test
	void testValidUnitArray() {
		int[] a; 
				
		a = new int[] {1};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {2};
		assertTrue( Paper.valid(a) );
		
		a = new int[] {0};
		assertFalse( Paper.valid(a) );
	}

}
