package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.abs;

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
        for (int i = 0; i < mCount;i++){
            permutations[2*i] = scanner.nextInt();
            permutations[2*i+1] = scanner.nextInt();
        }
        grayMake();
        for (int i = 0; i < mCount; i++) {
            printWriter.printf("%s%n",grayPerm(permutations[2*i], permutations[2*i+1])?"Yes":"No");
        }
        printWriter.flush();
    }

    private static void grayMake(){
        grayCheck = new boolean[grayArray.length];
        for (int i = 0; i < grayArray.length-1; i++) {
            grayCheck[i]=isPow2(grayArray[i] ^ grayArray[i+1]);
        }
        grayCheck[grayCheck.length-1]=isPow2(grayArray[grayCheck.length-1] ^ grayArray[0]);
    }

//    private static void grayMake(int index){
//        if (index + 1 < grayCheck.length){
//            grayCheck[index]=isPow2(grayArray[index]^grayArray[index + 1]);
//        }else {
//            grayCheck[index] = isPow2(grayArray[index] ^ grayArray[0]);
//        }
//    }

    private static boolean grayCheck(){
        for (boolean aGrayCheck : grayCheck) {
            if (!aGrayCheck) return false;
        }
        return true;
    }

    private static boolean grayPerm(int perm01, int perm02){
        int temp = grayArray[perm01];
        grayArray[perm01] = grayArray[perm02];
        grayArray[perm02] = temp;
        grayMake();
//        for (int i = 0; i < 2; i++) {
//            grayMake(perm01 + i - 1);
//            grayMake(perm02 + i - 1);
//        }
        return grayCheck();
    }

    private static boolean isPow2(int power){
        //power = abs(power);
        if (power == 0) grayCheck[grayCheck.length-1] = false;
        while (power%2==0) {
            power >>>= 1;
        }
        return power == 1;
    }
}
