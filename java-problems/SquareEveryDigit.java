// source: Codewars
// https://www.codewars.com/kata/546e2562b03326a88e000020

// <7 kyu> Square Every Digit
/*
In this kata, you are asked to square every digit of a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out, because
9^2 is 81 and 1^2 is 1.

Note: The function accepts an integer and returns an integer
*/

// VERSION 2
public class SquareEveryDigit {

  public int squareDigits(int n) {
    String squaredDigits = "";

    while (n > 0) {
        // figure out the last digit of n
        int currDigit = n % 10;
        // square last digit of n
        int squaredCurrDigit = currDigit * currDigit;
        // add squared digit to the beginning of the string
        squaredDigits = Integer.toString(squaredCurrDigit) + squaredDigits;
        // chop off the last digit of n
        n /= 10;
    }

    return Integer.parseInt(squaredDigits);
  }

}

// VERSION 1
/*
import java.lang.Math;

public class SquareEveryDigit {

  public int squareDigits(int n) {
    int[] digits = getDigits(n);
    // for each digit, square that digit
    // and add to a concatenated string
    String squaredDigits = "";
    for (int i = 0; i < digits.length; i++) {
      int square = (int) Math.pow(digits[i], 2);
      squaredDigits += Integer.toString(square);
    }
    return Integer.parseInt(squaredDigits);
  }

  private int[] getDigits(int n) {
    // get how many digits the n has
    int digitCount = getDigitCount(n);
    // make a new array big enough to store each digit
    int[] digits = new int[digitCount];

    // keep track of index of current last digit
    int i = digitCount - 1;
    while (n > 0) {
      // figure out the last digit of n
      int currDigit = n % 10;
      // add last digit to list of digits
      digits[i] = currDigit;
      // move i to the next last digit's index
      i--;
      // chop off the now-processed last digit of n
      n = n / 10;
    }
    return digits;
  }

  private int getDigitCount(int n) {
    // figure out how many digits the number has
    return 1 + (int) Math.log10(n);
  }

}
*/

