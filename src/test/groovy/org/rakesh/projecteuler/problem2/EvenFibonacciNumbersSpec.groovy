package org.rakesh.projecteuler.problem2

import org.rakesh.projecteuler.common.ExceptionMessages
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by Rakesh on 10/22/17.
 */
class EvenFibonacciNumbersSpec extends Specification {


    @Shared
    EvenFibonacciNumbers evenFibonacciNumbers;

    def setupSpec(){
        evenFibonacciNumbers = new EvenFibonacciNumbers()
    }

    @Unroll
    def "sum of even terms in fibonacci series"() {
        //0,1,1,2,3,5,8,13,21,34,55,89...

        when:
        int resultSumOfEvenFibonacciTermsActual = evenFibonacciNumbers.getSumofEvenFibonacciNumbers(upperBound)

        then:
        resultSumOfEvenFibonacciTermsActual == resultSumOfEvenFibonacciTermsExpected

        where:
        upperBound || resultSumOfEvenFibonacciTermsExpected
                1  || 0
                2  || 2
                55 || 44
                89 || 44
           4000000 || 4613732

    }

    def "invalid input - sum of even terms fibonacci"(){
        when:
        evenFibonacciNumbers.getSumofEvenFibonacciNumbers(upperBound)

        then:
        def exception =thrown(resultExpected)
        exception.message == expectedMessage

        where:
        upperBound || resultExpected           || expectedMessage
                0  || IllegalArgumentException || ExceptionMessages.INPUT_NATURAL_NUMBER
               -1  || IllegalArgumentException || ExceptionMessages.INPUT_NATURAL_NUMBER

    }




}