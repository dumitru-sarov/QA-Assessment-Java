﻿package com.qa.javaAssessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		String bert = "bert";
		String regex = Pattern.quote(bert) + "(.*?)" + Pattern.quote(bert);
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		String textInBetween = "";
		
		while (matcher.find()) {
			textInBetween = matcher.group(1);
		}
		
		String reverse = new StringBuilder(textInBetween).reverse().toString();
		return reverse;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		List<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(a);
		numbers.add(b);
		numbers.add(c);
		
		Collections.sort(numbers);
		
		if(numbers.get(1)-numbers.get(0) == numbers.get(2)-numbers.get(1)) {
			return true;
		}
		
		return false;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		while(a!=0) {
			input = input.substring(0, input.length()/2) +
					input.substring(input.length()/2+1);
			a--;
		}		
		return input;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		if(input.isEmpty()) {
			return 0;
		}
		
		int counter = 1; 
		int value = 0;
		
		for(int j = 1; j < input.length(); j++) {
			if(input.charAt(j) == input.charAt(j-1)) {
				counter++;	
				if(value < counter) {
						value = counter;						
					}
				} 
				else {
					counter = 1;
				}
			}	
		return value;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		String am = "am";
		String temp[] = arg1.split(" ");
		int counter = 0;
		
		for (int i = 0; i < temp.length; i++) {
			if(am.equalsIgnoreCase(temp[i])) {
				counter++;
			}
		}		
		return counter;			
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		if (arg1 % 3 == 0 && arg1 % 5 == 0) {
			return "fizzbuzz";
		}		
		else if(arg1 % 5 == 0) {
			return "buzz";
		}		
		else if(arg1 % 3 == 0) {
			return "fizz";
		} 
		return "No fizz or buzz";		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		String temp[] = arg1.split(" ");		
		int value = 0;
		for(int i = 0; i < temp.length; i++) {
			int sum = 0;
			String numbers[] = temp[i].split("");
				for(int j = 0; j < numbers.length; j++) {
					sum += Integer.parseInt(numbers[j]);
				}
			
			if(value <= sum) {
				value = sum;
			}
		}
		return value;
	}
}

