// source: Codewars
// https://www.codewars.com/kata/550498447451fbbd7600041c

// <6 kyu> Are They The "Same"?
/*
Given two arrays a and b write a function comp(a, b) that checks whether the two arrays have the "same" elements, 
with the same multiplicities. "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.

Examples

Valid arrays

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]

comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144, 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]

Invalid arrays

If we change the first number to something else, comp may not return true anymore:

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]

comp(a,b) returns false because in b 132 is not the square of any number of a.

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]

comp(a,b) returns false because in b 36100 is not the square of any number of a.

Remarks

    a or b might be [].
    a or b might be null.

If a or b are null, the problem doesn't make sense so return false.
*/

import java.util.Map;
import java.util.HashMap;

public class AreTheyTheSame {

  public static boolean comp(int[] a, int[] b) {
    if (a == null || b == null || a.length != b.length) {
      return false;
    }

    // create hashmap of squares from a
    // and the count of times they appear
    Map<Integer, Integer> squares = new HashMap<Integer, Integer>();

    for (int num : a) {
      Integer square = num * num;
      // if square is present in map, add one to its count
      // otherwise, add square to map
      squares.merge(square, 1, (OldVal, Val) -> OldVal + 1);
    }

    // for each item in b, check that it exists in the map
    // if it does, remove one from that item's count
    // if the count reaches zero, remove it from the map
    boolean areSame = true;
    for (int square : b) {
      if (squares.containsKey(square)) {
        Integer newCount = squares.get(square) - 1;
        if (newCount == 0) {
          squares.remove(square);
        } else {
          squares.put(square, newCount);
        }
      } else {
        areSame = false;
      }
    }

    return areSame;
  }
}

