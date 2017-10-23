package org.rakesh.projecteuler.problem2;

import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.rakesh.projecteuler.common.ExceptionMessages;

/**
 * This program calculates the sum of the even-valued Fibonacci sequence terms.
 *
 * @author Rakesh Kandibanda
 * @version 1.0.0
 * @see <a href="https://projecteuler.net/problem=2">https://projecteuler.net/problem=2</a>
 */
public class EvenFibonacciNumbers {

  private final static Logger LOGGER = Logger.getLogger(EvenFibonacciNumbers.class);

  public static void main(String[] args) {

    EvenFibonacciNumbers evenFibonacciNumbers = new EvenFibonacciNumbers();
    long lStartTime = System.nanoTime();
    int evenFibonacciSumResult = evenFibonacciNumbers.getSumofEvenFibonacciNumbers(4 * 1000000);
    long lEndTime = System.nanoTime();
    LOGGER.info("Execution time of " + EvenFibonacciNumbers.class.getSimpleName() + ": "
        + String.format("%.5f", ((lEndTime - lStartTime) / 1000000.0))
        + "(ms)");
    LOGGER
        .info("Sum of even fibonacci numbers until the bound limit is: " + evenFibonacciSumResult);

  }

  /**
   * This method generates fibonacci terms until the {@code upperBound} and calculates
   * the sum of the even-valued Fibonacci sequence terms.
   *
   * @param upperBound upper bound on the fibonacci sequence generation.
   * @return Total sum of the even-valued Fibonacci sequence terms until the limit {@code upperBound}.
   */

  public int getSumofEvenFibonacciNumbers(int upperBound) {
    if (upperBound <= 0) {
      throw new IllegalArgumentException(ExceptionMessages.INPUT_NATURAL_NUMBER);
    }
    int[] stateFibonacci = new int[]{0, 1};
    int runningSumOfEvenFibonacciNumbers = 0;

    while (stateFibonacci[1] <= upperBound) {
      // Checking for Even Number using bitwise AND operation with one.
      if ((stateFibonacci[1] & 1) == 0) {
        runningSumOfEvenFibonacciNumbers =
            runningSumOfEvenFibonacciNumbers + stateFibonacci[1];
      }
      int nextFibonacciInSequence = stateFibonacci[0] + stateFibonacci[1];
      stateFibonacci[0] = stateFibonacci[1];
      stateFibonacci[1] = nextFibonacciInSequence;
    }
    return runningSumOfEvenFibonacciNumbers;
  }



}
