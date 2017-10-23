package org.rakesh.projecteuler.problem6;

import org.apache.log4j.Logger;
import org.rakesh.projecteuler.common.ExceptionMessages;

/**
 * This program calculates difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 *
 * @author Rakesh Kandibanda
 * @version 1.0.0
 * @see <a href="https://projecteuler.net/problem=6">https://projecteuler.net/problem=6</a>
 */
public class SumSquareDifference {

  private final static Logger LOGGER = Logger.getLogger(SumSquareDifference.class);


  public static void main(String[] args) {
    SumSquareDifference sumSquareDifference = new SumSquareDifference();
    long lStartTime = System.nanoTime();
    int evenFibonacciSumResult = sumSquareDifference
        .calculateDifferenceBetweenSumofSquaresAndSquareOfSum(100);
    long lEndTime = System.nanoTime();
    LOGGER.info("Execution time of " + SumSquareDifference.class.getSimpleName() + ": "
        + String.format("%.5f", ((lEndTime - lStartTime) / 1000000.0))
        + "(ms)");
    LOGGER
        .info("Difference of (Square of sum - Sum of Squares ) is : " + evenFibonacciSumResult);
  }

  /**
   * This method calculates the difference between the sum of the squares of the given upper bound
   * natural numbers and the square of the sum.
   * <p>
   *  A simple loop till the upper bound natural numbers and running sum of the natural numbers
   *  and also running sum of the squares of the numbers and then the difference is calculated.
   * </p>
   *
   * @param upperBound 'N' natural numbers to perform this operation for.
   * @return Difference of square of sum of natural numbers and sum of squares.
   */

  public int calculateDifferenceBetweenSumofSquaresAndSquareOfSum(int upperBound) {
    if(upperBound <=0 ){
      throw new IllegalArgumentException(ExceptionMessages.INPUT_NATURAL_NUMBER);
    }
    int totalSum = 0;
    int sumOfSquares = 0;
    for (int i = 1; i <= upperBound; i++) {
      totalSum = totalSum + i;
      sumOfSquares = sumOfSquares + (i * i);
    }
    return (totalSum * totalSum) - sumOfSquares;
  }


}
