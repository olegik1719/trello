package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
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

    private static boolean[] grayCheck;
    private static int[] grayArray;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        int nSize = 1 << scanner.nextInt();
        grayArray = new int[nSize];
        for (int i = 0; i < nSize; i++){
            grayArray[i] = scanner.nextInt();
        }
        int mCount = scanner.nextInt();
        int[] permutations = new int[2 * mCount];
        for (int i = 0; i<2*mCount;i++){
            permutations[i] = scanner.nextInt();
        }
        grayMake();
        for (int i = 0; i < mCount; i++) {
            printWriter.printf("%s%n",grayCheck(permutations[2*i], permutations[2*i+1])?"Yes":"No");
        }
        printWriter.flush();
    }

    private static void grayMake(){
        grayCheck = new boolean[grayArray.length];
        for (int i = 0; i < grayArray.length; i++) {
            grayCheck(i);
        }
    }

    private static boolean grayCheck(){
        for (int i = 0; i < grayCheck.length; i++) {
            if (!grayCheck[i]) return false;
        }
        return true;
    }

    private static int abs(int a) {
        return (a < 0) ? -a : a;
    }

    private static boolean grayCheck(int perm01, int perm02){
        int temp = grayArray[perm01];
        grayArray[perm01] = grayArray[perm02];
        grayArray[perm02] = temp;
        for (int i = -1; i < 1; i++) {
            grayCheck(perm01 + i);
            grayCheck(perm02 + i);
        }
        return grayCheck();
    }

    private static void grayCheck(int indexToCheck){
        if (indexToCheck == -1){
            indexToCheck += grayArray.length;
        }
        int diff = indexToCheck + 1 >= grayArray.length
                ?abs(grayArray[indexToCheck] ^ grayArray[0])
                :abs(grayArray[indexToCheck] ^ grayArray[indexToCheck+1]);
        while (diff%2==0) {
            diff >>>= 1;
        }
        grayCheck[indexToCheck]=(diff == 1);
    }
}
