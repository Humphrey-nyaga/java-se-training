package com.systechafrica.part1.hackerrank;

/*
Write a program that prints a staircase of size .

Function Description

Complete the staircase function in the editor below.

staircase has the following parameter(s):

int n: an integer
Print

Print a staircase as described above.

Input Format

A single integer, , denoting the size of the staircase.

Constraints

 .

Output Format

Print a staircase of size  using # symbols and spaces.

Note: The last line must have  spaces in it.

Sample Input
6
Sample Output

*    #
    ##
   ###
  ####
#####
######*/
public class Staircase {
    public static void staircase(int n) {
        for(int i = 1; i <= n;i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print("#");

            }
        }

    }

    public static void main(String[] args) {
        staircase(4);
    }
}
