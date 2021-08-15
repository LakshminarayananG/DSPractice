package com.practice.week1;

import java.util.Stack;

import org.junit.Test;

public class RearrangeString {
	
	
	/**
	 * Given a string, return the string with count of each characters
	 * 
	 * Example: 
	 * Input: "aabbdcc"
	 * Output: "a2b2d1c2"
	 * 
	 * Input: ""
	 * Output: ""
	 * 
	 * Input: "ab"
	 * Output: "a1b1"
	 */
	
	
	@Test
	public void eg1() {
		String input="aabbdcc";
		System.out.println(retModifiedString(input));
	}
	
	@Test
	public void eg2() {
		String input="";
		System.out.println(retModifiedString(input));
	}
	
	@Test
	public void eg3() {
		String input="ab";
		System.out.println(retModifiedString(input));
	}
	
	@Test
	public void eg4() {
		String input="a";
		System.out.println(retModifiedString(input));
	}
	
	
	/**
	 * Approach: Linear Scan using stack
	 * 
	 * 1. Iterate from 0 to string len -1
	 * 2. Add first character to stack and also to output string
	 * 3. Check if stack is empty
	 * 		Yes --> Add current character to stack
	 * 		No  --> Proceed with iteration
	 * 4. Check if top element in stack is equal to current character
	 * 		Yes --> Continue adding to stack
	 * 		No  --> Append current top element of stack to output
	 * 			    Append stack size to output
	 * 				Clear the stack
	 * 				Append current character to output
	 * 	5. Add current character to stack
	 *  6. Return output String
	 */
	
	
	private String retModifiedString(String input) {
		
		if(input.length()==0) return "";
		
		Stack<Character> stack = new Stack<>();
		StringBuffer output = new StringBuffer();
		char[] charr= input.toCharArray();
		stack.push(charr[0]);
		output.append(charr[0]);
		for(int i=1;i<input.length();i++) {
		
			if (stack.isEmpty()) stack.push(charr[i]);
			else if(stack.peek()!=charr[i]) 
			{
				output.append(stack.size());
				stack.clear();
				stack.push(charr[i]);
				output.append(charr[i]);
			}
			else if(output.charAt(output.length()-1)!=charr[i]) output.append(charr[i]);
			else stack.push(charr[i]);
			
		}
		
		output.append(stack.size());
		
		return output.toString();
		
	}

}
