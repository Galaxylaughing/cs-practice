// source: Codewars
// https://www.codewars.com/kata/54b42f9314d9229fd6000d9c

// <6 kyu> Duplicate Encoder
/*
The goal of this exercise is to convert a string to a new string 
where each character in the new string is "(" if that character appears only once in the original string, 
or ")" if that character appears more than once in the original string. 
Ignore capitalization when determining if a character is a duplicate.
*/

import java.util.HashMap;

public class DuplicateEncoder {
  static String encode(String word){
    word = word.toUpperCase();

    // count how many times each character appears
    HashMap<Character, Integer> charCounts = new HashMap<Character, Integer>();
    for (int i = 0; i < word.length(); i++) {
      Character currChar = word.charAt(i);
      // if charCounts with the currChar key exists, ++
      // if it does, set it
       charCounts.merge(currChar, 1, (K, V) -> V + 1);
    }

    String duplicates = "";
    for (int i = 0; i < word.length(); i++) {
      Character currChar = word.charAt(i);
      Integer charCount = charCounts.get(currChar);
      // if charCounts.get(char) == 1, add (
      // else add )
      duplicates += (charCount == 1) ? "(" : ")";
    }

    return duplicates;
  }
}

