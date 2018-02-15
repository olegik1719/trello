package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://acmp.ru/index.asp?main=task&id_task=8
 *
 * Во входном файле INPUT.TXT записаны три натуральных числа A, B и C через пробел.
 * Числа A и B ≤ 10^2, а C ≤ 10^6.
 *
 * В выходной файл нужно вывести YES в том случае, если A*B=C и вывести NO в противном случае.
 */
public class ACMP008 {
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(sc.nextInt() * sc.nextInt() == sc.nextInt()? "YES" : "NO");
        pw.flush();
    }
}
