// source: Codewars
// https://www.codewars.com/kata/5208f99aee097e6552000148

// <6 kyu> Break camelCase
/*
Complete the solution so that the function will break up camel casing, using a space between words.
Example

solution("camelCasing")  ==  "camel Casing"
*/

class BreakCamelCase {
  public static String camelCase(String input) {
    // exit early if String is too short to split
    if (input.length() < 2) {
      return input;
    }

    // create string and add first character of input
    String brokenCamelCase = input.substring(0, 1);

    // iterate over input. uppercase each char.
    // if uppercase char == curr char, add space
    // before adding char.
    for (int i = 1; i < input.length(); i++) {
      String currChar = input.substring(i, i + 1);
      String upperChar = currChar.toUpperCase();

      if (currChar.equals(upperChar)) {
        brokenCamelCase += " ";
      }
      brokenCamelCase += currChar;
    }

    return brokenCamelCase;
  }
}
