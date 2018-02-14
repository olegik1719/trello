package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;


/**
 * https://acmp.ru/index.asp?main=task&id_task=389
 *  Рассмотрим циклическую последовательность попарно различных чисел {a_0, a_1, … , a_(2^n-1)}, 0 ≤ a_i ≤ 2^n-1.
 *  Назовем эту последовательность кодом Грея, если любой a_i отличается от левого соседа a_(i-1)
 *  и правого соседа a_(i+1) только в одной цифре в двоичной записи этих чисел.
 *  Для a_0 левым соседом считается a_(2^n-1), а для a_(2^n-1) правым соседом считается a_0.
 *  Вася хочет запрограммировать игру-головоломку, которая будет позволять пользователю менять местами
 *  два любых числа a_i и a_j . Задача игрока – получить код Грея.
 *  Модуль, отвечающий за перестановку чисел, Вася берет на себя.
 *  А вот Ваша задача – написать программу, которая будет определять после каждой перестановки –
 *  является ли последовательность кодом Грея.
 *
 *  В первой строке входного файла INPUT.TXT содержится число n.
 *  В следующей строке перечислены попарно различные числа a_i.
 *  В третьей строке записано число m – количество перестановок, сделанных пользователем.
 *  В следующих m строках перечислены числа (i, j) – индексы переставляемых элементов.
 *  Ограничения: 1 ≤ n ≤ 16; 1 ≤ m ≤ 10^5; i≠j, 0 ≤ i, j < 2^n.
 *
 *  В выходной файл OUTPUT.TXT запишите m строчек – в i-той строке запишите «Yes»,
 *  если после i-той перестановки последовательность стала кодом Грея и «No» в противном случае.
 */

public class ACMP389 {

    private static HashSet<Integer> grayBroke = new HashSet<>();
    private static int[] grayArray;
    private static int nSize;
    private static int lastIndex;
    private static int diff;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        nSize = 1 << scanner.nextInt();
        grayArray = new int[nSize];
        for (int i = 0; i < nSize; i++){
            grayArray[i] = scanner.nextInt();
        }
        lastIndex = nSize - 1;
        for (int i = 0; i < nSize; i++) {
            grayCheck(i);
        }
        int mCount = scanner.nextInt();
        for (int i = 0; i<mCount;i++)
            printWriter.print(grayCheck(scanner.nextInt(), scanner.nextInt()));
        printWriter.flush();
    }

    private static String grayCheck(int perm01, int perm02){

        grayArray[perm01] = grayArray[perm01]^grayArray[perm02];
        grayArray[perm02] = grayArray[perm01]^grayArray[perm02];
        grayArray[perm01] = grayArray[perm01]^grayArray[perm02];
        grayCheck(perm01 - 1);
        grayCheck(perm02 - 1);
        grayCheck(perm01);
        grayCheck(perm02);
        if (grayBroke.isEmpty()) return "Yes\n";
        return "No\n";
    }

    private static void grayCheck(int indexToCheck){
        try{
            diff = grayArray[indexToCheck+1] ^ grayArray[indexToCheck];
            while (diff %2 == 0) diff >>>=1;
            if (diff == 1) grayBroke.remove(indexToCheck);
            else grayBroke.add(indexToCheck);
        }catch (Exception e){
            diff = grayArray[lastIndex] ^ grayArray[0];
            while (diff %2 == 0) diff >>>=1;
            if (diff == 1) grayBroke.remove(lastIndex);
            else grayBroke.add(lastIndex);
        }
    }
}
/* Ради пОнта! Ради =) Код, который стал победителем среди Java-кодов в задаче.
   В общем... На память=) О том, как писать НЕ НАДО!
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.HashSet;

public class Main {


    static HashSet<Integer> a = new HashSet<>();
    static int[] b;
    static int d;
    static int e;

    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        PrintWriter g = new PrintWriter(System.out);
        int c = 1 << f.nextInt();
        b = new int[c];
        for (int i = 0; i < c; i++){
            b[i] = f.nextInt();
        }
        d = c - 1;
        for (int i = 0; i < c; i++) {
            h(i);
        }
        int k = f.nextInt();
        for (int i = 0; i<k;i++)
            g.print(h(f.nextInt(), f.nextInt()));
        g.flush();
    }

    static String h(int l, int m){
        b[l] = b[l]^ b[m];
        b[m] = b[l]^ b[m];
        b[l] = b[l]^ b[m];
        h(l - 1);
        h(m - 1);
        h(l);
        h(m);
        if (a.isEmpty()) return "Yes\n";
        return "No\n";
    }

    static void h(int n){
        try{
            e = b[n+1] ^ b[n];
            while (e %2 == 0) e >>>=1;
            if (e == 1) a.remove(n);
            else a.add(n);
        }catch (Exception z){
            e = b[d] ^ b[0];
            while (e %2 == 0) e >>>=1;
            if (e == 1) a.remove(d);
            else a.add(d);
        }
    }
}
 */