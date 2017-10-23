package org.rakesh.projecteuler.problem16;

import java.math.BigInteger;
import org.apache.log4j.Logger;
import org.rakesh.projecteuler.common.ExceptionMessages;

/**
 * This program calculates the sum of the digits resulting from the power of an input number.
 * It's mostly aimed at solving the Problem 16 of Project Euler. The power's are huge.
 *
 * @author Rakesh Kandibanda
 * @version 1.0.0
 * @see <a href="https://projecteuler.net/problem=16">https://projecteuler.net/problem=16</a>
 */
public class PowerDigitSum {

  private final static Logger LOGGER = Logger.getLogger(PowerDigitSum.class);


  public static void main(String[] args) {
    PowerDigitSum powerDigitSum = new PowerDigitSum();
    long lStartTime = System.nanoTime();
    int digitSum = powerDigitSum.calculatePowerDigitSum(1000);
    long lEndTime = System.nanoTime();
    LOGGER.info("Execution time of " + PowerDigitSum.class.getSimpleName() + ": "
        + String.format("%.5f", ((lEndTime - lStartTime) / 1000000.0))
        + "(ms)");
    LOGGER.info("Total Digits (Sum of 2 raised to the Power Thousand) is: " + digitSum);
  }

  /**
   * The wrapper method that solves Problem 16 of Euler Project.
   * The power of base 2 is calculated by left shifting the binary ONE so many times as the power.
   *
   * @param power The power to be raised.
   * @return Total sum of digits of the input {@code power}
   */
  public int calculatePowerDigitSum(int power) {
    // Calculating the power of two using bit left shifting.
    BigInteger powerOfTwoRaisedThousand = BigInteger.ONE.shiftLeft(power);
    return sumDigits(powerOfTwoRaisedThousand);
  }

  /**
   * This method calculates the sum of the digits of the given number.
   * <p>
   * The input number is converted to String format and then
   * looped through individual character (converted to integer value from ASCII)
   * and summed up maintaining a running sum.
   * </p>
   *
   * @param inputNumber Input number whose sum of digits is to be calculated
   * @return Total sum of digits of the input {@code inputNumber}
   */

  public int sumDigits(BigInteger inputNumber) {
    if (inputNumber == null){
      throw new IllegalArgumentException(ExceptionMessages.INPUT_CANNOT_BE_NULL);
    }
    String numberString = inputNumber.toString();
    int runningSum = 0;
    for (int i = 0; i < numberString.length(); i++) {
      runningSum = runningSum + numberString.charAt(i) - '0';
    }
    return runningSum;
  }


}
