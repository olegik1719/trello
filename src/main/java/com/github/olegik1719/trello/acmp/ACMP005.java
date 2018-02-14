package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  https://acmp.ru/index.asp?main=task&id_task=5
 *  Вася не любит английский язык, но каждый раз старается получить хотя бы четверку за четверть,
 *  чтобы оставаться ударником. В текущей четверти Вася заметил следующую закономерность:
 *  по нечетным дням месяца он получал тройки, а по четным – четверки.
 *  Так же он помнит, в какие дни он получал эти оценки.
 *  Поэтому он выписал на бумажке все эти дни для того, чтобы оценить, сколько у него троек и сколько четверок.
 *  Помогите Васе это сделать, расположив четные и нечетные числа в разных строчках.
 *  Вася может рассчитывать на оценку 4, если четверок не меньше, чем троек.
 *
 *  В первой строке входного файла INPUT.TXT записано единственное число N
 *  – количество элементов целочисленного массива (1 ≤ N ≤ 100).
 *  Вторая строка содержит N чисел, представляющих заданный массив.
 *  Каждый элемент массива – натуральное число от 1 до 31. Все элементы массива разделены пробелом.
 *
 *  В первую строку выходного файла OUTPUT.TXT нужно вывести числа,
 *  которые соответствуют дням месяцев, в которые Вася получил тройки,
 *  а во второй строке соответственно расположить числа месяца, в которые Вася получил четверки.
 *  В третьей строке нужно вывести «YES», если Вася может рассчитывать на четверку и «NO» в противном случае.
 *  В каждой строчке числа следует выводить в том же порядке, в котором они идут во входных данных.
 *  При выводе, числа отделяются пробелом.
 */
public class ACMP005 {
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
