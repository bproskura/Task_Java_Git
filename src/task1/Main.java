package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long numberCatalan;
        System.out.println("Enter the number: ");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt(); // enter a number from the keyboard


        numberCatalan = factorial(2*number)/(factorial(number)* factorial(number+1)); // formula for calculating Catalan number C(n) = (2n)!/n!(n+1)!
        System.out.println("Number of bracket expressions: " + numberCatalan);


    }
    static int factorial(int n){  // method for calculating factorial
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
}

