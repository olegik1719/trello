package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://acmp.ru/index.asp?main=task&id_task=14
 *  Требуется написать программу, определяющую наименьшее общее кратное (НОК) чисел a и b.
 *
 *  В единственной строке входного файла INPUT.TXT записаны два натуральных числа А и В через пробел,
 *  не превышающих 46340.
 *
 *  В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — НОК чисел А и В.
 */
public class ACMP014 {
    public static void main(String...a){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        pw.print(task(sc.nextInt(),sc.nextInt()));
        pw.flush();
    }

    static int task(int a, int b){
        return a / lcd (a,b) * b;
    }

    static int lcd (int a, int b){
        int min = a < b? a : b;
        int max = a > b? a : b;
        while (true){
            if (max % min == 0) return min;
            int temp = min;
            min = max % min;
            max = temp;
        }
    }
}
