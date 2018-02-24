package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * https://acmp.ru/index.asp?main=task&id_task=13
 * Петя и Вася часто играют в различные логические игры.
 * Недавно Петя поведал Васе о новой игре «Быки и коровы» и теперь они играют в эту игру сутками.
 * Суть игры очень проста: Петя загадывает четырехзначное число, состоящее из различных цифр.
 * Вася отгадывает задуманное Петей число, перебирая возможные варианты.
 * Каждый раз Вася предлагает вариант своего числа, а Петя делает Васе подсказку: сообщает количество быков и коров,
 * после чего Вася с учетом подсказки продолжает отгадывание числа до тех пор, пока не отгадает.
 * Быки – это количество цифр в предложенном Васей числе, совпадающих по значению
 * и стоящих в правильной позиции в задуманном Петей числе.
 * Коровы – количество цифр, совпадающих по значению, но находящихся в неверной позиции.
 * Например, если Петя задумал число 5671, а Вася предложил вариант 7251, то число быков равно 1
 * (только цифра 1 на своем месте), а число коров равно 2 (только цифры 7 и 5 не на своих местах).
 * Петя силен в математике, но даже он может ошибаться.
 * Помогите Пете написать программу, которая бы по загаданному Петей и предложенному
 * Васей числам сообщала количество быков и коров.
 *
 * В единственной строке входного файла INPUT.TXT записано два четырехзначных натуральных числа
 * A и B через пробел, где А – загаданное Петей число, а В – предложенный Васей вариант.
 *
 * В выходной файл OUTPUT.TXT нужно вывести два целых числа через пробел — количество быков и коров.
 */
public class ACMP013 {
    public static void main(String...a){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        pw.print(check(sc.nextInt(),sc.nextInt()));
        pw.flush();
    }

    static String check(int K, int N){
        int[] k_arr = new int[4];
        int[] n_arr = new int[4];
        k_arr[0] = K % 10;
        k_arr[1] = (K/10) % 10;
        k_arr[2] = (K/100) % 10;
        k_arr[3] = (K/1000) % 10;
        n_arr[0] = N % 10;
        n_arr[1] = (N/10) % 10;
        n_arr[2] = (N/100) % 10;
        n_arr[3] = (N/1000) % 10;
        int b = 0;
        int k = 0;
        for (int i = 0; i<4; i++){
            if (k_arr[i] == n_arr[i]) b++;
            else {
                for (int j = 0; j < 4; j++) {
                    if (k_arr[j] == n_arr[i]) k++;
                }
            }
        }
        return b + " " + k;
    }
}