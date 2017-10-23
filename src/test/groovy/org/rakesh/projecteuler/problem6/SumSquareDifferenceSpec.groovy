package org.rakesh.projecteuler.problem6

import org.rakesh.projecteuler.common.ExceptionMessages
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by Rakesh on 10/22/17.
 */
class SumSquareDifferenceSpec extends Specification {


    @Shared
    SumSquareDifference sumSquareDifference;

    def setupSpec(){
        sumSquareDifference = new SumSquareDifference()
    }

    @Unroll
    def "difference of (sum of N natural numbers)^2 - sum(squares of N natural numbers)" () {

        when:
        int resultActual = sumSquareDifference.calculateDifferenceBetweenSumofSquaresAndSquareOfSum(upperBound)

        then:
        resultActual == resultExpected

        where:
        upperBound || resultExpected
                1  || 0
                2  || 4
                3  || 22
               100 || 25164150

    }

    def "invalid input - sum square difference" () {

        when:
        sumSquareDifference.calculateDifferenceBetweenSumofSquaresAndSquareOfSum(upperBound)

        then:
        def exception =thrown(resultExpected)
        exception.message == expectedMessage

        where:
        upperBound || resultExpected           || expectedMessage
                0  || IllegalArgumentException || ExceptionMessages.INPUT_NATURAL_NUMBER
               -1  || IllegalArgumentException || ExceptionMessages.INPUT_NATURAL_NUMBER

    }




}