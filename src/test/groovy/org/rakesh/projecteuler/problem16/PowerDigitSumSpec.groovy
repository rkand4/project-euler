package org.rakesh.projecteuler.problem16

import org.rakesh.projecteuler.common.ExceptionMessages
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by Rakesh on 10/22/17.
 */
class PowerDigitSumSpec extends Specification {

    @Shared
    PowerDigitSum powerDigitSum

    def setupSpec(){
        powerDigitSum = new PowerDigitSum()
    }

    @Unroll
    def "sum of digits of power power of 2" (){
        when:
        int digitsSumActual = powerDigitSum.calculatePowerDigitSum(powerExponent)

        then:
        digitsSumActual == digitsSumExpected

        where:
        powerExponent          || digitsSumExpected
        1                      || 2
        2                      || 4
        4                      || 7
        6                      || 10
        1000                   || 1366
    }

    @Unroll
    def "sum of individual digits of number" (){
        when:
            int digitsSumActual = powerDigitSum.sumDigits(inputNumber)
        then:
            digitsSumActual == digitsSumExpected

        where:
            inputNumber        || digitsSumExpected
        new BigInteger("1234") || 10
        new BigInteger("43621")|| 16
        new BigInteger("18")   || 9
    }

    @Unroll
    def "invalid input - sum of individual digits of number" (){
        when:
        powerDigitSum.sumDigits(inputNumber)

        then:
        def exception =thrown(resultExpected)
        exception.message == expectedMessage

        where:
        inputNumber || resultExpected           || expectedMessage
              null  || IllegalArgumentException || ExceptionMessages.INPUT_CANNOT_BE_NULL

    }



}