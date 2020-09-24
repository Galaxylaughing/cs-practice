// source: Codewars
// https://www.codewars.com/kata/56269eb78ad2e4ced1000013

// <7 kyu> Find The Next Perfect Square
/*
You might know some pretty large perfect squares. But what about the NEXT one?

Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. 
Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.

If the parameter is itself not a perfect square then -1 should be returned. You may assume the parameter is positive.

Examples:

findNextSquare(121) --> returns 144
findNextSquare(625) --> returns 676
findNextSquare(114) --> returns -1 since 114 is not a perfect
*/

public class NextPerfectSquare {
  public static long findNextSquare(long sq) {
      double root = Math.sqrt(sq);
      if (root == Math.floor(root)) {
        // is square
        long nextRoot = (long) root + 1;
        return nextRoot * nextRoot;
      } else {
        // is not square
        return -1;
      }
  }
}

