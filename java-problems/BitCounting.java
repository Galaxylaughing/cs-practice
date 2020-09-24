// source: Codewars
// https://www.codewars.com/kata/526571aae218b8ee490006f4

// <6 kyu> Bit Counting
/*
Write a function that takes an integer as input, 
and returns the number of bits that are equal to one in the binary representation of that number. 
You can guarantee that input is non-negative.

Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
*/

// VERSION 2
public class BitCounting {

  public static int countBits(int n) {
    // binary is base 2; therefore % 2 and / 2 until 0.
    int countOfOnes = 0;
    while (n > 0) {
      countOfOnes += n % 2;
      n /= 2;
    }
    return countOfOnes;
  }

}

// VERSION 1
/*
public class BitCounting {

  public static int countBits(int n){
    String binaryRep = Integer.toBinaryString(n);
    int count = 0;
    for (int i = 0; i < binaryRep.length(); i++) {
      count += Character.getNumericValue(binaryRep.charAt(i));
    }
    return count;
  }

}
*/

