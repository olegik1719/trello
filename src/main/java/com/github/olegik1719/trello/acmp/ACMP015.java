package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://acmp.ru/index.asp?main=task&id_task=15
 * В галактике «Milky Way» на планете «Snowflake» есть N городов, некоторые из которых соединены дорогами.
 * Император галактики «Milky Way» решил провести инвентаризацию дорог на планете «Snowflake».
 * Но, как оказалось, он не силен в математике, поэтому он просит вас сосчитать количество дорог.
 * Требуется написать программу, помогающую императору сосчитать количество дорог на планете «Snowflake».
 *
 * В первой строке входного файла INPUT.TXT записано число N (0 ≤ N ≤ 100).
 * В следующих N строках записано по N чисел, каждое из которых является единичкой или ноликом.
 * Причем, если в позиции (i, j) квадратной матрицы стоит единичка, то i-ый и j-ый города соединены дорогами,
 * а если нолик, то не соединены.
 *
 * В выходной файл OUTPUT.TXT необходимо вывести число, определяющее количество дорог на планете «Snowflake».
 */
public class ACMP015 {
    public static void main(String...a){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int size = sc.nextInt();
        int sum = 0;
        for (int i = size * size ; i > 0; i--)
            sum += sc.nextInt();
        pw.print(sum / 2);
        pw.flush();
    }
}
