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

    private static int[] grayArray;
    private static boolean[] grayBool;
    private static int nSize;
    private static int lastIndex;
    private static int diff;
    private static int j;
    private static int[] pow2 = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768};
    //private static int temp;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);
        nSize = 1 << scanner.nextInt();
        grayBool = new boolean[nSize];
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
        int temp = grayArray[perm01];
        grayArray[perm01] = grayArray[perm02];
        grayArray[perm02] = temp;
        grayCheck(perm01 - 1);
        grayCheck(perm02 - 1);
        grayCheck(perm01);
        grayCheck(perm02);
        try {
            j = 0;
            while (grayBool[j++]){}
        }
        catch (Exception e){
            return "Yes\n";
        }
        return "No\n";
    }

    private static void grayCheck(int indexToCheck){
        try{
            diff = grayArray[indexToCheck+1] ^ grayArray[indexToCheck];
            if (diff == 1) grayBool[indexToCheck] = true;
            else if (diff <= 2) grayBool[indexToCheck] = diff == 2;
            else if (diff <= 4) grayBool[indexToCheck] = diff == 4;
            else if (diff <= 8) grayBool[indexToCheck] = diff == 8;
            else if (diff <= 16) grayBool[indexToCheck] = diff == 16;
            else if (diff <= 32) grayBool[indexToCheck] = diff == 32;
            else if (diff <= 64) grayBool[indexToCheck] = diff == 64;
            else if (diff <= 128) grayBool[indexToCheck] = diff == 128;
            else if (diff <= 256) grayBool[indexToCheck] = diff == 256;
            else if (diff <= 512) grayBool[indexToCheck] = diff == 512;
            else if (diff <= 1024) grayBool[indexToCheck] = diff == 1024;
            else if (diff <= 2048) grayBool[indexToCheck] = diff == 2048;
            else if (diff <= 4096) grayBool[indexToCheck] = diff == 4096;
            else if (diff <= 8192) grayBool[indexToCheck] = diff == 8192;
            else if (diff <= 16384) grayBool[indexToCheck] = diff == 16384;
            else grayBool[indexToCheck] = diff == 32768;

        }catch (Exception e){
            diff = grayArray[lastIndex] ^ grayArray[0];
            if (diff == 1) grayBool[lastIndex] = true;
            else if (diff <= 2) grayBool[lastIndex] = diff == 2;
            else if (diff <= 4) grayBool[lastIndex] = diff == 4;
            else if (diff <= 8) grayBool[lastIndex] = diff == 8;
            else if (diff <= 16) grayBool[lastIndex] = diff == 16;
            else if (diff <= 32) grayBool[lastIndex] = diff == 32;
            else if (diff <= 64) grayBool[lastIndex] = diff == 64;
            else if (diff <= 128) grayBool[lastIndex] = diff == 128;
            else if (diff <= 256) grayBool[lastIndex] = diff == 256;
            else if (diff <= 512) grayBool[lastIndex] = diff == 512;
            else if (diff <= 1024) grayBool[lastIndex] = diff == 1024;
            else if (diff <= 2048) grayBool[lastIndex] = diff == 2048;
            else if (diff <= 4096) grayBool[lastIndex] = diff == 4096;
            else if (diff <= 8192) grayBool[lastIndex] = diff == 8192;
            else if (diff <= 16384) grayBool[lastIndex] = diff == 16384;
            else grayBool[lastIndex] = diff == 32768;
        }
    }
}
