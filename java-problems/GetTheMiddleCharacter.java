// source: Codewars
// https://www.codewars.com/kata/56747fd5cb988479af000028

// <7 kyu> Get The Middle Character
/*
You are going to be given a word. Your job is to return the middle character of the word. 

If the word's length is odd, return the middle character. 
If the word's length is even, return the middle 2 characters.

Examples:

        Kata.getMiddle("test") should return "es"

        Kata.getMiddle("testing") should return "t"

        Kata.getMiddle("middle") should return "dd"

        Kata.getMiddle("A") should return "A"

Input

A word (string) of length 0 < str < 1000. 
You do not need to test for this. 
This is only here to tell you that you do not need to worry about your solution timing out.

Output

The middle character(s) of the word represented as a string.
*/

// VERSION 2
class GetTheMiddleCharacter {
  public static String getMiddle(String word) {
    int length = word.length();

    // middle of an even word is length divided by 2
    // middle index is that minus 1
    int indexBeforeMiddle = (length / 2) - 1;
    int middleIndex = indexBeforeMiddle + 1;

    String middleContents = "";
    if (length % 2 == 0) {
      // length is even
      middleContents += word.charAt(indexBeforeMiddle);
    }
    middleContents += word.charAt(middleIndex);

    return middleContents;
  }
}

// VERSION 1
/*
class GetTheMiddleCharacter {
  public static String getMiddle(String word) {
    int frontIndex = 0;
    int rearIndex = word.length() - 1;

    while (frontIndex < rearIndex) {
      frontIndex++;
      rearIndex--;
    }

    String middleChars = "";
    // if frontIndex has passed rearIndex,
    // the word is even; grab rearIndex
    if (frontIndex > rearIndex) {
      middleChars += word.charAt(rearIndex);
    }
    middleChars += word.charAt(frontIndex);

    return middleChars;
  }
}
*/

