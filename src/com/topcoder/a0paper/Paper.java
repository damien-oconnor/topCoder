package com.topcoder.a0paper;

public class Paper {
	
	public static String canBuild(int[] a) {
        return valid(a)?"Possible":"Impossible";
    }
	
	public static boolean valid(int[] a) {
		for(int i=a.length-1;i>0;i--) {
			if (a[i] >= 2)
				a[i-1]+= a[i] / 2;
		}
		return a[0] >= 1;
		
	}

}
