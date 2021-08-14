package week2;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;

public class EqualNumberOfOccurences {
	
	/**
	 * https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
	 * 
	 * Given a string s, return true if s is a good string, or false otherwise.
	 * 
	 * A string s is good if all the characters that appear in s have the same
	 * number of occurrences (i.e., the same frequency).
	 * 
	 * Example 1:
	 * 
	 * Input: s = "abacbc" Output: true Explanation: The characters that appear in s
	 * are 'a', 'b', and 'c'. All characters occur 2 times in s. Example 2:
	 * 
	 * Input: s = "aaabb" Output: false Explanation: The characters that appear in s
	 * are 'a' and 'b'. 'a' occurs 3 times while 'b' occurs 2 times, which is not
	 * the same number of times.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= s.length <= 1000 s consists of lowercase English letters.
	 */
	
	
	@Test
	public void eg1() {
		String input="abacbc";
		Assert.assertEquals(true, findEqualNoOfChars(input));
		}
	
	@Test
	public void eg2() {
		String input="aaabb";
		Assert.assertEquals(false, findEqualNoOfChars(input));
	}

	/**
	 * Approach: Using Map & Set
	 * 1. Iterate through the string and add all characters and corresponding occurences to the map
	 * 2. Declare a set and add all the map values to the set
	 * 3. If the set size equals 1 (If all chars have same occurence, set would have only one value)
	 * 		Yes --> return true
	 * 		No --> return false
	 * 
	 * 
	 * @param input
	 * @return
	 */
	
	
	private boolean findEqualNoOfChars(String input) {
		if (input == null)
			throw new RuntimeException("invalid input");
		if (input.length() == 1)
			return true;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		for(int i=0;i<input.length();i++) {
			map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);
		}
		
		Set<Integer> set = new HashSet<Integer>(map.values());
		
		if(set.size()==1) return true;
		
		return false;
	}
	
	
	
	
	

}
