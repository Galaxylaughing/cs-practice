// source: Codewars
// https://www.codewars.com/kata/554b4ac871d6813a03000035

// <7 kyu> Highest and Lowest
/*
In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.

Example:

highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"

Notes:

    All numbers are valid Int32, no need to validate them.
    There will always be at least one number in the input string.
    Output string must be two numbers separated by a single space, and highest number is first.
*/

import java.util.Arrays;

public class HighestAndLowest {
  public static String highAndLow(String numbers) {
    String[] nums = numbers.split(" ", -2);

    int high = Integer.parseInt(nums[0]);
    int low = high;

    for (int i  = 0; i < nums.length; i++) {
      int currVal = Integer.parseInt(nums[i]);

      // compare to high
      if (currVal > high) {
        high = currVal;
      }
      // compare to low
      if (currVal < low) {
        low = currVal;
      }
    }

    return Integer.toString(high) + " " + Integer.toString(low);
  }
}

