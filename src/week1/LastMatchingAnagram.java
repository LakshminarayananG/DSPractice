package week1;

import java.util.HashMap;

import org.junit.Test;

public class LastMatchingAnagram {

	
	/**
	 * Given a string, and a target string, find the last matching anagram 
	 * 
	 * Example:
	 * Input 1: "abcdcgcda"
	 * Target : acd
	 * 
	 * Output: cda
	 * 
	 * 
	 */
	
	
	@Test
	public void eg1() {
		String input ="abcdcgcda";
		String target ="acd";
		System.out.println(lastMatchingAnagram(input, target));
	}
	
	
	@Test
	public void eg2() {
		String input ="abcdcgcda";
		String target ="";
		System.out.println(lastMatchingAnagram(input, target));
	}
	
	@Test
	public void eg3() {
		String input ="bhy";
		String target ="abcdcgcda";
		System.out.println(lastMatchingAnagram(input, target));
	}
	
	@Test
	public void eg4() {
		String input ="abc";
		String target ="bac";
		System.out.println(lastMatchingAnagram(input, target));
	}
	
	@Test
	public void eg5() {
		String input ="abcdbacbbgacb";
		String target ="bac";
		System.out.println(lastMatchingAnagram(input, target));
	}
	
	
	
	
	/**
	 * Approach: Sliding Window
	 * 
	 * 1. Iterate from 0 to len-1 of target and add chars to target map
	 * 2. Iterate from 0 to target len -1 in input string, add the character to a map
	 * 3. Check if iteration value > = target length
	 * 	  Yes --> Get (iteration - target len) character from input string
	 * 			  Check if char value equals 1 in input map
	 * 				  Yes --> remove character from map 
	 * 				  No  --> decrement value of character by 1
	 * 4. Check if input map equals target map
	 * 		Yes --> Get substring and store in output
	 * 
	 * 5. Return output
	 * 
	 * Time Complexity: O[N]
	 * 
	 * 
	 * @param input
	 * @param target
	 */
	
	
	private String lastMatchingAnagram(String input,String target) {
		if(target.length()==0|| target.length()>input.length()) throw new RuntimeException("No matching anagram found");
		
		String output="";
		HashMap<Character,Integer> inputmap = new HashMap<>();
		HashMap<Character,Integer> targetmap = new HashMap<>();
		
		for(int i=0;i<target.length();i++) {
			targetmap.put(target.charAt(i), targetmap.getOrDefault(target.charAt(i), 0)+1);
		}
		
		if(input.length()==target.length()) {
			if(input.equals(target)) return input;
			for(int i=0;i<input.length();i++) {
				inputmap.put(input.charAt(i), inputmap.getOrDefault(input.charAt(i), 0)+1);
			}
			
			if(inputmap.equals(targetmap)) return input;
		}
		
		
		for(int i=0;i<input.length();i++) {
			char ch=input.charAt(i);
			inputmap.put(input.charAt(i), inputmap.getOrDefault(input.charAt(i), 0)+1);
			
			if(i>=target.length()) {
				ch= input.charAt(i-target.length());
				
				if(inputmap.get(ch)==1) inputmap.remove(ch);
				else inputmap.put((ch), inputmap.get(ch)-1);
			}
			
			if(inputmap.equals(targetmap))
				{
				output=input.substring(i-target.length()+1, i+1);
				}
		}
		
		
		return output;
	}
	
	
	
}
