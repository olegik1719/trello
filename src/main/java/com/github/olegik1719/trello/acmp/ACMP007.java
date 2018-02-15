package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *  http://acmp.ru/index.asp?main=task&id_task=7
 *  Главный вождь племени Абба не умеет считать.
 *  В обмен на одну из его земель вождь другого племени предложил ему выбрать одну из трех куч с золотыми монетами.
 *  Но вождю племени Абба хочется получить наибольшее количество золотых монет.
 *  Помогите вождю сделать правильный выбор!
 *
 *  В первой строке входного файла INPUT.TXT записаны три натуральных числа через пробел.
 *  Каждое из чисел не превышает 10^100. Числа записаны без ведущих нулей.
 *
 *  В выходной файл OUTPUT.TXT нужно вывести одно целое число
 *  — максимальное количество монет, которые может взять вождь.
 */
public class ACMP007 {
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String input = sc.nextLine();
        pw.println(check(input));
        pw.flush();
    }

    static String check(String input){
        String[] heaps = input.split(" ");
        return max(max(heaps[0],heaps[1]),heaps[2]);
    }

    static String max(String str0, String str1){
        if (str0.length()!=str1.length())
            return str0.length() > str1.length()? str0:str1;
        return str0.compareTo(str1) > 0? str0:str1;
    }
}

