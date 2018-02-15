package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://acmp.ru/index.asp?main=task&id_task=9
 * Петя успевает по математике лучше всех в классе, поэтому учитель задал ему сложное домашнее задание,
 * в котором нужно в заданном наборе целых чисел найти сумму всех положительных элементов, 
 * затем найти где в заданной последовательности находятся максимальный и минимальный элемент
 * и вычислить произведение чисел, расположенных между ними. 
 * Так же известно, что минимальный и максимальный элемент встречаются в заданном множестве чисел только один раз.
 * Поскольку задач такого рода учитель дал Пете около ста, то Петя как сильный программист смог написать программу,
 * которая по заданному набору чисел самостоятельно находит решение.
 * А Вам слабо? 
 *
 * В первой строке входного файла INPUT.TXT записано единственное число N – количество элементов массива.
 * Вторая строка содержит N целых чисел, представляющих заданный массив.
 * Все элементы массива разделены пробелом. Каждое из чисел во входном файле не превышает 10^2 по абсолютной величине.
 *
 * В единственную строку выходного файла OUTPUT.TXT нужно вывести два числа,
 * разделенных пробелом: сумму положительных элементов и произведение чисел,
 * расположенных между минимальным и максимальным элементами.
 * Значения суммы и произведения не превышают по модулю 3*10^4.
 */
public class ACMP009 {
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        pw.println(check(array));
        pw.flush();
    }

    static String check(int[] input){
        int min = input[0];
        int minInd = 0;
        int max = input[0];
        int maxInd = 0;
        int summ = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) summ += input[i];
            if (input[i] > max) {
                max = input[i];
                maxInd = i;
            }else if (input[i] < min){
                min = input[i];
                minInd = i;
            }
        }
        int mult = 1;
        min = minInd < maxInd ? minInd:maxInd;
        max = minInd < maxInd ? maxInd:minInd;
        for (int i = min+1; i < max; i++) {
            mult *= input[i];
        }
        return ""+summ+ " " + mult;
    }
}
