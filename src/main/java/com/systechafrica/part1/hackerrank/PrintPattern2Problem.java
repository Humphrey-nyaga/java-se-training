package com.systechafrica.part1.hackerrank;

import java.util.Scanner;

public class PrintPattern2Problem {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len = 2 * n - 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int min = Math.min(Math.min(i, j), Math.min(len - i - 1, len - j - 1));
                System.out.print((n - min) + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

}
