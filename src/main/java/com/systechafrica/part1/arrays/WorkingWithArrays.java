package com.systechafrica.part1.arrays;

import java.util.logging.Logger;

public class WorkingWithArrays {
    private static final Logger LOGGER = Logger.getLogger(WorkingWithArrays.class.getName());

    public void singleDimensionalArray() {
        int[] numbers = { 45, 10, 26, 35, 40, 59 };
        String[] nicknames = { "Mhusika", "Ntate", "Yokana" };
        for (int number : numbers) {
            LOGGER.info("" + number);
        }
        LOGGER.info(nicknames[0]);
        LOGGER.info(nicknames[1]);
        LOGGER.info(nicknames[2]);
    }

    public void multiDimensionalArray() {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        // ?Multidimensional Array length - Length of parent array
        int length = matrix.length;
        LOGGER.info("Array Length - " + length);
        LOGGER.info("Number at index 8 =>: " + matrix[2][2]);

        // //2D arr declaration
        // int[][] matrix3 = new int[3][3]; //?2d array of length 3 with individual
        // arrays of length 3
        // int [][] matrix4;
        // matrix4 = new int[5][];

        // setting arr values
        int[][] matrix2 = new int[3][3]; // ?2d array of length 3
        // row 1
        matrix2[0][0] = 10;
        matrix2[0][1] = 12;
        // row 2
        matrix2[1][2] = 15;
        // row 3
        matrix2[2][0] = 20;
        matrix2[2][2] = 20;

        // iterate through the 2d array
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        WorkingWithArrays app = new WorkingWithArrays();
        // app.singleDimensionalArray();
        app.multiDimensionalArray();

    }
}
