// source: Codewars
// https://www.codewars.com/kata/5648b12ce68d9daa6b000099

// <7 kyu> Number of People in the Bus
/*
There is a bus moving in the city, and it takes and drop some people in each bus stop.

You are provided with a list (or array) of integer arrays (or tuples). 
Each integer array has two items which represent number of people get into bus (The first item) and 
the number of people get off the bus (The second item) in a bus stop.

Your task is to return number of people who are still in the bus after the last bus station (after the last array). 
Even though it is the last bus stop, the bus is not empty and some people are still in the bus, and they are probably sleeping there :D

Take a look on the test cases.

Please keep in mind that the test cases ensure that the number of people in the bus is always >= 0. So the return integer can't be negative.

The second value in the first integer array is 0, since the bus is empty in the first bus stop.
*/

import java.util.ArrayList;

class NumberOfPeopleInTheBus {

  public static int countPassengers(ArrayList<int[]> stops) {
    int peopleOnBus = 0;
    for (int i = 0; i < stops.size(); i++) {
      int[] currStop = stops.get(i);
      // add difference between people getting on
      // and people getting off to the total
      peopleOnBus += (currStop[0] - currStop[1]);
    }
    return peopleOnBus;
  }

}

