package task3;

import java.math.BigInteger;

/**
 * To work with large numbers we use BigInteger
 */

public class Main {
    public static void main(String[] args) {
        long n = 100;
        long sum = 0;
        BigInteger fact = BigInteger.valueOf(1); // factorial starts at 1

        for (int i = 1; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i)); // calculate the factorial of 100
        }


        while (fact.compareTo(BigInteger.ZERO)>0){ // sum the digits of a number
            sum += fact.mod(BigInteger.TEN).longValue();
            fact = fact.divide(BigInteger.TEN);

        }
        System.out.println("The sum of the digits of a number = " + sum); // printing the result to the console


    }
}
