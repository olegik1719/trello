package com.github.olegik1719.trello.acmp;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://acmp.ru/index.asp?main=task&id_task=6
 * Совсем недавно Вася занялся программированием и решил реализовать собственную программу для игры в шахматы.
 * Но у него возникла проблема определения правильности хода конем, который делает пользователь.
 * Т.е. если пользователь вводит значение «C7-D5», то программа должна определить это как правильный ход,
 * если же введено «E2-E4», то ход неверный. Так же нужно проверить корректность записи ввода:
 * если например, введено «D9-N5», то программа должна определить данную запись как ошибочную.
 * Помогите ему осуществить эту проверку!
 *
 * В единственной строке входного файла INPUT.TXT записан текст хода (непустая строка), который указал пользователь.
 * Пользователь не может ввести строку, длиннее 5 символов.
 *
 * В выходной файл OUTPUT.TXT нужно вывести «YES», если указанный ход конем верный,
 * если же запись корректна (в смысле правильности записи координат), но ход невозможен, то нужно вывести «NO».
 * Если же координаты не определены или заданы некорректно, то вывести сообщение «ERROR».
 */
public class ACMP006{

    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        String turn = sc.nextLine();
        pw.println(check(turn));
        pw.flush();

    }

    static String check(String turn){

        if (turn.length() != 5 ) return "ERROR";
        int charBegin = turn.charAt(0) - 'A';
        int digBegin = turn.charAt(1) - '1';
        int charEnd = turn.charAt(3) - 'A';
        int digEnd = turn.charAt(4) - '1';
        if (turn.charAt(2) != '-'
                || charBegin < 0 || charBegin > 7
                ||  digBegin < 0 ||  digBegin > 7
                ||   charEnd < 0 ||   charEnd > 7
                ||    digEnd < 0 ||    digEnd > 7 )
            return "ERROR";
        int turnChar = Math.abs(charBegin - charEnd);
        int turnDig  = Math.abs(digBegin  - digEnd);
        if (turnChar > 2 || turnChar < 1
                || turnDig > 2 || turnDig < 1
                || turnChar + turnDig != 3)
            return "NO";
        return "YES";
    }
}