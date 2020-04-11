package com.topcoder.ab;

public class AB {
	
	/** Generate a String of characters ('A' or 'B') such that K pairs of characters are formed.
	 *  
	 * The string has exactly N characters, each of which is either 'A' or 'B'.
	 * The string has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
	 * 
	 * The number of As (a) and the number of Bs (b) total K : K = a + b. a*b is the number of pairs.
	 * 
	 * @param N Number of items in the returned String
	 * @param K Number of pair within the returned String 
	 * @return
	 */
	public String createString(int N, int K) {
				
		if (N <= 1) {
			return "";
		}
		else if (N == 2 && K == 1) {
			return "AB";
		}
		else if (N == 2 && K == 0) {
			return "BA";
		}
		
		//Ignore the cases when K is too large
		if (getMaxK(N) < K)
			return "";
		
		String s = fillStringWithBs(N);
		int k = calculateK(s);
		
		//Target BABB
		//Current BBBB
		while (K > k) {
			System.out.println("K is "+K+", k is "+k + ", s is "+s);
			if (K >= calculateK(s.replaceFirst("B",  "A"))) {
				s = s.replaceFirst("B",  "A");
			}
			else {
				//replace B in the right place
				int b_count = countBs(s);
				int indexOfBToReplace = 0;
				if (k > 0)
					indexOfBToReplace = b_count - (K-k)-1;
				else
					indexOfBToReplace = b_count - (K-k);
				s = replaceIthB(s, indexOfBToReplace);
			}
			k = calculateK(s);
		}
		return s;
	}
	
	
	protected int getMaxK(int N) {
		int maxK = 0;
		for(int i=1;i<N;i++) { 
			
			maxK = Math.max(maxK, (N-i)*i);
			
		}
		return maxK;
	}
	
	protected int calculateK(String s) {
		int k = 0;
		int a_count = 0;
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i) == 'A') {
				a_count++;
			}
			else {
				k+=a_count;
			}
		}
		return k;
	}
	
	protected String fillStringWithBs(int N) {
		String s = new String();
		for (int i =0;i<N;i++)
			s += "B";
		return s;
	}
	
	protected int countBs(String s) {
		int b_count = 0;
		for (int i =0;i<s.length(); i++) {
			if (s.charAt(i) == 'B') 
				b_count++;
		}
		return b_count;
	}
	
	/*
	 * replace the ith B found in the String. Counting from 1.
	 */
	protected String replaceIthB(String s, int i) {
		int cur_b_count = -1;
		char[] s_array = s.toCharArray();
		
		for (int pos = 0;pos < s.length();pos++) {
			if (s.charAt(pos) == 'B') {
				cur_b_count++;
				
				if (cur_b_count == i-1) {
					s_array[pos] = 'A';
					return new String(s_array);
				}
			}		
		}
		
		return s;
	}

}
