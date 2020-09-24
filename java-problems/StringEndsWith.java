// source: Codewars
// https://www.codewars.com/kata/51f2d1cafc9c0f745c00037d

// <7 kyu> String Ends With?
/*
Complete the solution so that it returns true if the first argument(string) passed in ends with the 2nd argument (also a string).

Examples:

solution('abc', 'bc') // returns true
solution('abc', 'd') // returns false
*/

public class StringEndsWith {
  public static boolean solution(String str, String ending) {
    int strLength = str.length();
    int endingLength = ending.length();

    // return early if ending is longer than str
    if (endingLength > strLength) {
      return false;
    }

    int i = strLength - endingLength;
    int j = 0;
    while (i < strLength && j < endingLength) {
      if (str.charAt(i) != ending.charAt(j)) {
        return false;
      }
      i += 1;
      j += 1;
    }

    return true;
  }
}

