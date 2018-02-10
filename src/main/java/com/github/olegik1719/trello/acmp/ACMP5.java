package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

public class ACMP5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        int size = scanner.nextInt();
        int[] days = new int[size];
        for (int i = 0; i < size; i++) {
            days[i] = scanner.nextInt();
        }
        int even = 0;
        int odd  = 0;
        int[]evens = new int[size];
        for (int i = 0; i<size;i++){
            if (days[i]%2==0)evens[even++] = days[i];
            else {
                printWriter.printf("%s ", days[i]);
                odd++;
            }
        }
        printWriter.printf("%n");
        for (int i = 0; i < even; i++) {
            printWriter.printf("%s ", evens[i]);
        }
        printWriter.printf("%n%s%n", odd>even?"NO":"YES");
        printWriter.flush();
    }
}
