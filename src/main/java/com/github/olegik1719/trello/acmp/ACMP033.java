package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://acmp.ru/index.asp?main=task&id_task=33
 *  Бандиты Гарри и Ларри отдыхали на природе. Решив пострелять, они выставили на бревно несколько банок из-под кока-колы (не больше 10).
 *  Гарри начал простреливать банки по порядку, начиная с самой левой, Ларри — с самой правой.
 *  В какой-то момент получилось так, что они одновременно прострелили одну и ту же последнюю банку.
 *  Гарри возмутился и сказал, что Ларри должен ему кучу денег за то, что тот лишил его удовольствия прострелить несколько банок.
 *  В ответ Ларри сказал, что Гарри должен ему еще больше денег по тем же причинам.
 *  Они стали спорить кто кому сколько должен, но никто из них не помнил сколько банок было в начале, а искать простреленные банки по всей округе было неохота.
 *  Каждый из них помнили только, сколько банок прострелил он сам. Определите по этим данным, сколько банок не прострелил Гарри и сколько банок не прострелил Ларри.
 */

public class ACMP033 {
//    public static int[] nonShooted(int shutedByGarry, int shutedByLarry){
//        return new int[]{ shutedByLarry - 1, shutedByGarry - 1 };
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        int shotGarry = scanner.nextInt();
        int shotLarry = scanner.nextInt();
        printWriter.printf("%s %s%n", shotLarry - 1, shotGarry - 1);
        printWriter.flush();
    }
}
