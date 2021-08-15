package com.practice.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ShortestSubString {

	
	/**
	 * 
	 * 
	 * Given a String, find the shortest substring having all chars
	 * 
	 * abbcafab
	 * 
	 * Output: bcaf
	 * 
	 * 
	 */
	
	
	/**
	 * Approach: Linear Scan
	 * 
	 * 
	 * 1. Store all unique chars in map
	 * 2. Iterate from input string 0 to len-1
	 * 3. For each iteration, expand around right side and keep adding to map
	 * 4. Find minimum substring within which input substring matches all chars
	 * 
	 * 
	 */
	
	@Test
	public void eg1() {
		String input = "dabbcabcd";
		System.out.println("First: " + minsubexp(input));
		System.out.println("First: " + minsub(input));
	}

	@Test
	public void eg2() {
		String input = "abbcafab";
		System.out.println("2nd: " + minsubexp(input));
		System.out.println("First: " + minsub(input));
	}
	
	

	private String minsub(String input) {
		Set<Character> set = new HashSet<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String output = input;

		for (int i = 0; i < input.length(); i++) {
			set.add(input.charAt(i));
		}

		for (Character character : set) {
			map.put(character, map.getOrDefault(character, 0) + 1);
		}

		for (int i = 0; i < input.length(); i++) {
			System.out.println(i);
			if (output.length() == map.size())
				break;
			output = findmimimum(input, i, input.length(), map, output.length(), output);
		}
		return output;
	}

	private String findmimimum(String input, int start, int end, Map<Character, Integer> map, int minimumvalue,
			String value) {
		Map<Character, Integer> newmap = new HashMap<Character, Integer>();
		int minvalue = 0;
		int val = start;

		while (start < end) {
			newmap.put(input.charAt(start), newmap.getOrDefault(input.charAt(start), 0) + 1);
			if (newmap.keySet().equals(map.keySet())) {
				minvalue = input.substring(val, start + 1).length();
				if (minvalue < minimumvalue)
					value = input.substring(val, start + 1);
				break;
			}
			start++;
		}

		return value;
	}
	
	
	/**
	 * Approach: Expand around Center
	 * 1. Iterate from 0 to string len -1
	 * 2. For each Iteration, expand on both the sides until the minimum substring containing all inputs are found
	 * 3. Return the minimum / shortest substring containing all the characters
	 * 
	 * 
	 * 
	 * @param input
	 * @return
	 */
	

	private String minsubexp(String input) {
		Set<Character> set = new HashSet<Character>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String output = input;

		for (int i = 0; i < input.length(); i++) {
			set.add(input.charAt(i));
		}

		for (Character character : set) {
			map.put(character, map.getOrDefault(character, 0) + 1);
		}

		List<String> list = new ArrayList<>();
		list.add(input);

		for (int i = 0; i < input.length(); i++) {
			if (output.length() == map.size())
				break;
			expandaroundcenter(input, i, i, list, list.get(0).length(), map);
			expandaroundcenter(input, i, i + 1, list, list.get(0).length(), map);

		}
		return list.get(0);
	}
	
	
	

	private void expandaroundcenter(String input, int start, int end, List<String> list, int outputlen,
			Map<Character, Integer> map) {
		int substringlen = 0;
		Map<Character, Integer> substrmap = new HashMap<Character, Integer>();
		while (start >= 0 && end < input.length()) {
			substrmap.put(input.charAt(start), substrmap.getOrDefault(input.charAt(start), 0) + 1);
			substrmap.put(input.charAt(end), substrmap.getOrDefault(input.charAt(end), 0) + 1);
			if (substrmap.keySet().equals(map.keySet())) {
				substringlen = input.substring(start, end + 1).length();
				if (substringlen < outputlen) {
					list.clear();
					list.add(input.substring(start, end + 1));
				}
			}

			start--;
			end++;

		}

	}
	
	
	
	
	
	
}
