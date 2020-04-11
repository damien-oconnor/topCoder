package com.topcoder.dnasequence;

public class DNASequence {
	
	static final String geneticChars = "ACGT";
	
	public int longestDNASequence(String sequence) {	 
		
		int longestSequence = 0;
		int currentSequence = 0;
		
		if (sequence == null || sequence == "")
			return 0;
		
		for (int i=0;i<sequence.length();i++) {
			if (isAGeneticCharacter(sequence.charAt(i))) {
				currentSequence++;
			}
			else {
				longestSequence = Math.max(longestSequence, currentSequence);
				currentSequence = 0;
			}
		}
		longestSequence = Math.max(longestSequence, currentSequence);
		return longestSequence;
	}
	
	protected boolean isAGeneticCharacter(char character) {
		
		String charStr = Character.toString(character);
		
		for(int j=0;j<geneticChars.length();j++) {
			if(geneticChars.contains(charStr) || 
					geneticChars.contains(charStr.toUpperCase()))
				return true;
		}
		
		return false;
	}

}
