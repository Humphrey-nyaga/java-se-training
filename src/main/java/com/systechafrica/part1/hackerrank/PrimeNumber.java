package com.systechafrica.part1.hackerrank;

public class PrimeNumber {

    public static boolean isPrime(int x) {

        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("7,000,007. " + isPrime(7000007));
        System.out.println("99999989 is Prime?" + isPrime(99999989));
        System.out.println("999,983 is Prime?" + isPrime(999983));
        System.out.println("99,983 " + isPrime(99983));
        System.out.println("97 " + isPrime(97));
        System.out.println("2" + isPrime(2));

    }
}
