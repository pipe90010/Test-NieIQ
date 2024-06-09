package com.arias.nielseniq.test.home_test.problem1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class MissingLetters {

    private static final List<Character> alphabet = new ArrayList<>();
	
	static {
		for(int i= 97; i<= 122; i++){
			alphabet.add((char)i);
		}		
	}

	public String getMissingLetters(String testString) {
	
		//checks if the input testString is null, so that it is considered as blank and an empty string is placed instead
		String opt = Optional.ofNullable(testString).filter(Predicate.not(String::isBlank)).orElse("");

		//A set to keep the current chars
        HashSet<Character> currentChars = getCurrentCharacterFromString(opt);
 
        // check the alphabet to know which characters are missing
        StringBuilder missingChars = getMissingLetterStrBldr(currentChars);
 
        // print the missing characters
        if(missingChars.length() == 0){
            System.out.println("The string is a pangram.");
			return "";
        }
        else{
            System.out.println(missingChars);
			return missingChars.toString();
        }
	}

	//lopps over the string to use onlu Alphabelt Characters
	HashSet<Character> getCurrentCharacterFromString(String str){
		HashSet<Character> currentChars = new HashSet<>();
		for(int i = 0; i < str.length(); i++){
			char c = Character.toLowerCase( str.charAt(i));
			if (c >= 'a' && c <= 'z'){
				currentChars.add(c);
			}
		}
		return currentChars;
	}

	StringBuilder getMissingLetterStrBldr(HashSet<Character> currentChars){
		StringBuilder missingChars = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++){
            if(!currentChars.contains(c)){
                missingChars.append(c);
            }
        }
		return missingChars;
	}
}
