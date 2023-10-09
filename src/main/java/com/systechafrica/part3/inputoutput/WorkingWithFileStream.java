package com.systechafrica.part3.inputoutput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkingWithFileStream {
    public static void main(String[] args) throws IOException {
        File file = new File("hello.txt");
        if (file.exists() && file.isFile()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    Scanner scanner = new Scanner(System.in);) {

                List<String> quotes = new ArrayList<>();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    quotes.add(line);
                }

                System.out.println("Enter a number from 1 to " + quotes.size() + " :");
                int option = scanner.nextInt();
                System.out.println(quotes.get(option - 1));
            } catch (IOException e) {
                System.err.println(e);
            }

        }
    }
}
